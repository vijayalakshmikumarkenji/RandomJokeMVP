package com.ivy.randomJoke.View;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ivy.randomJoke.Model.Network.RandomJokeResponse;
import com.ivy.randomJoke.Presenter.PresenterImpl;
import com.ivy.randomJoke.R;

import org.w3c.dom.Text;


/**
 * Main View activity which will handle all view components.
 */
public class RandomJokeActivity extends AppCompatActivity implements IViewInterface, View.OnClickListener {

    private PresenterImpl mPresenterImpl;

    private TextView mQueryView;
    private TextView mAnswerView;
    private TextView mNextButtonView;

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_joke);
        initViews();
        mProgressDialog = new ProgressDialog(RandomJokeActivity.this);
        mPresenterImpl = new PresenterImpl(this);
        mPresenterImpl.getRandomJoke();
    }


    /**
     * Method to initialize all the views.
     */
    private void initViews() {
        mQueryView = findViewById(R.id.query_view);
        mAnswerView = findViewById(R.id.answer_view);
        mNextButtonView = findViewById(R.id.next_button);
        mNextButtonView.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        mProgressDialog.setMessage("Loading");
        mProgressDialog.show();

    }

    @Override
    public void hideProgress() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onHandleError(String errorMessage) {
        mAnswerView.setVisibility(View.GONE);
        mQueryView.setVisibility(View.GONE);
        mNextButtonView.setVisibility(View.GONE);
        AlertDialog.Builder builder = new AlertDialog.Builder(RandomJokeActivity.this);
        if (errorMessage != null) builder.setTitle(getResources().getString(R.string.error_title));
        builder.setMessage(errorMessage);
        builder.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenterImpl.getRandomJoke();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @Override
    public void UpdateResults(RandomJokeResponse randomJokeResponse) {
        mQueryView.setText(randomJokeResponse.getSetup());
        mAnswerView.setText(randomJokeResponse.getPunchline());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_button) {
            mPresenterImpl.getRandomJoke();
        }
    }
}
