package tw.edu.pu.gm.o1083020.glide

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation
import tw.edu.pu.gm.o1083027.glide.GlideApp
import tw.edu.pu.gm.o1083027.glide.GlideOptions.bitmapTransform
import tw.edu.pu.gm.o1083027.glide.R
import java.lang.System.load

@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var img1: ImageView = findViewById(R.id.img)
        img1.setImageResource(R.drawable.earth)
        val multi = MultiTransformation<Bitmap>(
            GrayscaleTransformation() ,
            SketchFilterTransformation()
        )

        GlideApp.with(this)


        // .load(R.drawable.earth)

                .load("https://b.blog.xuite.net/b/b/5/2/11519069/blog_78644/txt/243420413/4.jpg")
                .placeholder(R.drawable.processing)
                .error(R.drawable.error)
                .listener(object: RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        Toast.makeText(baseContext, "圖片載入失敗", Toast.LENGTH_LONG).show()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        Toast.makeText(baseContext, "圖片載入成功", Toast.LENGTH_LONG).show()
                        return false
                    }

                })
                .circleCrop()
                .override(800, 600)

            .apply(bitmapTransform(multi))
            .into(img1)



    }

}