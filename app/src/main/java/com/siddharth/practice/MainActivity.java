package com.siddharth.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] winnerState = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean active = true;

    public void token(View view) {
        ImageView tokens = (ImageView) view;
        int posClick = Integer.parseInt(tokens.getTag().toString());
        if (state[posClick] == 2 && active)
        {
            tokens.setTranslationY(-1000f);
            if (player == 0) {
                tokens.setImageResource(R.drawable.cross);
                tokens.animate().translationYBy(1000f).setDuration(300);
                player = 1;
                state[posClick] = player;
            } else
                {
                tokens.setImageResource(R.drawable.circle);
                tokens.animate().translationYBy(1000f).setDuration(300);
                player = 0;
                state[posClick] = player;
            }
            for(int[] winner : winnerState )
            {
                if(state[winner[0]] == state[winner[1]] && state[winner[0]] == state[winner[2]] && state[winner[0]] != 2) {
                    LinearLayout win = (LinearLayout)findViewById(R.id.winnerMessage);
                    win.setVisibility(View.VISIBLE);
                    TextView mes = (TextView)findViewById(R.id.message);
                    mes.setText("Player " + player + " has won");
                    active = false;
                }
            }
        }
    }

    public void play(View view){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.winnerMessage);
        linearLayout.setVisibility(View.INVISIBLE);
        player = 0;
        active = true;
        int i;
        for(i=0 ; i<state.length;i++)
        {
         state[i] = 2;
        }
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (i = 0; i< gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}