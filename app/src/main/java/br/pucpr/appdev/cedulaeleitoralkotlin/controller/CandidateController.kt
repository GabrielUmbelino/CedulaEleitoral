package br.pucpr.appdev.cedulaeleitoralkotlin.controller

import android.util.Log.d
import br.pucpr.appdev.cedulaeleitoralkotlin.model.Candidate
import com.google.gson.Gson
import java.util.ArrayList
class CandidateController {

    private var candidates: ArrayList<Candidate> = ArrayList()


    fun setCandidatesArray(json: String?) {
        this.candidates =  Gson().fromJson(json, Array<Candidate>::class.java).toList() as ArrayList<Candidate>
    }

    fun getCandidatesArray():List<Candidate> {
        return this.candidates
    }

    fun doVote(candidateNumber: Int?) {

        for (c: Candidate in this.getCandidatesArray()) {
            if (candidateNumber == c.number) {
                c.votes = c.votes?.plus(1)
            }
        }
        d("CandidatesController", "Candidates: $candidates")

    }

    fun getPercent(candidateVotes: Int?): String {
        var totalVotes = 0
        for (c: Candidate in this.getCandidatesArray()) {
            totalVotes = totalVotes.plus(c.votes!!)
        }
        var percent: Double = 0.0
        if (totalVotes == 0 ) {
            percent = 0.0
        } else {
            percent = candidateVotes?.toDouble()!!.div(totalVotes.toDouble())
        }
        return  String.format("%.0f", percent?.times(100))
    }


}