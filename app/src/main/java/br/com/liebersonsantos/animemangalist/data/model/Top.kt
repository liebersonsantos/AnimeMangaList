package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Top(
    @SerializedName("mal_id")
    val malId : Int?,
    @SerializedName("rank")
    val rank : Int?,
    @SerializedName("title")
    val title : String?,
    @SerializedName("url")
    val url : String?,
    @SerializedName("image_url")
    val imageUrl : String?,
    @SerializedName("type")
    val type : String?,
    @SerializedName("episodes")
    val episodes : Int?,
    @SerializedName("volumes")
    val volumes: Int?,
    @SerializedName("start_date")
    val startDate : String?,
    @SerializedName("end_date")
    val endDate : String?,
    @SerializedName("members")
    val members : Long?,
    @SerializedName("score")
    val score : Double?
): Serializable