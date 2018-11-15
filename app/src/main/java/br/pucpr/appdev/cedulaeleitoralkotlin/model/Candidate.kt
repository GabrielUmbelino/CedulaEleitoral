package br.pucpr.appdev.cedulaeleitoralkotlin.model

import java.io.Serializable

data class Candidate(
    val name: String? = null,
    val number: Int? = null,
    val party: String? = null,
    val vice_president: String? = null,
    var votes: Int? = null,
    val photo: String? = null,
    val color: String? = null
):Serializable {

}
