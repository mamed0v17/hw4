package kg.example.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import kg.example.youtubeapi.App
import kg.example.youtubeapi.base.BaseViewModel
import kg.example.youtubeapi.model.Playlist
import kg.example.youtubeapi.net.result.Resource

class ViewModel(): BaseViewModel() {
    fun getPlaylists(): LiveData<Resource<Playlist>>{
        return App().repository.getPlaylists()
    }
}