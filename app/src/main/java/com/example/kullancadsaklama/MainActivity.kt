package com.example.kullancadsaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.example.kullancadsaklama", Context.MODE_PRIVATE)

        val veri = findViewById<EditText>(R.id.editText_Veri)
        val kaydet = findViewById<Button>(R.id.button_kaydet)
        val textView_a: TextView = findViewById(R.id.textView_a)
        val button_sil : Button = findViewById(R.id.button_sil)

        kaydet.setOnClickListener {
            val kullaniciAdi = veri.text.toString()
            if (kullaniciAdi.isEmpty()) {
                Toast.makeText(this, "Lütfen bir deger giriniz!", Toast.LENGTH_SHORT).show()
            } else {
                sharedPreferences.edit().putString("k_Adi", kullaniciAdi).apply()
                textView_a.text = "Veri: $kullaniciAdi" // girilen kodu TextView'de göster
                veri.text.clear()//ViewText'i temizle
            }
        }//kaydet parantezi


        button_sil.setOnClickListener(View.OnClickListener {
            veri.text.clear() // EditText'i temizle
            textView_a.text="" // TextView'i içini siliyoruz yani boş bırakıyoruz.
            Toast.makeText(this,"TerTemiz",Toast.LENGTH_SHORT).show()
        })


    }// ana metod parantezi
}//sinif parantezi
