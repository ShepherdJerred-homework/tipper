package com.shepherdjerred.tipper

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val model = TipCalculatorModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBillListener()
        addTipListener()
    }

    private fun addBillListener() {
        val billTextInput = findViewById(R.id.bill) as EditText
        val billTextLayout = findViewById(R.id.billLayout) as TextInputLayout

        billTextInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val billAsFloat = billTextInput.text.toString().toFloatOrNull()
                if (billAsFloat == null) {
                    billTextLayout.isErrorEnabled = true
                    billTextLayout.error = "Please enter a number"
                } else {
                    billTextLayout.isErrorEnabled = false
                    billTextLayout.error = null
                    updateTipAndTotal()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    private fun addTipListener() {
        val tipTextInput = findViewById(R.id.tipPercent) as EditText
        val tipTextLayout = findViewById(R.id.tipLayout) as TextInputLayout

        tipTextInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val tipAsFloat = tipTextInput.text.toString().toFloatOrNull()
                if (tipAsFloat == null) {
                    tipTextLayout.isErrorEnabled = true
                    tipTextLayout.error = "Please enter a number"
                } else {
                    tipTextLayout.isErrorEnabled = false
                    tipTextLayout.error = null
                    updateTipAndTotal()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }

    fun updateTipAndTotal() {
        val billText = findViewById(R.id.bill) as EditText
        val tipPercentText = findViewById(R.id.tipPercent) as EditText

        val bill = billText.text.toString().toFloatOrNull()
        val tip = tipPercentText.text.toString().toFloatOrNull()

        if (bill != null && tip != null) {
            model.cost = bill
            model.tipPercent = tip

            val tipTextView = findViewById(R.id.tipAmountDisplay) as TextView
            val totalTextView = findViewById(R.id.totalDisplay) as TextView

            tipTextView.text = "$" + "%.02f".format(model.calcTip())
            totalTextView.text = "$" + "%.02f".format(model.calcTotal())
        }
    }

}
