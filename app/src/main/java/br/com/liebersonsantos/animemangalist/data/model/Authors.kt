package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Authors(
    @SerializedName("mal_id")
    val malId : Int,
    @SerializedName("type")
    val type : String,
    @SerializedName("name")
    val name : String,
    @SerializedName("url")
    val url : String
): Serializable