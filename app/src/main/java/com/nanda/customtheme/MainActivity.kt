package com.nanda.customtheme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanda.customtheme.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null

    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvList.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = NameAdapter(context)
    }


    }

}