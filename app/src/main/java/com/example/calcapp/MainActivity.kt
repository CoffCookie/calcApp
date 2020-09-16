package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    val numList = ArrayList<Int>()
    val opeList = ArrayList<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCalcDisplay()
    }

    private fun setCalcDisplay(){
        var inputNum = ""

        zero.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "0"
            else calc_display.text = "${calc_display.text}0"
            inputNum += "0"
        }
        one.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "1"
            else calc_display.text = "${calc_display.text}1"
            inputNum += "1"
        }
        two.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "2"
            else calc_display.text = "${calc_display.text}2"
            inputNum += "2"
        }
        three.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "3"
            else calc_display.text = "${calc_display.text}3"
            inputNum += "3"
        }
        four.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "4"
            else calc_display.text = "${calc_display.text}4"
            inputNum += "4"
        }
        five.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "5"
            else calc_display.text = "${calc_display.text}5"
            inputNum += "5"
        }
        six.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "6"
            else calc_display.text = "${calc_display.text}6"
            inputNum += "6"
        }
        seven.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "7"
            else calc_display.text = "${calc_display.text}7"
            inputNum += "7"
        }
        eight.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "8"
            else calc_display.text = "${calc_display.text}8"
            inputNum += "8"
        }
        nine.setOnClickListener{
            if (calc_display.text == "0") calc_display.text = "9"
            else calc_display.text = "${calc_display.text}9"
            inputNum += "9"
        }

        clear.setOnClickListener{
            calc_display.text = ""
            inputNum = ""
            numList.clear()
            opeList.clear()
        }

        plus.setOnClickListener{
            calc_display.text = ""
            addInput(inputNum,'+')
            inputNum = ""
        }

        minus.setOnClickListener{
            calc_display.text = ""
            addInput(inputNum,'-')
            inputNum = ""
        }

        multiply.setOnClickListener{
            calc_display.text = ""
            addInput(inputNum,'*')
            inputNum = ""
        }

        divid.setOnClickListener{
            calc_display.text = ""
            addInput(inputNum,'/')
            inputNum = ""
        }

        equel.setOnClickListener{
            calc_display.text = ""
            addInput(inputNum, '=')
            val result= calculation().toString()
            calc_display.text = result
            inputNum = result
            numList.clear()
            opeList.clear()
        }
    }

    private fun addInput(inputNum:String, ope:Char){
        try {
            var num = inputNum.toInt()
            numList.add(num)
            if (ope != '=') opeList.add(ope)
        }catch(e:Exception){
            calc_display.text = "Numeric Error"
        }
    }

    private fun calculation():Int {
        var i = 0
        var result = 0
        while (i < opeList.size){
            if(opeList.get(i) == '/' || opeList.get(i) == '*'){
                if(opeList.get(i) == '*') result = numList.get(i) * numList.get(i+1)
                else result = numList.get(i) / numList.get(i+1)

                numList.set(i,result)           //計算に使った一つ目の数を計算結果に置き換え
                numList.removeAt(i+1)    //二つ目の数をリストから削除
                opeList.removeAt(i)             //使い終わった演算子をリストから削除
                i--                             //リストの次の要素が一つ手前に来たのでiを一つ戻す
            } else if (opeList.get(i) == '-') {
                opeList.set(i, '+')
                numList.set(i + 1, numList.get(i + 1) * -1) //引かれる数をマイナスにしてあとでまとめて足す
            }
            i++
        }

        result = 0
        for(i in numList){
            println(i.javaClass.kotlin)
            println(i)
            result += i
        }
        println(result)
        return result
    }
}