package com.unwiringapps.letsfeelfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.unwiringapps.letsfeelfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnRemoveButtonTapListener {


    // onRemoveButtonTapListener written there side of mainactivity class so as we make sure that our mainactivity confirms to that listener., then ovverride that functions.

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {


            if (savedInstanceState == null) // here we are checking save instance state , if this value is null, then only do that, it means that if you have an instance state thats between two session of the application, or when the application crashed whatever, don't do that. Run this only when there is no saved state already.
            {        // code for calling fragment
                supportFragmentManager.beginTransaction()
                    .add(R.id.framelayout1, FragmentLayout1.newInstance(), "MyTag").commit()   // this .newInstance() comes from the companion object created in fragment layout making sure that there will be only one instance.
                Toast.makeText(this,"Fragment 1 is Born \uD83D\uDE0D", Toast.LENGTH_LONG).show()
            }
        }
    }



    override fun onRemoveButtonTapped() {

        val frag = supportFragmentManager.findFragmentByTag("MyTag")

        if ( frag!= null ) {
            // code for closing fragment
            supportFragmentManager.beginTransaction().remove(frag).commit()
            Toast.makeText(this,"Fragment 1 Died \uD83E\uDD7A", Toast.LENGTH_LONG).show()
        }


    }
}