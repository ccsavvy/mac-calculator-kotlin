package com.wineadvocate.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    var op="*"
    var oldNumber=""
    var isNewOp=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView.text = "Welcome to Kotlin"
    }

    protected fun btnNumberEvent(view: View) {

        if(isNewOp){
            editTxtShow.text = null
            editTxtShow.text = ""
        }
        isNewOp=false


        val btnSelect = view as Button
        var btnClickValue = editTxtShow.text.toString()

        when(btnSelect.id) {
            btn0.id -> {
                btnClickValue += "0"
            }
            btn1.id -> {
                btnClickValue += "1"
            }
            btn2.id -> {
                btnClickValue += "2"
            }
            btn3.id -> {
                btnClickValue += "3"
            }
            btn4.id -> {
                btnClickValue += "4"
            }
            btn5.id -> {
                btnClickValue += "5"
            }
            btn6.id -> {
                btnClickValue += "6"
            }
            btn7.id -> {
                btnClickValue += "7"
            }
            btn8.id -> {
                btnClickValue += "8"
            }
            btn9.id -> {
                btnClickValue += "9"
            }
            btnPlusOrMinus.id -> {

                btnClickValue = "-$btnClickValue"
            }
            btnDot.id -> {
                if(!btnClickValue.contains(".")) {
                    btnClickValue += "."
                }
            }

        }

        editTxtShow.text = btnClickValue
    }

    fun btnOpEvent(view:View){

        var buSelect = view as Button
        when(buSelect.id) {
            btnTimes.id -> {
                op="*"
            }
            btnDivide.id -> {
                op="/"
            }
            btnMinus.id -> {
                op="-"
            }
            btnPlus.id -> {
                op="+"
            }
        }

        oldNumber=editTxtShow.text.toString()
        isNewOp=true
    }

    fun btnEqualEvent(view:View){

        if (!oldNumber.isEmpty()){
            val newNumber = editTxtShow.text.toString()
            var finalNumber: Double? = null

            when (op) {

                "*" -> {
                    finalNumber = oldNumber.toDouble() * newNumber.toDouble()
                }
                "/" -> {
                    finalNumber = oldNumber.toDouble() / newNumber.toDouble()
                }
                "+" -> {
                    finalNumber = oldNumber.toDouble() + newNumber.toDouble()
                }
                "-" -> {
                    finalNumber = oldNumber.toDouble() - newNumber.toDouble()
                }
            }
            editTxtShow.text = finalNumber.toString()
            isNewOp = true
        }
    }

    fun btnPercent(view:View){
        val number:Double=editTxtShow.text.toString().toDouble()/100

        editTxtShow.text = number.toString()
        isNewOp=true

    }

    fun btnClean(view:View){
        editTxtShow.text = "0"
        isNewOp=true
    }
}