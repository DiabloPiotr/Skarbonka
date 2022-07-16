package com.example.skarbonka

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_skarbonka.view.*

class SkarbonkaAdapter (
    private val skarbonki: MutableList<Skarbonka>
    ) : RecyclerView.Adapter<SkarbonkaAdapter.SkarbonkaViewHolder>(){
    class SkarbonkaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkarbonkaViewHolder {
        return SkarbonkaViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_skarbonka,
                parent,
                false
            )
        )
    }

    private fun dodawanieDoSkarbonki(curSkarbonka: Skarbonka, tvAktualnaIlosc: TextView){
        curSkarbonka.aktualna_wartosc+=curSkarbonka.domyslna_ilosc
        tvAktualnaIlosc.text = curSkarbonka.aktualna_wartosc.toString()
    }
    private fun odejmowanieZeSkarbonki(curSkarbonka: Skarbonka, tvAktualnaIlosc: TextView){
        curSkarbonka.aktualna_wartosc-=curSkarbonka.domyslna_ilosc
        tvAktualnaIlosc.text = curSkarbonka.aktualna_wartosc.toString()
    }
    fun nowaSkarbonka(nazwa: String, cel: Int, domyslna_ilosc: Int, aktualna_wartosc: Int){
        skarbonki.add(Skarbonka(nazwa, cel, domyslna_ilosc, aktualna_wartosc))
        notifyItemInserted(skarbonki.size - 1)
    }
    fun usuwanieSkarbonki(position: Int){
        skarbonki.removeAt(position)
        notifyItemRemoved(position)
    }
    fun edytujSkarbonke(nazwa: String, cel: Int, domyslna_ilosc: Int, aktualna_wartosc: Int, position: Int){
        skarbonki[position] = Skarbonka(nazwa, cel, domyslna_ilosc, aktualna_wartosc)
        notifyItemChanged(position)
    }

    override fun onBindViewHolder(holder: SkarbonkaViewHolder, position: Int) {
        val curSkarbonka = skarbonki[position]
        holder.itemView.apply {
            tvNazwa.text = curSkarbonka.nazwa
            tvCel.text = curSkarbonka.cel.toString()
            tvAktualnaIlosc.text = curSkarbonka.aktualna_wartosc.toString()
            przyciskIleDodac.text = curSkarbonka.domyslna_ilosc.toString()
            przyciskDodajdoAktualnego.setOnClickListener {
                dodawanieDoSkarbonki(curSkarbonka, tvAktualnaIlosc)
            }
            przyciskUsunzAktualnego.setOnClickListener {
                odejmowanieZeSkarbonki(curSkarbonka, tvAktualnaIlosc)
            }
        }
    }

    override fun getItemCount(): Int {
        return skarbonki.size
    }
}