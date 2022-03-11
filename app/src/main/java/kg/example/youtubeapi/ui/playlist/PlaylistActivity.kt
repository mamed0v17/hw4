package kg.example.youtubeapi.ui.playlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kg.example.youtubeapi.base.BaseActivity
import kg.example.youtubeapi.databinding.ActivityPlaylistBinding
import kg.example.youtubeapi.model.Playlist
import kg.example.youtubeapi.net.NetConnections
import kg.example.youtubeapi.net.result.Status
import kg.example.youtubeapi.ui.detail.DetailActivity


class PlaylistActivity : BaseActivity<ViewModel, ActivityPlaylistBinding>() {
    companion object {
        const val ID = "id"
    }

    override val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun initView() {
        super.initView()
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.getPlaylists().observe(this) {
            when (it.status) {
                Status.LOADING -> viewModel.loading.postValue(true)
                Status.SUCCESS -> {
                    initRv(it.data)
                    viewModel.loading.postValue(false)
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    //addToast(it.message)
                    viewModel.loading.postValue(false)
                }
            }
        }
        val networkConnection = NetConnections(applicationContext)
        networkConnection.observe(this) { isConnectd ->
            if (isConnectd) {
                binding.apply {
                    playlistRV.visibility = VISIBLE
                    noInet.visibility = INVISIBLE
                }
            }else{
                binding.apply {
                    noInet.visibility = VISIBLE
                    playlistRV.visibility = INVISIBLE
                }
        }
    }
}

private fun initRv(playlist: Playlist?) {
    binding.playlistRV.layoutManager = LinearLayoutManager(this)
    binding.playlistRV.adapter = playlist?.items?.let {
        PlaylistAdapter(it, this::listener)
    }

}

override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
    return ActivityPlaylistBinding.inflate(inflater)
}

fun listener(id: String) {
    Intent(this@PlaylistActivity, DetailActivity::class.java).apply {
        putExtra(ID, id)
        startActivity(this)
    }
}
}