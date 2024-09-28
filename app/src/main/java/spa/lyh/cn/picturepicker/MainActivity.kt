package spa.lyh.cn.picturepicker

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly
import androidx.appcompat.app.AppCompatActivity
import com.luck.picture.lib.config.Crop
import spa.lyh.cn.picturepicker.databinding.ActivityMainBinding
import spa.lyh.cn.picturepicker.pic.ImageFileCropEngine

class MainActivity:AppCompatActivity() {
    lateinit var b: ActivityMainBinding
    lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>
    lateinit var pickMultipleMedia: ActivityResultLauncher<ActivityResultContracts.PickMultipleVisualMedia>
    lateinit var ifce:ImageFileCropEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        ifce = ImageFileCropEngine(this)
        pickMedia = registerForActivityResult<PickVisualMediaRequest, Uri>(
            ActivityResultContracts.PickVisualMedia()
        ) { result ->
            if (result != null) {
                Log.e("qwer", "Selected URI: \$uri")
                ifce.onStartCrop(this,result)
            } else {
                Log.e("qwer", "No media selected")
            }
        }

        val pickMultipleMedia =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(5)) { uris ->
                // Callback is invoked after the user selects media items or closes the
                // photo picker.
                if (uris.isNotEmpty()) {
                    Log.e("qwer", "Number of items selected: ${uris.size}")
                    ifce.onStartCrop(this,uris)
                } else {
                    Log.e("qwer", "No media selected")
                }
            }

        b.btn.setOnClickListener {
/*            pickMedia.launch(
                PickVisualMediaRequest.Builder()
                    .setMediaType(ImageOnly)
                    .build()
            )*/

            pickMultipleMedia.launch(
                PickVisualMediaRequest.Builder().setMediaType(ImageOnly).build())
        }
    }
}