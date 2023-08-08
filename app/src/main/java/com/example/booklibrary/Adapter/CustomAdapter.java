package com.example.booklibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklibrary.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<String> book_id, book_title, book_author, book_pages;
    private Context context;

    public CustomAdapter(ArrayList<String> book_id, ArrayList<String> book_title, ArrayList<String> book_author, ArrayList<String> book_pages, Context context) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.txt_serialNo.setText(String.valueOf(book_id.get(position)));
        holder.txt_title.setText(book_title.get(position));
        holder.txt_author.setText(book_author.get(position));
        holder.txt_pages.setText(book_pages.get(position));

    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_serialNo, txt_title, txt_author, txt_pages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_serialNo = itemView.findViewById(R.id.txt_serialNo);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_author = itemView.findViewById(R.id.txt_author);
            txt_pages = itemView.findViewById(R.id.txt_pages);

        }
    }
}
