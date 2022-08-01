package com.nanda.customtheme

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.nanda.customtheme.databinding.ListNameBinding
import com.nanda.customtheme.response.DaftarPahlawanItem
import com.nanda.customtheme.response.Pahlawan
import com.nanda.customtheme.utils.HelperFunctions.loadJsonFromAssets

class NameAdapter(context : Context) : RecyclerView.Adapter<NameAdapter.MyViewHolder>() {

     class MyViewHolder(val binding: ListNameBinding) : RecyclerView.ViewHolder(binding.root)

    private val pahlawanList : List<DaftarPahlawanItem> = Gson()
        .fromJson(
            loadJsonFromAssets(context, FILENAME).toString(),
            Pahlawan::class.java
        ).daftarPahlawan as List<DaftarPahlawanItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        ListNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = pahlawanList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(photoPahlawan.context)
                .load(pahlawanList[position].img)
                .into(photoPahlawan)
            tvName.text = pahlawanList[position].nama
            tvAsal.text = pahlawanList[position].asal
        }
    }

    companion object {
        private const val FILENAME = "pahlawan_nasional.json"
    }
}