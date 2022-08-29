package com.unwiringapps.letsfeelfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button



interface OnRemoveButtonTapListener          //using interface, declared, now this fragment will call it and main activity will define it, we are using interface to communicate between activity and fragments, that is when button on fragment is clicked it says activity to remove the fragments.
{
    fun onRemoveButtonTapped ()
}


class FragmentLayout1 : Fragment() {

    private lateinit var caller : OnRemoveButtonTapListener  // as fragment will make the call, so here we are declaring the lateinit variable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?

    {
        // Inflate the layout for this fragment
        val fragmentView1 =  inflater.inflate(R.layout.fragment_layout1, container, false)

        val myButton = fragmentView1.findViewById<Button>(R.id.button2)

        myButton.setOnClickListener{
          caller.onRemoveButtonTapped()   // when button is clicked, i want the caller to do the call, hey ? remove!! me. and then the mainactivity will listen this.
        }

        return fragmentView1
    }

     /*
     this is the companion object which returns the fragment, and it basically return my fragment
     This companion object makes sure, your object is only one instance of it, so if you have multiple
    fragments or populating multiple of these, you always make sure that there is only one copy of that
    */

    companion object {


        fun newInstance(): FragmentLayout1 {
            return FragmentLayout1()

        }

    }

    // we need "onAttach" as we want to initialise the "caller"
    //ONATTACH is when you attach the fragments, and the good news is it knows where it has attached it.

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRemoveButtonTapListener)
        {
            caller = context
        }
    }

}