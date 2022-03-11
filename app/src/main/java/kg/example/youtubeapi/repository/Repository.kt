package kg.example.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.BuildConfig
import kg.example.youtubeapi.`object`.Constant
import kg.example.youtubeapi.model.Playlist
import kg.example.youtubeapi.net.RetrofitClient
import kg.example.youtubeapi.net.result.Resource
import kg.example.youtubeapi.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        val data = MutableLiveData<Resource<Playlist>>()
        data.value = Resource.loading()
        apiService.getPlaylists(
            Constant.part,
            Constant.channelId,
            BuildConfig.API_KEY,
            Constant.maxResult
        )
            .enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    data.value = Resource.error(t.message)
                }
            })
        return data
    }
}