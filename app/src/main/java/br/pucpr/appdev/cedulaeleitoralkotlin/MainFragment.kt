package br.pucpr.appdev.cedulaeleitoralkotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.pucpr.appdev.cedulaeleitoralkotlin.controller.CandidateController
import kotlinx.android.synthetic.main.fragment_main.view.*



@SuppressLint("ValidFragment")
class MainFragment(val controller: CandidateController) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root  = inflater.inflate(R.layout.fragment_main, container,false)
        val candidates = controller.getCandidatesArray()

        root.recycler_view.apply {
            layoutManager = GridLayoutManager(activity, 1)
            adapter = CandidatesAdapter(candidates.toList())
        }
        return root
    }
}