package ir.nima.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.dunijet.animation.ext.BaseActivity
import ir.nima.navigationcomponent.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}