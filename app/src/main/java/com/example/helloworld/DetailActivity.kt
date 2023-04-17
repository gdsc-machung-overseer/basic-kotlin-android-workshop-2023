package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.helloworld.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        // Ambil data dari extra,
        // lalu simpan ke variable detailData yang berasal dari variable layout activity_detail.xml
        binding.detailData = intent.extras?.getSerializable("DATA_CONTACT") as Contact?
    }
}