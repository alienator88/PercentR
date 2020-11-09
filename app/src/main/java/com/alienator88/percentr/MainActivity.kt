package com.alienator88.percentr

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        //actionBar!!.title = "Percentr"
        actionBar!!.subtitle = "Perform a conversion below"

        fun hideK(view: View) {
            view?.apply {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0) } }

        fun calculatep1(num1: Double, num2: Double): String {
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.HALF_UP
            val math = (num1*num2)/100
            return df.format(math) }

        fun calculatep2(num1: Double, num2: Double): String {
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.HALF_UP
            val math = (num1/num2)*100
            return df.format(math) }

        fun calculatep3(num1: Double, num2: Double): String {
            val df = DecimalFormat("#.#")
            df.roundingMode = RoundingMode.HALF_UP
            val math = (num1*100)/num2
            return df.format(math) }

        fun clear() {
            p1a.text.clear()
            p1b.text.clear()
            p2a.text.clear()
            p2b.text.clear()
            p3a.text.clear()
            p3b.text.clear()
            resultv.text = ""
            p1a.clearFocus()
            p1b.clearFocus()
            p2a.clearFocus()
            p2b.clearFocus()
            p3a.clearFocus()
            p3b.clearFocus()
        }

        clearbtn.setOnClickListener {
            clear()
        }

        p1btn.setOnClickListener {
            if (p1a.text.isNullOrEmpty() or p1b.text.isNullOrEmpty()){
                //nothing
            }else{
                var num1 = p1a.text.toString().toDouble()
                var num2 = p1b.text.toString().toDouble()
                val final = calculatep1(num1, num2)
                resultv.text = final
                hideK(it)
            }
        }

        p2btn.setOnClickListener {
            if (p2a.text.isNullOrEmpty() or p2b.text.isNullOrEmpty()){
                //nothing
            }else {
                var num1 = p2a.text.toString().toDouble()
                var num2 = p2b.text.toString().toDouble()
                val final = calculatep2(num1, num2)
                resultv.text = final + "%"
                hideK(it)
            }
        }

        p3btn.setOnClickListener {
            if (p3a.text.isNullOrEmpty() or p3b.text.isNullOrEmpty()){
                //nothing
            }else {
                var num1 = p3a.text.toString().toDouble()
                var num2 = p3b.text.toString().toDouble()
                val final = calculatep3(num1, num2)
                resultv.text = final
                hideK(it)
            }
        }

        infobtn.setOnClickListener {
            val dialoginfo = BottomSheetDialog(this)
            val bottomSheetinfo = layoutInflater.inflate(R.layout.info, null)
            dialoginfo.setContentView(bottomSheetinfo)
            dialoginfo.show()
        }






    }
}