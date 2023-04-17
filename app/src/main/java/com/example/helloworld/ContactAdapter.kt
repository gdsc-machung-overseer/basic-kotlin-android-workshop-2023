package com.example.helloworld

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactAdapter(
    private val contacts: ArrayList<Contact>,

    // untuk menerapkan interface klik listener maka buat parameter sepert ini
    // parameter ini adalah fungsi, sehingga bisa diberikan param lagi yaitu data contact
    // lihat cara penggunaannya di home activity pada saat memanggil class ini
    val listener: (Contact) -> Unit
):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ContactViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.name.text = contacts[position].name //set nama
        holder.number.text = contacts[position].number //set nomor
        if(contacts[position].gender.equals("female")) { //kalau cewe
            holder.profile.setImageResource(R.drawable.female_profile) //kasi gambar cewe
        } else if(contacts[position].gender.equals("male")) { //kalau cowo
            holder.profile.setImageResource(R.drawable.male_profile) //kasi gambar cowo
        }


        // Memberikan data pada item recycler view ke fungsi klik interface
        holder.itemView.setOnClickListener{ listener(contacts[position]) }
    }
}

class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    var profile: ImageView = itemView.findViewById(R.id.contact_image) //gambar profile
    var name: TextView = itemView.findViewById(R.id.contact_name) //tulisan nama
    var number: TextView = itemView.findViewById(R.id.contact_number) //tulisan nomor
}