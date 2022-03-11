package kg.example.youtubeapi.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class Playlist(

    val kind: String? = null,
    @SerializedName("etag")
    val tag: String? = null,
    val items: ArrayList<Items>,
    val snippet: Snippet,
    val pageInfo: PageInfo
)
data class Thumbnails(
    var default: Default,
    var medium: Medium,
    var high: High,
    var maxres: Maxres
)

data class Snippet(
    var publishedAt: String,
    var channelId: String,
    var title: String? = null,
    var description: String? = null,
    var thumbnails: Thumbnails,
    var channelTitle: String,
    var tags: List<String>,
    var categoryId: String,
    var liveBroadcastContent: String,
    var localized: Localized
)

data class PageInfo(
    var totalResults: Int,
    var resultsPerPage: Int
)

class Maxres(
    var url: String,
    var width: Int,
    var height: Int


)

data class Medium(
    var url: String,
    var width: Int,
    var height: Int
)

data class Localized(
    var title: String,
    var description: String
)

data class Items(
    var kind: String,
    var etag: String,
    var id: String,
    var snippet: Snippet,
    var contentDetails: ContentDetails
)

data class High(
    var url: String,
    var width: Int,
    var height: Int
)

data class Default(
    var url: String,
    var width: Int,
    var height: Int
)

data class ContentRating(val name: String = "")

data class ContentDetails(
    var duration: String,
    var dimension: String,
    var definition: String,
    var caption: String,
    var licensedContent: Boolean,
    var contentRating: ContentRating,
    var projection: String,
    var itemCount: Int,
)
