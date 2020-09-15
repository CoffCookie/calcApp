package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    val num_list = ArrayList<Int>()
    val ope_list = ArrayList<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        set_calc_display()
    }

    private fun set_calc_display(){
        var input_num = ""

        zero.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "0"
            else calc_display.text = "${calc_display.text}0"
            input_num += "0"
        }
        one.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "1"
            else calc_display.text = "${calc_display.text}1"
            input_num += "1"
        }
        two.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "2"
            else calc_display.text = "${calc_display.text}2"
            input_num += "2"
        }
        three.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "3"
            else calc_display.text = "${calc_display.text}3"
            input_num += "3"
        }
        four.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "4"
            else calc_display.text = "${calc_display.text}4"
            input_num += "4"
        }
        five.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "5"
            else calc_display.text = "${calc_display.text}5"
            input_num += "5"
        }
        six.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "6"
            else calc_display.text = "${calc_display.text}6"
            input_num += "6"
        }
        seven.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "7"
            else calc_display.text = "${calc_display.text}7"
            input_num += "7"
        }
        eight.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "8"
            else calc_display.text = "${calc_display.text}8"
            input_num += "8"
        }
        nine.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "9"
            else calc_display.text = "${calc_display.text}9"
            input_num += "9"
        }

        clear.setOnClickListener{
            calc_display.text = ""
            input_num = ""
            num_list.clear()
            ope_list.clear()
        }

        plus.setOnClickListener{
            calc_display.text = ""
            add_input(input_num,'+')
            input_num = ""
        }

        minus.setOnClickListener{
            calc_display.text = ""
            add_input(input_num,'-')
            input_num = ""
        }

        equel.setOnClickListener{
            calc_display.text = ""
            add_input(input_num, '=')
            val result= calculation().toString()
            calc_display.text = result
            input_num = result
            num_list.clear()
            ope_list.clear()
        }
    }

    private fun add_input(input_num:String, ope:Char){
        try {
            var num = input_num.toInt()
            num_list.add(num)
            if (ope != '=') ope_list.add(ope)
        }catch(e:Exception){
            calc_display.text = "Numeric Error"
        }
    }

    private fun calculation():Int {
        var i = 0
        while (i < ope_list.size){
            if (ope_list.get(i) == '-') {
                ope_list.set(i, '+')
                num_list.set(i + 1, num_list.get(i + 1) * -1) //引かれる数をマイナスにしてあとでまとめて足す
            }
            i++
        }

        var result:Int = 0
        for(i in num_list){
            println(i.javaClass.kotlin)
            println(i)
            result += i
        }
        println(result)
        return result
    }
}