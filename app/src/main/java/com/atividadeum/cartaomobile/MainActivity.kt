package com.atividadeum.cartaomobile

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text
import java.util.Locale
import java.util.Locale.getDefault

class MainActivity : AppCompatActivity() {

    private lateinit var cardFlipper: ViewFlipper;
    private lateinit var cardView: CardView;


    private lateinit var txtNomeCartao: TextView;
    private lateinit var txtCVVCartao: TextView;
    private lateinit var txtValidadeCartao: TextView;
    private lateinit var txtNumeroCartao: TextView;


    private lateinit var editNome: EditText;
    private lateinit var editNumero: EditText;
    private lateinit var editCVV: EditText;
    private lateinit var editValidade: EditText;


    private lateinit var btnEditar: Button;
    private lateinit var btnSalvar: Button;

    private lateinit var imgBandeiraFront: ImageView;
    private lateinit var imgBandeiraBack: ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cardFlipper = findViewById(R.id.cardFlipper)
        cardView = findViewById(R.id.cardView)

        cardFlipper.inAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        cardFlipper.outAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        cardView.setOnClickListener {
            if (cardFlipper.displayedChild == 0) {
                cardFlipper.showNext()
            } else {
                cardFlipper.showPrevious()
            }
        }

        txtNomeCartao = findViewById(R.id.txtNomeCartao);
        txtCVVCartao = findViewById(R.id.txtCVVCartao);
        txtValidadeCartao = findViewById(R.id.txtValidadeCartao);
        txtNumeroCartao = findViewById(R.id.txtNumeroCartao);

        editNome = findViewById(R.id.editNome);
        editCVV = findViewById(R.id.editCVV);
        editValidade = findViewById(R.id.editValidade);
        editNumero = findViewById(R.id.editNumero);

        btnEditar = findViewById(R.id.btnEditar);
        btnSalvar = findViewById(R.id.btnSalvar);

        imgBandeiraFront = findViewById(R.id.imgBandeiraFront)
        imgBandeiraBack = findViewById(R.id.imgBandeiraBack)

        editNome.isEnabled = false;
        editCVV.isEnabled = false;
        editValidade.isEnabled = false;
        editNumero.isEnabled = false;
        btnEditar.isEnabled = true;
        btnSalvar.isEnabled = false;

        editNome.addTextChangedListener{
            aoDigitarNome(it.toString());
        }

        editNumero.addTextChangedListener {
            aoDigitarNumero(it.toString())
        }

        editValidade.addTextChangedListener {
            aoDigitarValidade(it.toString())
        }

        editCVV.addTextChangedListener {
            aoDigitarCVV(it.toString())
        }

    }

    fun aoDigitarNome(texto: String){
        if(texto.length <= 20){

            txtNomeCartao.text = texto.uppercase(getDefault());
        }
        if(texto.length == 0){
            txtNomeCartao.text = "DIGITE SEU NOME AQUI";
        }
    }

    fun aoDigitarNumero(texto: String){
        val clean = texto.replace(" ", "");
        val formatado = clean.chunked(4).joinToString(" ");

        txtNumeroCartao.text = formatado;

        if(texto.length == 0){
            txtNumeroCartao.text = "0000 0000 0000 0000";
        }else if (editNumero.text.toString() != formatado) {
            editNumero.setText(formatado)
            editNumero.setSelection(formatado.length)
        }

        attBandeira(texto);

    }

    fun aoDigitarCVV(texto: String){
        if(texto.length == 0){
            txtCVVCartao.text = "CVV";
        }else if(texto.length <= 3){

            txtCVVCartao.text = texto.uppercase(getDefault());
        }
    }

    fun aoDigitarValidade(texto: String){

        val textoSemBarra = texto.replace("/", "");

        var resultado = "";

        if (textoSemBarra.length == 0) {
            resultado = "00/00";
        }
        else if (textoSemBarra.length == 1) {
            resultado = textoSemBarra;
        }
        else if (textoSemBarra.length == 2) {
            resultado = textoSemBarra;
        }
        else if (textoSemBarra.length == 3) {
            resultado = textoSemBarra.substring(0, 2) + "/" + textoSemBarra.substring(2, 3);
        }
        else if (textoSemBarra.length >= 4) {
            resultado = textoSemBarra.substring(0, 2) + "/" + textoSemBarra.substring(2, 4);
        }

        txtValidadeCartao.text = resultado;

        if (editValidade.text.toString() != resultado &&
            resultado != "00/00") {

            editValidade.setText(resultado)
            editValidade.setSelection(resultado.length)
        }

    }

    fun attBandeira(numero: String){

        val clean = numero.replace(" ", "")

        if (clean.startsWith("4")) {
            imgBandeiraFront.setImageResource(R.drawable.visa)
            imgBandeiraBack.setImageResource(R.drawable.visa)

        } else if (clean.startsWith("5") || clean.startsWith("2")) {
            imgBandeiraFront.setImageResource(R.drawable.mastercard)
            imgBandeiraBack.setImageResource(R.drawable.mastercard)

        } else {
            imgBandeiraFront.setImageResource(R.drawable.elo)
            imgBandeiraBack.setImageResource(R.drawable.elo)
        }
    }

    fun editDados(view: View){
        btnEditar.isEnabled = false;
        btnSalvar.isEnabled = true;
        editNome.isEnabled = true;
        editCVV.isEnabled = true;
        editValidade.isEnabled = true;
        editNumero.isEnabled = true;
        btnEditar.alpha = 0.5f;
        btnSalvar.alpha = 1.0f;
    }

    fun saveDados(view: View){

        if(editNome.text.length <3 || editCVV.text.length <3 || editValidade.text.length <5 || editNumero.text.length <19){
            val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("O nome deve ter no mínimo 3 caracteres;\nO CVV tem que conter 3 dígitos;\nA validade tem que conter 4 dígitos;\nO número tem que conter 16 dígitos")


                .create()

            dialog.show()
        }else{
            btnEditar.isEnabled = true;
            btnSalvar.isEnabled = false;
            editNome.isEnabled = false;
            editCVV.isEnabled = false;
            editValidade.isEnabled = false;
            editNumero.isEnabled = false;
            btnEditar.alpha = 1.0f;
            btnSalvar.alpha = 0.5f;
        }

    }


}