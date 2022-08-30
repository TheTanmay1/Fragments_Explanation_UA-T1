package com.unwiringapps.letsfeelfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


interface OnRemoveButtonTapListener          //using interface, declared, now this fragment will call it and main activity will define it, we are using interface to communicate between activity and fragments, that is when button on fragment is clicked it says activity to remove the fragments.
{
    fun onRemoveButtonTapped()
}


class FragmentLayout1 : Fragment() {

    private lateinit var caller: OnRemoveButtonTapListener  // as fragment will make the call, so here we are declaring the lateinit variable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentView1 = inflater.inflate(R.layout.fragment_layout1, container, false)

        val recyclerView = fragmentView1.findViewById<RecyclerView>(R.id.recycle1)

        recyclerView.layoutManager = LinearLayoutManager(activity as Context)

        val items = arrayOf("Great India", "Canada", "USA", "MEXICO", "CHILE")

//        val MyAdapter =  ArrayAdapter<String>(activity as Context, R.layout.row)


        recyclerView.adapter = MyAdapter(items)

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

    class MyViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(inflater.inflate(R.layout.row, parent, false))


    internal inner class MyAdapter(private val array: Array<String>) :
        RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

            val inflater = LayoutInflater.from(parent.context)

            return MyViewHolder(inflater, parent)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            (holder.itemView as TextView).text = array[position]

            holder.itemView.setOnClickListener {
                Toast.makeText(holder.itemView.context,"${array[position]} is clicked", Toast.LENGTH_LONG).show()
            }

        }

        override fun getItemCount() = array.size

    }


}