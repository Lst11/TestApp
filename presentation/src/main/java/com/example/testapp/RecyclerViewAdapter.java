package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entity.Person;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    private Context context = null;
    private LayoutInflater inflater;
    private ArrayList<Person> list = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view = inflater.inflate(R.layout.item_person, viewGroup, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Person person = list.get(position);
        holder.nameTextView.setText(person.getName());
        holder.surnameTextView.setText(person.getSurname());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<Person> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        RelativeLayout parentLayout;
        TextView nameTextView;
        TextView surnameTextView;

        public Holder(@NonNull View view) {
            super(view);
            parentLayout = view.findViewById(R.id.parentLayout);
            nameTextView = view.findViewById(R.id.nameTextView);
            surnameTextView = view.findViewById(R.id.surnameTextView);
        }
    }


}
