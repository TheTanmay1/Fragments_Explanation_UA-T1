package com.unwiringapps.letsfeelfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unwiringapps.letsfeelfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnRemoveButtonTapListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {


            if (savedInstanceState == null)
            {
                supportFragmentManager.beginTransaction()
                    .add(R.id.framelayout1, FragmentLayout1.newInstance(), "MyTag").commit()
            }
        }
    }

    override fun onRemoveButtonTapped() {

        val frag = supportFragmentManager.findFragmentByTag("MyTag")

        if ( frag!= null ) {
            supportFragmentManager.beginTransaction().remove(frag).commit()
        }


    }
}