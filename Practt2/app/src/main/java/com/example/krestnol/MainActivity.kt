package com.example.krestnol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    fun check() {
        var h = 0
        var p = 0
        val buttons: Array<Button> = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        val simvoli: Array<String> = arrayOf("x", "o")
        for (l in simvoli) {
            for (i in 0..2) {
                if (buttons[i * 3].text == l && buttons[i * 3 + 1].text == l && buttons[i * 3 + 2].text == l) {
                    pobeda()
                    p += 1
                } else
                    if (buttons[i].text == l && buttons[3 + i].text == l && buttons[6 + i].text == l) {
                        pobeda()
                        p += 1
                    }
            }

            if (buttons[0].text == l && buttons[4].text == l && buttons[8].text == l) {
                pobeda()
                p += 1
            } else
                if (buttons[2].text == l && buttons[4].text == l && buttons[6].text == l) {
                    pobeda()
                    p += 1
                }

            for (q in buttons) {
                if ((q.text != "") && (p != 1)) {
                    h += 1
                }
            }
            if (h == 9) {
                polepobedi.text = "Ничья"
                p += 1
            }
        }
    }


    fun pobeda() {
        val buttons: Array<Button> =
            arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (k in buttons)
            k.isEnabled = false

        if (xo == false) {
            polepobedi.text = "победил x"

        } else if (xo != false) {
            polepobedi.text = "победил o"
        }
    }


    var xo = true

    fun startOn(view: View) {
        var myArray =
            arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for (i in myArray) {
            i.text = ""
            i.isEnabled = true
            polepobedi.text = ""
        }
    }


    fun onMyButtonClick(view: View) {
        if (xo)
            (view as Button).text = "x"
        else
            (view as Button).text = "o"
        xo = !xo
        (view as Button).isEnabled = false
        check()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}