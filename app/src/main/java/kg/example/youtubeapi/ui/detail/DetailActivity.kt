package kg.example.youtubeapi.ui.detail

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import kg.example.youtubeapi.base.BaseActivity
import kg.example.youtubeapi.databinding.ActivityDetailBinding
import kg.example.youtubeapi.extentions.addToast
import kg.example.youtubeapi.ui.playlist.PlaylistActivity.Companion.ID
import kg.example.youtubeapi.ui.playlist.ViewModel

class DetailActivity : BaseActivity<ViewModel, ActivityDetailBinding>(){
    override val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylists().observe(this){
            val id = intent.getStringExtra(ID).toString()
            addToast(id)

        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(inflater)
    }

}