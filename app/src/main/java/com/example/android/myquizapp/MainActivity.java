package com.example.android.myquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    final int Q4_ANSWER = R.id.question_four_answer_three;
    final int Q5_ANSWER = R.id.question_five_answer_two;
    final int Q6_ANSWER = R.id.question_six_answer_four;
    final String Q7_ANSWER = "James Gosling";
    final String Q8_ANSWER = "extensible markup language";


    /* Check boxes for question 1 */
    private CheckBox questionOneAnswerOne;
    private CheckBox questionOneAnswerTwo;
    private CheckBox questionOneAnswerThree;
    private CheckBox questionOneAnswerFour;

    /* Check boxes for question 2 */
    private CheckBox questionTwoAnswerOne;
    private CheckBox questionTwoAnswerTwo;
    private CheckBox questionTwoAnswerThree;
    private CheckBox questionTwoAnswerFour;

    /* Check boxes for question 3 */
    private CheckBox questionThreeAnswerOne;
    private CheckBox questionThreeAnswerTwo;
    private CheckBox questionThreeAnswerThree;
    private CheckBox questionThreeAnswerFour;

    /* Radio buttons for question 4 */
    private RadioGroup questionFour;


    /* Radio buttons for question 5 */
    private RadioGroup questionFive;


    /* Radio buttons for question 6 */
    private RadioGroup questionSix;


    /* EditText field for question 7 */
    private EditText questionSevenAnswer;

    /* EditText field for question 8 */
    private EditText questionEightAnswer;

    /* EditText field for user name */
    private EditText userName;

    /* EditText field for user email address */
    private EditText userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all the input fields
        findAllView();

        // Button for resetting score
        final Button resetButton = (Button) findViewById(R.id.reset_answer);
        // Attach a listener to reset button in order to listen to touch event
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When user clicks reset button reset everything
                reset();
            }
        });


    }

    /**
     * This method checks if the answer from question 1 to 8 is correct or not
     * If answer is correct it return 1 and stores in the variable numberOfQuestionsCorrect else return 0 and store-----
     * --- the corresponding string value in the arrayList incorrectAnswersList.
     * This method also displays the result as a toast
     */

    public void checkQuiz(View view) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        EditText enterName = (EditText) findViewById(R.id.user_name);
        String enterNames = enterName.getText().toString();

        EditText enterEmail = (EditText) findViewById(R.id.user_mail_address);
        String enterEmails = enterEmail.getText().toString();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }

        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }

        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 6");
        }

        if (checkQuestion7()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 7");
        }

        if (checkQuestion8()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 8");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }


        Context context = getApplicationContext();
        String text = "Name: " + enterNames + "\nEmail: " + enterEmails + "\nYou got " + numberOfQuestionsCorrect + "/8 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * This method checks Question 1 for correct answer and returns a boolean value
     */
    private boolean checkQuestion1() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_one_answer_one);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_one_answer_two);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_one_answer_three);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_one_answer_four);


        if (c1.isChecked() && c3.isChecked() && !c2.isChecked() && !c4.isChecked()) {
            return true;
        }

        return false;
    }

    /**
     * This method checks Question 2 for correct answer and returns a boolean value
     */
    private boolean checkQuestion2() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_two_answer_one);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_two_answer_two);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_two_answer_three);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_two_answer_four);


        if (c1.isChecked() && c4.isChecked() && !c2.isChecked() && !c3.isChecked()) {
            return true;
        }

        return false;
    }

    /**
     * This method checks Question 3 for correct answer and returns a boolean value
     */
    private boolean checkQuestion3() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_three_answer_one);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_three_answer_two);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_three_answer_three);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_three_answer_four);


        if (c2.isChecked() && c4.isChecked() && !c1.isChecked() && !c3.isChecked()) {
            return true;
        }

        return false;
    }

    /**
     * This method checks Question 4 for correct answer if it corresponds to the global variable Q4_ANSWER and returns a boolean value
     */
    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4_radio_group);

        if (rg.getCheckedRadioButtonId() == Q4_ANSWER) {
            return true;
        }

        return false;
    }

    /**
     * This method checks Question 5 for correct answer if it corresponds to the global variable Q5_ANSWER and returns a boolean value
     */
    private boolean checkQuestion5() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_5_radio_group);

        if (rg.getCheckedRadioButtonId() == Q5_ANSWER) {
            return true;
        }

        return false;
    }

    /**
     * This method checks Question 6 for correct answer if it corresponds to the global variable Q6_ANSWER and returns a boolean value
     */
    private boolean checkQuestion6() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_6_radio_group);

        if (rg.getCheckedRadioButtonId() == Q6_ANSWER) {
            return true;
        }

        return false;
    }

    /**
     * This method checks Question 7 for correct answer if it corresponds to the global variable Q7_ANSWER and returns a boolean value
     */
    private boolean checkQuestion7() {
        EditText et = (EditText) findViewById(R.id.question_seven_answer);

        return et.getText().toString().equalsIgnoreCase(Q7_ANSWER);
    }

    /**
     * This method checks Question 8 for correct answer if it corresponds to the global variable Q8_ANSWER and returns a boolean value
     */
    private boolean checkQuestion8() {
        EditText et = (EditText) findViewById(R.id.question_eight_answer);

        return et.getText().toString().equalsIgnoreCase(Q8_ANSWER);
    }


    /**
     * This method is called to find all the appropriate check boxes, radio groups
     * and edit text fields
     */
    private void findAllView() {
        // Find all check box for question 1
        questionOneAnswerOne = (CheckBox) findViewById(R.id.question_one_answer_one);
        questionOneAnswerTwo = (CheckBox) findViewById(R.id.question_one_answer_two);
        questionOneAnswerThree = (CheckBox) findViewById(R.id.question_one_answer_three);
        questionOneAnswerFour = (CheckBox) findViewById(R.id.question_one_answer_four);

        // Find all check box for question 2
        questionTwoAnswerOne = (CheckBox) findViewById(R.id.question_two_answer_one);
        questionTwoAnswerTwo = (CheckBox) findViewById(R.id.question_two_answer_two);
        questionTwoAnswerThree = (CheckBox) findViewById(R.id.question_two_answer_three);
        questionTwoAnswerFour = (CheckBox) findViewById(R.id.question_two_answer_four);

        // Find all check box for question 3
        questionThreeAnswerOne = (CheckBox) findViewById(R.id.question_three_answer_one);
        questionThreeAnswerTwo = (CheckBox) findViewById(R.id.question_three_answer_two);
        questionThreeAnswerThree = (CheckBox) findViewById(R.id.question_three_answer_three);
        questionThreeAnswerFour = (CheckBox) findViewById(R.id.question_three_answer_four);

        // Find radio group for question 4
        questionFour = (RadioGroup) findViewById(R.id.question_4_radio_group);

        // Find radio group for question 5
        questionFive = (RadioGroup) findViewById(R.id.question_5_radio_group);

        // Find radio group for question 6
        questionSix = (RadioGroup) findViewById(R.id.question_6_radio_group);

        // Find edit text field for question 7
        questionSevenAnswer = (EditText) findViewById(R.id.question_seven_answer);

        // Find edit text field for question 8
        questionEightAnswer = (EditText) findViewById(R.id.question_eight_answer);

        // Find edit text field for question user name
        userName = (EditText) findViewById(R.id.user_name);

        // Find edit text field for question user email
        userEmail = (EditText) findViewById(R.id.user_mail_address);
    }

    /**
     * This method is called to reset every input fields
     */
    private void reset() {
        // Reset all fields for question 1
        questionOneAnswerOne.setChecked(false);
        questionOneAnswerTwo.setChecked(false);
        questionOneAnswerThree.setChecked(false);
        questionOneAnswerFour.setChecked(false);

        // Reset all fields for question 2
        questionTwoAnswerOne.setChecked(false);
        questionTwoAnswerTwo.setChecked(false);
        questionTwoAnswerThree.setChecked(false);
        questionTwoAnswerFour.setChecked(false);

        // Reset all fields for question 3
        questionThreeAnswerOne.setChecked(false);
        questionThreeAnswerTwo.setChecked(false);
        questionThreeAnswerThree.setChecked(false);
        questionThreeAnswerFour.setChecked(false);

        // Reset all fields for question 4
        questionFour.clearCheck();

        // Reset all fields for question 5
        questionFive.clearCheck();

        // Reset all fields for question 6
        questionSix.clearCheck();

        // Reset all fields for question 7
        questionSevenAnswer.setText("");

        // Reset all fields for question 8
        questionEightAnswer.setText("");

        // Reset all fields for user name
        userName.setText("");

        // Reset all fields for user email
        userEmail.setText("");
    }
}
