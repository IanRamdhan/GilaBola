package com.fryanramzkhar.recyleviewkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

//TODO : Class RecycleAdapter mewariskan RecycleView
class RecyleAdapter (val context: Context, val items: List<Item>, val listener : (Item) -> Unit ): RecyclerView.Adapter<RecyleAdapter.ViewHolder>() {
    //TODO : Mengimplementasikan Method dari RecycleView
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_club, viewGroup, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        //TODO : Menghitung data yang akan ditampilkan
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items[position],listener)
    }

    //TODO : Membuat Kelas ViewHolder untuk berinteraksi dengan tampilan Layout
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaClub = view.txtNamaClub
        val gambarLogoClub = view.imgLogoClub

        //TODO : Membuat Fun untuk Menampilkan namaClub dan lain"
        fun bindItem (item: Item, listener: (Item) -> Unit) {
            namaClub.text = item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambarLogoClub)
            //TODO : Membuat onClicknya
            itemView.onClick {
                listener(item)
            }

        }
    }

}