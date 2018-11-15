package br.pucpr.appdev.cedulaeleitoralkotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.pucpr.appdev.cedulaeleitoralkotlin.controller.CandidateController
import br.pucpr.appdev.cedulaeleitoralkotlin.model.Candidate
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.eazegraph.lib.charts.BarChart
import org.eazegraph.lib.models.BarModel

@SuppressLint("ValidFragment")
class ResultsFragment(val controller: CandidateController) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root  = inflater.inflate(R.layout.fragment_results, container,false)

        root.recycler_view.apply {
            layoutManager = GridLayoutManager(activity, 1)
            adapter = CandidatesResultAdapter(controller.getCandidatesArray().toList(), controller)
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val chart = getActivity()!!.findViewById(R.id.barchart) as BarChart

        for (c: Candidate in controller.getCandidatesArray()) {
            chart.addBar(BarModel("${controller.getPercent(c.votes)}%", c.votes!!.toFloat(), Color.parseColor(c.color)))
        }

        chart.startAnimation()
    }
}