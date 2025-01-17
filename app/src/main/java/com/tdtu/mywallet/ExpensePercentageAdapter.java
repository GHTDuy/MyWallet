package com.tdtu.mywallet;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class ExpensePercentageAdapter extends RecyclerView.Adapter<ExpensePercentageAdapter.ViewHolder> {
    private List<StatisticsMenu.ExpensePercentage> expensePercentages;

    public ExpensePercentageAdapter(List<StatisticsMenu.ExpensePercentage> expensePercentages) {
        this.expensePercentages = expensePercentages;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_percentage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StatisticsMenu.ExpensePercentage expensePercentage = expensePercentages.get(position);
        if (holder.textViewExpenseType == null || holder.textViewPercentage == null || holder.textViewTotalAmount == null) {
            Log.e("ViewHolderDebug", "TextViews are null");
            return;
        }
        holder.textViewExpenseType.setText(expensePercentage.getExpenseType());
        holder.textViewPercentage.setText(String.format(Locale.getDefault(), "%.2f%%",
                expensePercentage.getPercentage()));
        holder.textViewTotalAmount.setText(String.format(Locale.getDefault(), "$%.0f",
                expensePercentage.getTotalAmount()));

    }

    @Override
    public int getItemCount() {
        return expensePercentages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewExpenseType;
        TextView textViewPercentage;
        TextView textViewTotalAmount;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewExpenseType = itemView.findViewById(R.id.textViewExpenseType);
            textViewPercentage = itemView.findViewById(R.id.textViewPercentage);
            textViewTotalAmount = itemView.findViewById(R.id.textViewTotalAmount);
        }
    }
}
