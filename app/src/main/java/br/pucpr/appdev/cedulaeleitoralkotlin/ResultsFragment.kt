package br.pucpr.appdev.cedulaeleitoralkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.pucpr.appdev.cedulaeleitoralkotlin.R.attr.layoutManager
import br.pucpr.appdev.cedulaeleitoralkotlin.controller.CandidateController
import kotlinx.android.synthetic.main.fragment_main.view.*

@SuppressLint("ValidFragment")
class ResultsFragment(val controller: CandidateController) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root  = inflater.inflate(R.layout.fragment_results, container,false)
        val candidates = controller.getCandidatesArray()

        root.recycler_view.apply {
            layoutManager = GridLayoutManager(activity, 1)
            adapter = CandidatesResultAdapter(candidates.toList(), controller)
        }
        return root
    }


}