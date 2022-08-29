package com.unwiringapps.letsfeelfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button



interface OnRemoveButtonTapListener          //using interface, declared, now this fragment will call it and main activity will define it
{
    fun onRemoveButtonTapped ()
}


class FragmentLayout1 : Fragment() {

    private lateinit var caller : OnRemoveButtonTapListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?

    {
        // Inflate the layout for this fragment
        val fragmentView1 =  inflater.inflate(R.layout.fragment_layout1, container, false)

        val myButton = fragmentView1.findViewById<Button>(R.id.button2)

        myButton.setOnClickListener{
          caller.onRemoveButtonTapped()
        }

        return fragmentView1
    }

    companion object {

        fun newInstance(): FragmentLayout1 {
            return FragmentLayout1()

        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRemoveButtonTapListener)
        {
            caller = context
        }
    }

}