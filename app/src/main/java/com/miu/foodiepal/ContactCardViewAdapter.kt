package com.miu.foodiepal

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ContactCardViewAdapter(var context: Context, var cList: ArrayList<Contact>): RecyclerView.Adapter<ContactCardViewAdapter.MyViewHolder> () {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactCardViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.contact_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactCardViewAdapter.MyViewHolder, position: Int) {
        val constraintLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.contactCardLayout)
        val emailButton = holder.itemView.findViewById<ImageButton>(R.id.buttonContactEmail)
        val callButton = holder.itemView.findViewById<ImageButton>(R.id.buttonContactCall)

        constraintLayout.apply {
            val name = findViewById<TextView>(R.id.textContactName)
            val phone = findViewById<TextView>(R.id.textContactPhone)
            val email = findViewById<TextView>(R.id.textContactEmail)
            name.text = cList[position].name
            phone.text = cList[position].phone
            email.text = cList[position]. email
        }

        emailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setPackage("com.google.android.gm")
            intent.data = Uri.parse("mailto:${cList[position].email}")
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                // Handle if no email client is available to handle the Intent
                Toast.makeText(context, "No email app found", Toast.LENGTH_SHORT).show()
            }
        }

        callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${cList[position].phone}")
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "No dialer app found", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun getItemCount(): Int {
        return cList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}