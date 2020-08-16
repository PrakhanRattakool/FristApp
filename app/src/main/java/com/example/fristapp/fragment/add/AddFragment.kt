package com.example.fristapp.fragment.add

import UserViewModel
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fristapp.R
import com.example.fristapp.database.User
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }
    private fun insertDataToDatabase(){
        val firstName = addfirstName.text.toString()
        val Phone = addphoneNumber.text

        if(inputCheck(firstName,Phone)) {
            val user = User(0, firstName, Integer.parseInt(Phone.toString()))

            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields.", Toast.LENGTH_LONG).show()
        }

    }
    private fun inputCheck(firstName: String,Phone: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && Phone.isEmpty())
    }
}