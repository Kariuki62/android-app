package com.example.newreads.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newreads.R;
import com.example.newreads.models.Books2;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class LibListAdapter extends RecyclerView.Adapter<LibListAdapter.LibraryViewHolder> {

                    private ArrayList <Books2> mbooks;
                    private Context context;

                    public LibListAdapter(Context context, ArrayList<Books2> books) {
                        this.mbooks = books;
                        this.context = context;

                    }

        @Override
        public LibListAdapter.LibraryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_library, parent, false);
            LibraryViewHolder viewHolder = new LibraryViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull LibListAdapter.LibraryViewHolder holder, int position) {
          Books2 books2 = mbooks.get(position);

          holder.mCategoryTextView.setText(books2.getTitle());
          holder.mNameTextView.setText(books2.getAuthor());
          holder.mRatingTextView.setText(books2.getId());

        }

        @Override
        public int getItemCount() {
            return mbooks.size();
        }

        public class LibraryViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.libraryImageView) ImageView mimageView;
            @BindView(R.id.bookTitleTextView) TextView mNameTextView;
            @BindView(R.id.authorNameTextView) TextView mCategoryTextView;
            @BindView(R.id.ratingTextView) TextView mRatingTextView;


            private Context mContext;

            public LibraryViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mContext = itemView.getContext();
            }

            public void bindBooks(Books2 books) {
                mNameTextView.setText(books.getTitle());
                mCategoryTextView.setText(books.getAuthor());
                mRatingTextView.setText("Rating: " + books.getId() + "/5");
            }
        }
    }
