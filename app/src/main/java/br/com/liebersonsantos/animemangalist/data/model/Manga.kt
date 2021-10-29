package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class Manga(
    @SerializedName("request_hash")
    val requestHash : String,
    @SerializedName("request_cached")
    val requestCached : Boolean,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry : Int,
    @SerializedName("mal_id")
    val malId : Int,
    @SerializedName("url")
    val url : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("title_japanese")
    val titleJapanese : String,
    @SerializedName("status")
    val status : String,
    @SerializedName("image_url")
    val imageUrl : String,
    @SerializedName("type")
    val type : String,
    @SerializedName("volumes")
    val volumes : Int,
    @SerializedName("chapters")
    val chapters : Int,
    @SerializedName("published")
    val published : Published,
    @SerializedName("score")
    val score : Double,
    @SerializedName("scored_by")
    val scoredBy : Int,
    @SerializedName("popularity")
    val popularity : Int,
    @SerializedName("members")
    val members : Int,
    @SerializedName("favorites")
    val favorites : Int,
    @SerializedName("synopsis")
    val synopsis : String,
    @SerializedName("background")
    val background : String,
    @SerializedName("genres")
    val genres : List<Genre>,
    @SerializedName("authors")
    val authors : List<Authors>,
): Serializable