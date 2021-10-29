package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Anime(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("trailer_url")
    var trailerUrl: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("score")
    var score: Double?,
    @SerializedName("synopsis")
    var synopsis: String?,
    @SerializedName("episodes")
    var episodes: Int?,
    @SerializedName("favorites")
    var favorites: Int?,
    @SerializedName("rank")
    var rank: Int?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("genres")
    var genres: List<Genre>?
): Serializable