package kg.example.youtubeapi.net.result

data class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?) {

    companion object {
        fun <T> success(data: T?, code: Int? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, null, code)
        }

        fun <T> error(msg: String?, data: T? = null, code: Int? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg, code)
        }
        fun <T> loading(): Resource<T>{
            return Resource(Status.LOADING, null,null,null)
        }
    }
}
