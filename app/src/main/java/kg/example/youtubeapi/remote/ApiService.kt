package kg.example.youtubeapi.remote


import kg.example.youtubeapi.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
         @Query("key") key: String,
        @Query("maxResult") maxResult: Int
    ):Call<Playlist>
}