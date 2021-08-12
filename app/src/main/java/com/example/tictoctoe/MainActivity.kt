package com.example.tictoctoe

import android.widget.TextView
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var cells = arrayOf<Int>(0,0,0,0,0,0,0,0,0,0)
    var select : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText : TextView = findViewById(R.id.welcomeText)
        val intent = intent
        var get : Int? = intent.getIntExtra("value", 1)
        if (get != null) {
            select = get
        }
        welcomeText.text = "Welcome"

        val reply : Button = findViewById(R.id.reply)
        reply.setOnClickListener { reset() }

    }
    fun  buClick(view: View)
    {
        var buSelected = view as Button
        var cellId = 0
        when(buSelected.id)
        {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9

        }
        playGame(cellId,buSelected)
    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var draw = 0
    var P1 : Int = 0
    var P2 : Int = 0

    private fun playGame(cellId: Int, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "X"
            player1.add(cellId)
            cells[cellId] = 1
            draw++
            activePlayer = 2
            checkWin()
            if (select == 1)
            {
                if(draw<9)
                {
                    Ai_move()
                }
            }



        }
        else if (activePlayer == 2)
        {
            buSelected.text = "O"
            player2.add(cellId)
            cells[cellId] = 2
            draw++
            activePlayer = 1
            checkWin()

        }

        buSelected.isEnabled = false
    }

    private fun Ai_move() {
        var check : Int = 0
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)

        var cellId = 0


        if (cells[5] == 0)
            cellId = 5
        else if((cells[2] == 2 && cells[3] == 2 && cells[1] == 0) || (cells[4] == 2 && cells[7] == 2 && cells[1] == 0) || (cells[5] == 2 && cells[9] == 2 && cells[1] == 0))
            cellId = 1
        else if ((cells[1] ==  2 && cells[3] ==  2 && cells[2] == 0)  || (cells[5] ==  2 && cells[8] ==  2 && cells[2] == 0))
            cellId = 2

        else if ((cells[1] ==  2 && cells[2] ==  2 && cells[3] == 0)  || (cells[6] ==  2 && cells[9] ==  2 && cells[3] == 0)  || (cells[5] ==  2 && cells[7] ==  2 && cells[3] == 0) )
            cellId = 3 

        else if ((cells[1] ==  2 && cells[7] ==  2 && cells[4] == 0)  || (cells[5] ==  2 && cells[6] ==  2 && cells[4] == 0) )
            cellId = 4 

        else if ((cells[1] ==  2 && cells[9] ==  2 && cells[5] == 0)  || (cells[2] ==  2 && cells[8] ==  2 && cells[5] == 0)  || (cells[3] ==  2 && cells[7] ==  2 && cells[5] == 0)  || (cells[4] ==  2 && cells[6] ==  2 && cells[5] == 0) )
            cellId = 5 

        else if ((cells[4] ==  2 && cells[5] ==  2 && cells[6] == 0)  || (cells[3] ==  2 && cells[9] ==  2 && cells[6] == 0) )
            cellId = 6 

        else if ((cells[1] ==  2 && cells[4] ==  2 && cells[7] == 0)  || (cells[3] ==  2 && cells[5] ==  2 && cells[7] == 0)  || (cells[8] ==  2 && cells[9] ==  2 && cells[0] == 0) )
            cellId = 7 

        else if ((cells[2] ==  2 && cells[5] ==  2 && cells[8] == 0)  || (cells[7] ==  2 && cells[9] ==  2 && cells[8] == 0) )
            cellId = 8 

        else if ((cells[1] ==  2 && cells[5] ==  2 && cells[9] == 0)  || (cells[3] ==  2 && cells[6] ==  2 && cells[9] == 0)  || (cells[7] ==  2 && cells[8] ==  2 && cells[9] == 0) )
            cellId = 9 

        //AI Blocks
        else if((cells[2] == 1 && cells[3] == 1 && cells[1] == 0) || (cells[4] == 1 && cells[7] == 1 && cells[1] == 0) || (cells[5] == 1 && cells[9] == 1 && cells[1] == 0) )
            cellId =  1
        else if((cells[1] == 1 && cells[3] == 1 && cells[2] == 0) || (cells[5] == 1 && cells[8] == 1 && cells[2] == 0) )
            cellId =  2

        else if((cells[1] == 1 && cells[2] == 1 && cells[3] == 0) || (cells[6] == 1 && cells[9] == 1 && cells[3] == 0) || (cells[5] == 1 && cells[7] == 1 && cells[3] == 0) )
            cellId =  3

        else if((cells[1] == 1 && cells[7] == 1 && cells[4] == 0) || (cells[5] == 1 && cells[6] == 1 && cells[4] == 0) )
            cellId =  4

        else if((cells[1] == 1 && cells[9] == 1 && cells[5] == 0) || (cells[2] == 1 && cells[8] == 1 && cells[5] == 0) || (cells[3] == 1 && cells[7] == 1 && cells[5] == 0) || (cells[4] == 1 && cells[6] == 1 && cells[5] == 0) )
            cellId =  5

        else if((cells[4] == 1 && cells[5] == 1 && cells[6] == 0) || (cells[3] == 1 && cells[9] == 1 && cells[6] == 0) )
            cellId =  6

        else if((cells[1] == 1 && cells[4] == 1 && cells[7] == 0) || (cells[3] == 1 && cells[5] == 1 && cells[7] == 0) || (cells[8] == 1 && cells[9] == 1 && cells[0] == 0) )
            cellId =  7

        else if((cells[2] == 1 && cells[5] == 1 && cells[8] == 0) || (cells[7] == 1 && cells[9] == 1 && cells[8] == 0) )
            cellId =  8

        else if((cells[1] == 1 && cells[5] == 1 && cells[9] == 0) || (cells[3] == 1 && cells[6] == 1 && cells[9] == 0) || (cells[7] == 1 && cells[8] == 1 && cells[9] == 0) )
            cellId =  9
        else {
            check = 1
            autoPlay()
        }


        var buSelected:Button?
        buSelected =  when(cellId){
            1-> bu1
            2-> bu2
            3-> bu3
            4-> bu4
            5-> bu5
            6-> bu6
            7-> bu7
            8-> bu8
            9-> bu9
            else ->{ bu1}

        }

        if( check == 0)
        {
            playGame(cellId, buSelected)
        }

    }

    private fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)

        for( cellId in 1..9){

            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        if(emptyCells.size==0){
            reset()
        }


        val r = Random()
        val randIndex = r.nextInt(emptyCells.size )
        val cellId = emptyCells[randIndex]

        var buSelected:Button?
        buSelected =  when(cellId){
            1-> bu1
            2-> bu2
            3-> bu3
            4-> bu4
            5-> bu5
            6-> bu6
            7-> bu7
            8-> bu8
            9-> bu9
            else ->{ bu1}

        }
        Log.i("Auto cellId", cellId.toString())

        playGame(cellId, buSelected)
    }

    private fun checkWin() {
        Log.i("In", "checkWin")

        val tv : TextView = findViewById(R.id.tv)
        var win : Int = 0
        //Checks Horizontal
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            win = 1
        }
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            win = 2
        }
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            win = 1
        }
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            win = 2
        }
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            win = 1
        }
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            win = 2
        }

        //Checks Vertical
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            win = 1
        }
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            win = 2
        }
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            win = 1
        }
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            win = 2
        }
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            win = 1
        }
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            win = 2
        }

        //Checks Diagonally
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            win = 1
        }
        else if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            win = 2
        }
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            win = 1
        }
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            win = 2
        }

        if (win == 1)
        {
            Toast.makeText(this, "Player1 won !!", Toast.LENGTH_SHORT).show()
            P1++
            tv.text = "Player1: $P1                          Player2: $P2"
            val str : String = "Player1 Won the Match..!! \n Do you want to Restart"
            showResults(str)
        }
        else if (win == 2)
        {
            Toast.makeText(this, "Player2 won !!", Toast.LENGTH_SHORT).show()
            P2++
            tv.text = "Player1: $P1                          Player2: $P2"
            val str : String = "Player2 Won the Match..!! \n Do you want to Restart"
            showResults(str)
        }
        else if (draw == 9)
        {
            Log.i("draw ", " check")
            Toast.makeText(this, "Draw Match", Toast.LENGTH_SHORT).show()
            tv.text = "Player1: $P1                          Player2: $P2"
            val str : String = "Draw Game..!! \n Do you want to Restart"
            showResults(str)
        }

    }

    private fun showResults(str: String) {
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)

        val alertDialog= AlertDialog.Builder(this)
        alertDialog.setMessage(str)
        alertDialog.setPositiveButton("Yes")
        {
                dialogInterface: DialogInterface, i: Int ->Toast.makeText(applicationContext,"Replay",Toast.LENGTH_LONG).show()
                reset()
        }
        alertDialog.setNegativeButton("No")
        {
                dialogInterface: DialogInterface, i: Int ->Toast.makeText(applicationContext,"Stop",Toast.LENGTH_LONG).show()
                for(cellId in 1..9){
                    var buSelected:Button? = when(cellId){
                        1-> bu1
                        2-> bu2
                        3-> bu3
                        4-> bu4
                        5-> bu5
                        6-> bu6
                        7-> bu7
                        8-> bu8
                        9-> bu9
                        else ->{ bu1}
                    }
                    buSelected!!.isEnabled = false
                }
        }
        alertDialog.show()

    }



    fun reset()
    {
        activePlayer = 1
        player1.clear()
        player2.clear()
        draw = 0
        cells.fill(0)
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)


        for(cellId in 1..9){

            var buSelected:Button? = when(cellId){
                1-> bu1
                2-> bu2
                3-> bu3
                4-> bu4
                5-> bu5
                6-> bu6
                7-> bu7
                8-> bu8
                9-> bu9
                else ->{ bu1}

            }
            buSelected!!.text = ""
            buSelected!!.isEnabled = true
        }

    }


}