package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Genre(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
): Serializable