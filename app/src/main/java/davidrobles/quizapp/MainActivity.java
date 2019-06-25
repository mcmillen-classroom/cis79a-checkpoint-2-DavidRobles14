package davidrobles.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private TextView mScoreText;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mPrevButton;
    private ImageButton mNextButton;
    private Button mHintButton;
    private Button mRestartButton;

    private Question[] mQuestions;
    private int mIndex;
    private int mHintIndex;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mPrevButton.setVisibility(View.GONE);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mHintButton = (Button) findViewById(R.id.hint_button);
        mRestartButton = (Button) findViewById(R.id.restart_button);
        mRestartButton.setVisibility(View.GONE);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mPrevButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);
        mRestartButton.setOnClickListener(this);


        mTextView = (TextView) findViewById(R.id.text_view);
        mScoreText = (TextView) findViewById(R.id.text_score);

        mQuestions = new Question[5];
        mIndex = 0;
        mHintIndex = 1;

        mQuestions[0] = new Question(R.string.question_1, R.string.question_1_hint, false);
        mQuestions[1] = new Question(R.string.question_2, R.string.question_2_hint, false);
        mQuestions[2] = new Question(R.string.question_3, R.string.question_3_hint, true);
        mQuestions[3] = new Question(R.string.question_4, R.string.question_4_hint, false);
        mQuestions[4] = new Question(R.string.question_5, R.string.question_5_hint, true);

        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view)
    {

        if (view.getId() == R.id.true_button)
        {
            checkAnswer(true);
        }
        else if(view.getId() == R.id.false_button)
        {
            checkAnswer(false);
        }
        else if(view.getId() == R.id.hint_button)
        {
            if(mHintIndex == 1)
            {
                Toast hintToast = Toast.makeText(this, R.string.question_1_hint, Toast.LENGTH_LONG);
                hintToast.show();
            }
            if(mHintIndex == 2)
            {
                Toast hintToast = Toast.makeText(this, R.string.question_2_hint, Toast.LENGTH_LONG);
                hintToast.show();
            }
            if(mHintIndex == 3)
            {
                Toast hintToast = Toast.makeText(this, R.string.question_3_hint, Toast.LENGTH_LONG);
                hintToast.show();
            }
            if(mHintIndex == 4)
            {
                Toast hintToast = Toast.makeText(this, R.string.question_4_hint, Toast.LENGTH_LONG);
                hintToast.show();
            }
            if(mHintIndex == 5)
            {
                Toast hintToast = Toast.makeText(this, R.string.question_5_hint, Toast.LENGTH_LONG);
                hintToast.show();
            }

        }
        else if(view.getId() == R.id.prev_button)
        {
            mIndex--;
            mHintIndex--;

            if(mIndex >= 0)
            {
                mTextView.setText(mQuestions[mIndex].getTextResId());
                if(mIndex == 0)
                {
                    mPrevButton.setVisibility(View.GONE);
                }
            }
        }
        else if(view.getId() == R.id.next_button)
        {
            mIndex++;
            mHintIndex++;
            mPrevButton.setVisibility(View.VISIBLE);

            if(mIndex < mQuestions.length)
            {
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
            else
            {
                mTextView.setText("You are done!");
                mRestartButton.setVisibility(View.VISIBLE);
                mTrueButton.setVisibility(View.GONE);
                mFalseButton.setVisibility(View.GONE);
                mPrevButton.setVisibility(View.GONE);
                mNextButton.setVisibility(View.GONE);
                mHintButton.setVisibility(View.GONE);
            }
            //DO IF STATEMENT HERE:
        }
    }

    public boolean checkAnswer(boolean userInput)
    {
        if(mQuestions[mIndex].getAnswer() == userInput)
        {
//            mScore += 50;
//            mScoreText.setText(R.string.score + mScore);
            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP | Gravity.LEFT, 325, 150);
            myToast.show();
            return true;
        }
        else
        {
            Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP | Gravity.LEFT, 325, 150);
            myToast.show();
            return false;
        }
    }
}
