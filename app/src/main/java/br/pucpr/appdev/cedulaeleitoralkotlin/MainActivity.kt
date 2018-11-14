package br.pucpr.appdev.cedulaeleitoralkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.util.Log.d
import android.view.MenuItem
import br.pucpr.appdev.cedulaeleitoralkotlin.controller.CandidateController
import br.pucpr.appdev.cedulaeleitoralkotlin.model.Candidate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity() {
    val candidateController = CandidateController()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val json = application?.assets?.open("candidates.json")?.bufferedReader().use{
            it?.readText()
        }

        candidateController.setCandidatesArray(json)
        supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, MainFragment(candidateController))
                .commit()
        navigationView.setNavigationItemSelectedListener{
            drawerLayout.closeDrawers()
            when (it.itemId) {
                R.id.action_home -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, MainFragment(candidateController))
                            .commit()

                }
                R.id.action_results -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, ResultsFragment(candidateController))
                            .commit()
                }
            }
            it.isChecked = true
            true
        }
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.menu)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val candidate = data?.getSerializableExtra("candidate") as Candidate
                candidateController.doVote(candidate.number)
            }
        }

    }


}
