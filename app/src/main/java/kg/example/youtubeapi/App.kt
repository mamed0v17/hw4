package kg.example.youtubeapi

import android.app.Application
import kg.example.youtubeapi.repository.Repository

class App: Application() {
    val repository:Repository by lazy {
        Repository()
    }
}