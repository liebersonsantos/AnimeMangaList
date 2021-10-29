package br.com.liebersonsantos.animemangalist.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
data class TopResponse(
    @SerializedName("request_hash")
    val requestHash : String,
    @SerializedName("request_cached")
    val requestCached : Boolean,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry : Int,
    @SerializedName("top")
    val top : MutableList<Top>
): Serializable
