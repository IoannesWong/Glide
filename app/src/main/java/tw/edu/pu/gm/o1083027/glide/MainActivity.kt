package tw.edu.pu.gm.o1083027.glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var img: ImageView = findViewById(R.id.img)
        img.setImageResource(R.drawable.earth)
        GlideApp.with(this)
                .load(R.drawable.earth)
                .into(img)


    }
}