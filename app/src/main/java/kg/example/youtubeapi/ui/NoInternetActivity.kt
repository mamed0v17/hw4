package kg.example.youtubeapi.ui

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import kg.example.youtubeapi.base.BaseActivity
import kg.example.youtubeapi.databinding.ActivityNoInternetBinding
import kg.example.youtubeapi.ui.playlist.ViewModel

class NoInternetActivity : BaseActivity<ViewModel, ActivityNoInternetBinding>() {
    override val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityNoInternetBinding {
        return ActivityNoInternetBinding.inflate(inflater)
    }
}
