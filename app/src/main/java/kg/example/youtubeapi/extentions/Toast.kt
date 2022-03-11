package kg.example.youtubeapi.extentions

import android.content.Context
import android.widget.Toast

fun Context.addToast(text: String){
    Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
}