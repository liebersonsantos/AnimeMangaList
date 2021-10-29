package br.com.liebersonsantos.animemangalist.data.model

import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class SeasonResponse(
    val anime: MutableList<Anime>?
): Serializable