package com.example.fristapp.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fristapp.R
import kotlinx.android.synthetic.main.fragment_list.view.*

class  ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        return view
    }
}