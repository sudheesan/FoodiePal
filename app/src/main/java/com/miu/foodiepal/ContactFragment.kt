package com.miu.foodiepal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.foodiepal.databinding.FragmentContactBinding
import com.miu.foodiepal.databinding.FragmentRecipesBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding
    lateinit var contacts: ArrayList<Contact>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_contact, container, false)
        binding = FragmentContactBinding.bind(view)

        contacts = arrayListOf(
            Contact("Sudhee", "+16412440978", "Sudhee@abc.com"),
            Contact("Amit", "+16412440978", "Amit@abc.com"),
            Contact("Mak", "+16412440978", "Mak@abc.com"),
            Contact("Sandi", "+16412440978", "Sandi@abc.com"),
            Contact("Tom", "+16412440978", "Tom@abc.com")
        )

        val contactCardViewAdapter = ContactCardViewAdapter(requireContext(), contacts)
        binding.rvContact.adapter = contactCardViewAdapter
        binding.rvContact.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

}