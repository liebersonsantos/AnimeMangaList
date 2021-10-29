package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Published(
    @SerializedName("from")
    val from : String,
    @SerializedName("to")
    val to : String,
    @SerializedName("string")
    val string : String
): Serializable