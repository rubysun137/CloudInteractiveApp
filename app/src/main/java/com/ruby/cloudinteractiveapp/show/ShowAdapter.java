package com.ruby.cloudinteractiveapp.show;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruby.cloudinteractiveapp.R;
import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter {

    private ShowContract.Presenter mPresenter;
    private List<Photos> mPhotos;

    public void setPhotos(List<Photos> photos) {
        mPhotos = photos;
    }

    public ShowAdapter(ShowContract.Presenter presenter) {
        mPresenter = presenter;
        mPhotos = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo,viewGroup,false);

        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ShowViewHolder)viewHolder).bindView();
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    private class ShowViewHolder extends RecyclerView.ViewHolder{
        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void bindView(){

        }
    }
}
