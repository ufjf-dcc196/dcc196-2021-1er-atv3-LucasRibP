package com.lucasribeiro.atividade3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    var n1TextField: EditText? = null
    var n2TextField: EditText? = null
    var radioGrupoOperation: RadioGroup? = null
    var resultView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        n1TextField = findViewById<EditText>(R.id.n1TextField)
        n2TextField = findViewById<EditText>(R.id.n2TextField)
        radioGrupoOperation = findViewById<RadioGroup>(R.id.radioGroupOperation)
        resultView = findViewById<TextView>(R.id.resultText)


        n1TextField!!.addTextChangedListener { calcular() }
        n2TextField!!.addTextChangedListener { calcular() }
        radioGrupoOperation!!.setOnCheckedChangeListener { radioGroup, i -> calcular()}
    }

    fun calcular(){
        val n1String = n1TextField!!.text.toString()
        val n2String = n2TextField!!.text.toString()

        if (n1String.trim() != "" && n2String.trim() != ""){
            val n1 = n1String.toDouble()
            val n2 = n2String.toDouble()

            when(radioGrupoOperation!!.checkedRadioButtonId){
                R.id.radioButtonPlus-> resultView!!.text = (n1 + n2).toString()
                R.id.radioButtonMinus-> resultView!!.text = (n1 - n2).toString()
                R.id.radioButtonTimes-> resultView!!.text = (n1 * n2).toString()
                R.id.radioButtonDivided-> {
                    if(n2 == 0.0) resultView!!.text = ""
                    else resultView!!.text = (n1/n2).toString()
                }
            }
        } else resultView!!.text = ""
    }


}