package kg.example.youtubeapi.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.youtubeapi.R
import kg.example.youtubeapi.databinding.ItemPlaylistBinding
import kg.example.youtubeapi.extentions.glide
import kg.example.youtubeapi.model.Items


class PlaylistAdapter(
    private val playlist: List<Items>,
    private val onClickVideo: (id: String) -> Unit
) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    private lateinit var binding: ItemPlaylistBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistAdapter.ViewHolder {
        binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistAdapter.ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int {
        return playlist.size
    }

    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.apply {
                tvCount.text= String.format(itemView.context.getString(R.string.video),items.contentDetails.itemCount.toString())
            tvTitle.text= items.snippet.title
                ivPlaylist.glide(items.snippet.thumbnails.high.url)
                channelTitle.text = items.snippet.channelTitle
                itemView.setOnClickListener {
                    onClickVideo(items.id)
                }
            }
        }
    }
}