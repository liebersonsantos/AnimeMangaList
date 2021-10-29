package br.com.liebersonsantos.animemangalist.data.core

/**
 * Created by lieberson on 10/17/21.
 * @author lieberson.xsantos@gmail.com
 */
sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null,
    val loading: Boolean? = true
) {
    class Success<T>(data: T): Resource<T>(data = data, loading = false)
    class Error<T>(error: Throwable, data: T? = null): Resource<T>(data = data, error = error, loading = false)
}