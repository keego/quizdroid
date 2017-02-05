package edu.washington.ksf7.quizdroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import edu.washington.ksf7.quizdroid.Controllers.MasterDetailView;
import edu.washington.ksf7.quizdroid.Data;
import edu.washington.ksf7.quizdroid.Fragments.QuizQuestionFragment;
import edu.washington.ksf7.quizdroid.Models.Quiz;
import edu.washington.ksf7.quizdroid.R;
import edu.washington.ksf7.quizdroid.Fragments.TopicOverviewFragment;

public class QuizActivity extends AppCompatActivity implements TopicOverviewFragment.Listener, QuizQuestionFragment.Listener {

    private final String TAG = "QuizActivity";
    private Quiz quiz;
    private int quizNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // This is a detail in a Master-Detail setup,
        // get this detail activity's index in the master list
        quizNumber = MasterDetailView.Controller.getDetailPosition(getIntent());

        // Get data for my fragments
        quiz = Data.getQuiz(quizNumber);
        String topicTitle = quiz.getTopic();
        int questionCount = quiz.getQuestions().size();

        // Load in the topic overview fragment
        TopicOverviewFragment topicOverviewFragment = new TopicOverviewFragment();
        topicOverviewFragment.setArguments(topicTitle, questionCount);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.quiz_fragment_frame, topicOverviewFragment)
                .commit();
    }

    //----------------------------------------------------------------------------------------------
    // Fragment Interface Implementations
    //----------------------------------------------------------------------------------------------

    public void onBeginButtonClicked(View view) {
        // Setup and transition to taking the first question in the quiz
        QuizQuestionFragment quizQuestionFragment = new QuizQuestionFragment();
        quizQuestionFragment.setArguments(quizNumber, 0);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.quiz_fragment_frame, quizQuestionFragment)
                .commit();
    }

    public void onSubmitAnswerClicked(View view, int answerNumber) {
        Log.d(TAG, "TODO submit answer #" + answerNumber);
    }
}