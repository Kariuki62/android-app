package com.example.newreads.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newreads.R;
import com.example.newreads.models.Bookss;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

    public class LibraryListAdapter extends RecyclerView.Adapter<LibraryListAdapter.LibraryViewHolder> {

                    private ArrayList <Bookss> mbooks;
                    private Context context;

                    public LibraryListAdapter(Context context, ArrayList<Bookss> books) {
                        this.mbooks = books;
                        this.context = context;

                    }

        @Override
        public LibraryListAdapter.LibraryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_library, parent, false);
            LibraryViewHolder viewHolder = new LibraryViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull LibraryListAdapter.LibraryViewHolder holder, int position) {
          Bookss bookss = mbooks.get(position);

          holder.mCategoryTextView.setText(bookss.getTitle());
          holder.mNameTextView.setText(bookss.getAuthor());
          holder.mRatingTextView.setText(bookss.getId());

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

            public void bindBooks(Bookss books) {
                mNameTextView.setText(books.getTitle());
                mCategoryTextView.setText(books.getAuthor());
                mRatingTextView.setText("Rating: " + books.getId() + "/5");
            }
        }
    }
