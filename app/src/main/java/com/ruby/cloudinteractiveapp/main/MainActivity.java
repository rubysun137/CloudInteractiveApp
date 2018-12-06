package com.ruby.cloudinteractiveapp.main;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ruby.cloudinteractiveapp.R;
import com.ruby.cloudinteractiveapp.show.ShowFragment;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private Button mShowButton;
    public static final String SHOW_FRAGMENT_TAG = "show";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this, this);
        mPresenter.start();

        mShowButton = findViewById(R.id.show_button);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.pressButton();
            }
        });


    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.place_holder, new ShowFragment(), SHOW_FRAGMENT_TAG);
        fragmentTransaction.commit();
        mShowButton.setVisibility(View.INVISIBLE);
    }
}
