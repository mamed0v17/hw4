package kg.example.youtubeapi.ui.playlist

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import kg.example.youtubeapi.base.BaseActivity
import kg.example.youtubeapi.databinding.ActivityPlaylistBinding


class PlaylistActivity : BaseActivity<PlaylistViewModel,ActivityPlaylistBinding>() {
    override val viewModel: PlaylistViewModel  by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }
}