package com.example.wilop.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean flag;
    private boolean gameOn = true;
    private int[] Tablero =  {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private int[][] Gane ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag =true;
    }

    public void CheckWinner(int n){

        for (int i = 0;i<Gane.length; i++){
            if(Tablero[Gane[i][0]] == Tablero[Gane[i][1]] && Tablero[Gane[i][1]] == Tablero[Gane[i][2]]&& Tablero[Gane[i][0]] != -1 ){
                if(n == 0){
                    gameOn = false;
                    Log.d("TAG", "Gano 0");
                    Toast.makeText (MainActivity.this,"GANO O", Toast.LENGTH_SHORT).show();
                }else{
                    gameOn = false;
                    Log.d("TAG", "Gano X");
                    Toast.makeText (MainActivity.this,"GANO X", Toast.LENGTH_SHORT).show();
                }

            }
        }

    }
    public void TicTacToe (View view){
        ImageView imagenView = (ImageView)view;
        String tag = imagenView.getTag().toString();
        int tagN = Integer.parseInt(tag);
        if (Tablero[tagN]==-1 && gameOn){
            if(flag ){
                imagenView.setImageResource(R.drawable.o);
                Tablero[tagN]= 0;
                flag = false;
                CheckWinner(0);
            }else{
                imagenView.setImageResource(R.drawable.x);
                Tablero[tagN]= 1;
                flag = true;
                CheckWinner(1);
            }

        }

    }
}
