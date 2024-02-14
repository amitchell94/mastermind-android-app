package com.andy_mitchell.mastermind.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.andy_mitchell.mastermind.Colours;
import com.andy_mitchell.mastermind.EvaluationResult;
import com.andy_mitchell.mastermind.GuessAdapter;
import com.andy_mitchell.mastermind.GuessResult;
import com.andy_mitchell.mastermind.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<GuessResult> guessList = new ArrayList<>();

    SelectColourDialogFragment selectFirstColour;
    SelectColourDialogFragment selectSecondColour;
    SelectColourDialogFragment selectThirdColour;
    SelectColourDialogFragment selectFourthColour;

  //  Colours[] target = new Colours[4];
    Colours[] target = {Colours.BLACK,Colours.RED,Colours.GREEN,Colours.WHITE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mRecyclerView = findViewById(R.id.guess_recycler_view);
        mAdapter = new GuessAdapter(guessList);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

       // target = generateRandomBoard();

        selectFirstColour = new SelectColourDialogFragment();
        selectSecondColour = new SelectColourDialogFragment();
        selectThirdColour = new SelectColourDialogFragment();
        selectFourthColour = new SelectColourDialogFragment();

        selectFirstColour.setButton((Button) findViewById(R.id.button1));
        selectSecondColour.setButton((Button) findViewById(R.id.button2));
        selectThirdColour.setButton((Button) findViewById(R.id.button3));
        selectFourthColour.setButton((Button) findViewById(R.id.button4));
    }

    private static Colours[] generateRandomBoard() {
        Colours[] board = new Colours[4];

        for (int i = 0; i < board.length; i++) {
            Random rand = new Random();
            board[i] = colourFromNumber(rand.nextInt(6));
        }

        return board;
    }

    private static Colours colourFromNumber(int number) {
        switch (number) {
            case 0:
                return Colours.BLUE;
            case 1:
                return Colours.RED;
            case 2:
                return Colours.GREEN;
            case 3:
                return Colours.YELLOW;
            case 4:
                return Colours.BLACK;
            case 5:
                return Colours.WHITE;

        }
        return null;
    }

    public void selectFirstColour(View view) {

        selectFirstColour.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }

    public void selectSecondColour(View view) {
        selectSecondColour.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }

    public void selectThirdColour(View view) {
        selectThirdColour.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }

    public void selectFourthColour(View view) {
        selectFourthColour.show(getSupportFragmentManager(), "NoticeDialogFragment");
    }

    public void guessCode(View view) {
        Colours[] guess = {
                selectFirstColour.getColourToBeSelected(),
                selectSecondColour.getColourToBeSelected(),
                selectThirdColour.getColourToBeSelected(),
                selectFourthColour.getColourToBeSelected()
        };

        EvaluationResult result = new EvaluationResult();

            if (guess != null) {
                result = evaluate(target, guess);
            }
            GuessResult guessResult = new GuessResult(guess,result);

            guessList.add(guessResult);
            mAdapter.notifyDataSetChanged();
            mRecyclerView.scrollToPosition(mAdapter.getItemCount()-1);
            if (guessResult.getResult().getCorrectColoursInTheRightPlace() >= 4) {
                GameCompleteDialogFragment gameCompleteDialogFragment = new GameCompleteDialogFragment();
                gameCompleteDialogFragment.setGameCompleteText("You guessed the code!");
                gameCompleteDialogFragment.show(getSupportFragmentManager(), "NoticeDialogFragment");
            }
    }

    private static EvaluationResult evaluate(Colours[] target, Colours[] guess) {
        EvaluationResult result = new EvaluationResult();
        boolean[] targetGuessed = new boolean[4];
        boolean[] guessGuessed = new boolean[4];

        for (int i = 0; i < target.length; i++) {
            if (target[i].equals(guess[i])) {
                result.incrementColoursInTheRightPlace();
                targetGuessed[i] = true;
                guessGuessed[i] = true;
            }
        }

        for (int guessInc = 0; guessInc < guess.length; guessInc++) {
            for (int targetInc = 0; targetInc < target.length; targetInc++) {
                if (!targetGuessed[targetInc] && !guessGuessed[guessInc]) {
                    if (guess[guessInc].equals(target[targetInc])) {
                        result.incrementColoursInTheWrongPlace();
                        guessGuessed[guessInc] = true;
                        targetGuessed[targetInc] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
