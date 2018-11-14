package br.pucpr.appdev.cedulaeleitoralkotlin

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.pucpr.appdev.cedulaeleitoralkotlin.controller.CandidateController
import br.pucpr.appdev.cedulaeleitoralkotlin.model.Candidate
import com.squareup.picasso.Picasso

class CandidatesResultAdapter(private val candidates: List<Candidate>, val controller: CandidateController) : RecyclerView.Adapter<CandidatesResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.candidate_results_row, parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun getItemCount() = candidates.size

    override fun onBindViewHolder(holder: CandidatesResultAdapter.ViewHolder, position: Int) {
        val candidate  = candidates[position]
        Picasso.get().load(candidate.photo).into(holder.photo)
        holder.name.text = candidate.name
        holder.number.text = candidate.number.toString()
        holder.party.text = candidate.party
        holder.percent.text = "${controller.getPercent(candidate.votes)}%"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.candidate_name)
        val number: TextView = itemView.findViewById(R.id.candidate_number)
        val party: TextView = itemView.findViewById(R.id.candidate_party)
        val photo: ImageView = itemView.findViewById(R.id.candidate_photo)
        val percent: TextView = itemView.findViewById(R.id.candidate_percentage)
    }
}