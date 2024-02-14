package com.andy_mitchell.mastermind;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class GuessAdapter extends RecyclerView.Adapter<GuessAdapter.MyViewHolder> {
    private List<GuessResult> guessResultList;

    public GuessAdapter (List<GuessResult> guessResults) {
        this.guessResultList = guessResults;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView guessNo;

        public Button guessColour1;
        public Button guessColour2;
        public Button guessColour3;
        public Button guessColour4;

        public Button correctPiece1;
        public Button correctPiece2;
        public Button correctPiece3;
        public Button correctPiece4;

        public MyViewHolder(View view) {
            super(view);

            guessNo = view.findViewById(R.id.guessNo);

            guessColour1 = view.findViewById(R.id.guessColour1);
            guessColour2 = view.findViewById(R.id.guessColour2);
            guessColour3 = view.findViewById(R.id.guessColour3);
            guessColour4 = view.findViewById(R.id.guessColour4);

            correctPiece1 = view.findViewById(R.id.correctPieces1);
            correctPiece2 = view.findViewById(R.id.correctPieces2);
            correctPiece3 = view.findViewById(R.id.correctPieces3);
            correctPiece4 = view.findViewById(R.id.correctPieces4);
        }

    }

    @Override
    public GuessAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.guess_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GuessResult guessResult = guessResultList.get(position);
        holder.guessNo.setText("#" + Integer.toString(position + 1));

        int[] buttonColours = ResultParser.getIntColorArrayFromColourArray(guessResult.getGuess());

        holder.guessColour1.setBackgroundColor(buttonColours[0]);
        holder.guessColour2.setBackgroundColor(buttonColours[1]);
        holder.guessColour3.setBackgroundColor(buttonColours[2]);
        holder.guessColour4.setBackgroundColor(buttonColours[3]);

        int[] correctPiecesColours = ResultParser.getIntColorArrayFromEvaluationResult(guessResult.getResult());

        holder.correctPiece1.setBackgroundColor(correctPiecesColours[0]);
        holder.correctPiece2.setBackgroundColor(correctPiecesColours[1]);
        holder.correctPiece3.setBackgroundColor(correctPiecesColours[2]);
        holder.correctPiece4.setBackgroundColor(correctPiecesColours[3]);

       }

    @Override
    public int getItemCount(){
        return guessResultList.size();
    }
}
