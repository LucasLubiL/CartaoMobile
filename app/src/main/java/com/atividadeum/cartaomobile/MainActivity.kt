package com.atividadeum.cartaomobile

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text
import java.util.Locale
import java.util.Locale.getDefault

class MainActivity : AppCompatActivity() {

    private lateinit var txtNomeCartao: TextView;
    private lateinit var editNome: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.card_front)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtNomeCartao = findViewById(R.id.txtNomeCartao);
        editNome = findViewById(R.id.editNome);

        editNome.addTextChangedListener{
            aoDigitar(it.toString());
        }

    }

    fun aoDigitar(texto: String){
        if(texto.length < 20){

            txtNomeCartao.text = texto.uppercase(getDefault());
        }
    }


}