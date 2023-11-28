package ir.nima.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.dunijet.animation.ext.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}