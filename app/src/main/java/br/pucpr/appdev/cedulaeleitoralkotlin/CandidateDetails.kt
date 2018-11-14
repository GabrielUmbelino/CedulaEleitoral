package br.pucpr.appdev.cedulaeleitoralkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.pucpr.appdev.cedulaeleitoralkotlin.model.Candidate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.candidate_details.*
import org.jetbrains.anko.sdk27.coroutines.onClick



class CandidateDetails: AppCompatActivity() {
    var candidate = Candidate()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.candidate_details)
        candidate = intent.getSerializableExtra("candidate") as Candidate

        Picasso.get().load(candidate?.photo).into(product_image)
        btn_number.text = candidate?.number.toString()
        txt_name.text = candidate?.name
        txt_vice.text = candidate?.vice_president
        txt_party.text = candidate?.party


        btn_vote.onClick {
            val resultIntent = Intent()
            resultIntent.putExtra("candidate", candidate)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

    }
}