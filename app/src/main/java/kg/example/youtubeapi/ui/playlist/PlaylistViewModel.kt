package kg.example.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.example.youtubeapi.BuildConfig.API_KEY
import kg.example.youtubeapi.`object`.Constant
import kg.example.youtubeapi.base.BaseViewModel
import kg.example.youtubeapi.model.Playlist
import kg.example.youtubeapi.remote.ApiService
import kg.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel: BaseViewModel() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlist(): LiveData<Playlist>{
        return getPlaylists()

    }

    private fun getPlaylists(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()
        apiService.getPlaylists(Constant.part,Constant.channelId, API_KEY, Constant.maxResult)
            .enqueue(object : Callback<Playlist>{
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful){
                        response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                }
            })
        return data
    }
}