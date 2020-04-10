package com.andy_mitchell.mastermind;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GuessAdapter extends RecyclerView.Adapter<GuessAdapter.MyViewHolder> {
    private List<GuessResult> guessResultList;

    public GuessAdapter (List<GuessResult> guessResults) {
        this.guessResultList = guessResults;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView guessText;
        public TextView correctPiecesText;
        public TextView almostCorrectPiecesText;
        public MyViewHolder(View view) {
            super(view);
            guessText = view.findViewById(R.id.guess);
            correctPiecesText = view.findViewById(R.id.correctPieces);
            almostCorrectPiecesText = view.findViewById(R.id.almostCorrectPieces);
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
        holder.guessText.setText(ResultParser.getStringFromGuessResult(guessResult));
        holder.correctPiecesText.setText(guessResult.getResult().getCorrectColoursInTheRightPlace() + " correct in the right place");
        holder.almostCorrectPiecesText.setText(guessResult.getResult().getCorrectColoursInTheWrongPlace() + " correct in the wrong place");
    }

    @Override
    public int getItemCount(){
        return guessResultList.size();
    }
}
