package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.databinding.ActivityHomeBinding
import com.example.helloworld.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private var contacts : ArrayList<Contact> = ArrayList()
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        if(intent!=null) {
            if(intent.hasExtra("nama")) { //kalau ada variabel extra dengan nama "nama"
                supportActionBar?.title ="hello, ${intent.getStringExtra("nama")}" //ubah tulisan di toolbar
            }
        }

        setupRecyclerView()
        addDummyData()
    }

    /**
     * Memasang recycler view
     */
    private fun setupRecyclerView() {
        binding.rvContact.layoutManager = LinearLayoutManager(this)

        binding.rvContact.adapter = ContactAdapter(contacts) {
            // fungsi di dalam ini akan terpanggil ketika diklik, berkat parameter yang kita buat
            // di class ContactAdapter

            // it adalah data yang didapat ketika klik item di recycler view (Class Contact)
            // Bisa digunakan untuk mengirim data dari yang diklik ke Detail Activity jika ingin

            // Namun agar simple, untuk saat ini cukup tampilkan toast saja ketika diklik
            Toast.makeText(this@HomeActivity, it.name, Toast.LENGTH_SHORT).show()

            // Menuju ke detail activity
            val intent = Intent(this@HomeActivity, DetailActivity::class.java)
            intent.putExtra("DATA_CONTACT", it as java.io.Serializable)
            this.startActivity(intent)
        }
    }

    /**
     * Memberikan data dummy ke dalam array list
     * Bisa menggunakan for loop, while loop, atau loop yang lainnya jika ingin improvisasi kode
     */
    private fun addDummyData() {
        contacts.add(
            Contact("natasya",
                "081234567890",
                "female",
                "lyla1975@gmail.com",
                "215 Circle Drive",
                "Lorem is just like ipsum pidum")
        )

        contacts.add(Contact("fikri",
            "09127391827",
            "male",
            "jarod1993@hotmail.com",
            "3777 Goodwin Avenue",
            "Not just pidum, but also wipsum as well"))

        contacts.add(Contact("dito",
            "09128379182",
            "male",
            "maximo1982@gmail.com",
            "4617 Tea Berry Lane",
            "And nirum is just an example of it"))

        contacts.add(
            Contact("Melissa J Cook",
                "01927391847",
                "female",
                "albin_davi2@yahoo.com",
                "1998 Cody Ridge Road",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
        )

        contacts.add(Contact("Jacob J Clark",
            "019283012983",
            "male",
            "leanna.webe10@hotmail.com",
            "2304 Kenwood Place",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"))

        contacts.add(Contact("Carla R Stallworth",
            "019283019274",
            "male",
            "kasandra2007@gmail.com",
            "1267 Jerome Avenue",
            "when an unknown printer took a galley of type and scrambled it to make a type specimen book."))
    }
}