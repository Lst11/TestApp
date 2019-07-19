package com.example.testapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
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

        RequestOptions options = new RequestOptions()
                .circleCrop()
                .error(R.drawable.ic_launcher_background);


        Glide.with(context)
                .load(person.getImageURL())
                .apply(options)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(ProgressBar.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(ProgressBar.GONE);
                        return false;
                    }
                })
                .into(holder.imageView);
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
        ImageView imageView;
        ProgressBar progressBar;

        public Holder(@NonNull View view) {
            super(view);
            parentLayout = view.findViewById(R.id.parentLayout);
            nameTextView = view.findViewById(R.id.nameTextView);
            surnameTextView = view.findViewById(R.id.surnameTextView);
            imageView = view.findViewById(R.id.image);
            progressBar = view.findViewById(R.id.progressBar);

        }
    }


}
