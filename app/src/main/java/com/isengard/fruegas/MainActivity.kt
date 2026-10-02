package com.isengard.fruegas

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG="FraguasIsengard"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d(TAG, "OnCreate:Inicio de la Aplicacion")

        val nombre=findViewById<EditText>(R.id.nombreTexto)
        val checkAntorcha=findViewById<CheckBox>(R.id.antorchaCheck)
        val bton=findViewById<ImageButton>(R.id.bton)
        nombre.requestFocus()


            //Este codigo asi de por si no funciona, me refiero que
            //Si hay dos Edittext y lo cambias de uno a otro si, pero
            //asi solo no funciona por lo que he visto , igual te lo he busco en el bton para que veas que sale la explamacion
        nombre.setOnFocusChangeListener{_,check->
            if(!check)
            {
                nombre.error="Debe de tener un nombre"
            }
        }


            bton.setOnClickListener{


                if(nombre.text.isEmpty())
                {
                    nombre.error="Debes introducir un nombre"

                }else{

                    if(checkAntorcha.isChecked){
                        val mensaje="Unidad {${nombre.text}} enviada al Abismo de helm"
                        Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show()

                    }else{
                        Log.e("Error","¡Peligro! Unidad enviada sin fuego ")

                    }


                }






            }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Onstart:Las fraguas se encienden")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume:Las fraguas se resumen")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause:Las fraguas se ponene en pausa")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop:Las fraguas se paran")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy:Las fraguas se destruyen")

    }



}