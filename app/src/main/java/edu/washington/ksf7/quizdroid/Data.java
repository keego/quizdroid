package edu.washington.ksf7.quizdroid;

import java.util.ArrayList;
import java.util.List;

import edu.washington.ksf7.quizdroid.Models.MultipleChoiceQuestion;
import edu.washington.ksf7.quizdroid.Models.Quiz;

/**
 * Created by keegomyneego on 1/30/17.
 */

public class Data {

    private static List<Quiz> quizzes;
    private static List<String> quizTopics;

    public static void loadQuizzes() {
        quizzes = new ArrayList<>();
        quizTopics = new ArrayList<>();

        addQuiz(new Quiz("Math", new MultipleChoiceQuestion[] {
                new MultipleChoiceQuestion("What is the answer?", new String[] {
                        "Its definitely A",
                        "It must be B",
                        "Certainly not C",
                        "Bruh, its D"
                }, 0),
                new MultipleChoiceQuestion("What is the answer?", new String[] {
                        "Its definitely A",
                        "It must be B",
                        "Certainly not C",
                        "Bruh, its D"
                }, 1)
        }));

        addQuiz(new Quiz("Physics", new MultipleChoiceQuestion[] {
                new MultipleChoiceQuestion("What is the answer?", new String[] {
                        "Its definitely A",
                        "It must be B",
                        "Certainly not C",
                        "Bruh, its D"
                }, 0)
        }));

        addQuiz(new Quiz("Marvel Super Heroes", new MultipleChoiceQuestion[] {
                new MultipleChoiceQuestion("What is the answer?", new String[] {
                        "Its definitely A",
                        "It must be B",
                        "Certainly not C",
                        "Bruh, its D"
                }, 0)
        }));
    }

    public static Quiz getQuiz(int index) {
        return quizzes.get(index);
    }

    public static List<String> getTopics() {
        return quizTopics;
    }

    //

    private static void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
        quizTopics.add(quiz.getTopic());
    }
}
