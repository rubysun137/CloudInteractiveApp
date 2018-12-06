package com.ruby.cloudinteractiveapp.show;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ruby.cloudinteractiveapp.R;
import com.ruby.cloudinteractiveapp.object.Photos;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class ShowFragment extends Fragment implements ShowContract.View {

    private ShowContract.Presenter mPresenter;
    private ShowAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        mPresenter = new ShowPresenter(this, getContext());
        mPresenter.start();

        mAdapter = new ShowAdapter(mPresenter);

        RecyclerView recyclerView = view.findViewById(R.id.show_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void setPresenter(ShowContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhotos(List<Photos> photos) {
        mAdapter.setPhotosList(photos);
    }
}
