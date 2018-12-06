package com.ruby.cloudinteractiveapp.show;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruby.cloudinteractiveapp.R;
import com.ruby.cloudinteractiveapp.data.ImageManager;
import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter {

    private ShowContract.Presenter mPresenter;
    private List<Photos> mPhotosList;

    public void setPhotosList(List<Photos> photosList) {
        mPhotosList = new ArrayList<>(photosList);
        notifyDataSetChanged();
    }

    public ShowAdapter(ShowContract.Presenter presenter) {
        mPresenter = presenter;
        mPhotosList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);

        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ShowViewHolder) viewHolder).bindView();
    }

    @Override
    public int getItemCount() {
        return mPhotosList.size();
    }

    private class ShowViewHolder extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mTitle;
        private ImageView mPhotoImage;
        private Photos mPhotos;


        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.photo_id);
            mTitle = itemView.findViewById(R.id.photo_title);
            mPhotoImage = itemView.findViewById(R.id.photo_image);

        }

        private void bindView() {

            mPhotos = mPhotosList.get(getAdapterPosition());
            mId.setText(String.valueOf(mPhotos.getId()));
            mTitle.setText(mPhotos.getTitle());
            mPhotoImage.setTag(mPhotos.getThumbnailUrl());
            mPhotoImage.setImageResource(R.drawable.place_holder);
            ImageManager.getInstance().set(mPhotoImage, mPhotos.getThumbnailUrl());


        }
    }
}
