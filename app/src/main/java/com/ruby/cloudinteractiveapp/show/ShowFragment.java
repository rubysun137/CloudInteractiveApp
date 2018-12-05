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

import com.ruby.cloudinteractiveapp.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class ShowFragment extends Fragment implements ShowContract.View {

    private ShowContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.show_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        recyclerView.setAdapter(new ShowAdapter(mPresenter));

        mPresenter = new ShowPresenter(this,getContext());
        mPresenter.start();
        return view;
    }

    @Override
    public void setPresenter(ShowContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
