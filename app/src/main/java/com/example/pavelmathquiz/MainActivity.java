package com.example.pavelmathquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavelmathquiz.model.Quiz;
import com.example.pavelmathquiz.model.User;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textViewMathQuiz, textViewGenerateQuiz, textViewShowAnswer;
    EditText editTextUserAnswer;

    Button btnNumberZero, btnNumber1, btnNumber2, btnNumber3, btnNumber4, btnNumber5,
            btnNumber6, btnNumber7, btnNumber8, btnNumber9, btnPoint, btnMinus, btnGenerate,
            btnValidate, btnClear, btnScore, btnFinish;
    ArrayList<Quiz> quizList;
    Quiz quiz;
    String operatorSwitch;
    double calculation;
    private static DecimalFormat df = new DecimalFormat("0.00");
    int num1, num2;
    String whatAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }

    public void initialize() {
        quizList = new ArrayList<>();
        editTextUserAnswer = findViewById(R.id.editTextUserAnswer);
        textViewGenerateQuiz = findViewById(R.id.textViewGenerateQuiz);
        textViewMathQuiz = findViewById(R.id.textViewMathQuiz);
        textViewShowAnswer = findViewById(R.id.textViewShowAnswer);
        btnNumberZero = findViewById(R.id.btnNumberZero);
        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        btnNumber3 = findViewById(R.id.btnNumber3);
        btnNumber4 = findViewById(R.id.btnNumber4);
        btnNumber5 = findViewById(R.id.btnNumber5);
        btnNumber6 = findViewById(R.id.btnNumber6);
        btnNumber7 = findViewById(R.id.btnNumber7);
        btnNumber8 = findViewById(R.id.btnNumber8);
        btnNumber9 = findViewById(R.id.btnNumber9);
        btnPoint = findViewById(R.id.btnPoint);
        btnMinus = findViewById(R.id.btnMinus);
        btnGenerate = findViewById(R.id.btnGenerate);
        btnValidate = findViewById(R.id.btnValidate);
        btnClear = findViewById(R.id.btnClear);
        btnScore = findViewById(R.id.btnScore);
        btnFinish = findViewById(R.id.btnFinish);

        editTextUserAnswer.setOnClickListener(this);
        textViewGenerateQuiz.setOnClickListener(this);
        btnNumberZero.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnGenerate.setOnClickListener(this);
        btnValidate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnScore.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

    }
public void customToast(){
    Toast toast = Toast.makeText(getApplicationContext(),
            "Please, Generate a quiz and input a correct answer", Toast.LENGTH_LONG);
    View toastView = toast.getView();
    toast.setGravity(Gravity.CENTER, 0,0);

    toastView.setBackgroundResource(R.drawable.toast_drawable);

    toast.show();
}

    public void customToast2(){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Please,start input with number", Toast.LENGTH_LONG);
        View toastView = toast.getView();
        toast.setGravity(Gravity.CENTER, 0,0);

        toastView.setBackgroundResource(R.drawable.toast_drawable);

        toast.show();
    }

    @Override
    public void onClick(final View v) {

        switch (v.getId()) {
            case R.id.btnValidate:
                if (editTextUserAnswer.getText().toString().equals("") != true
                && editTextUserAnswer.getText().toString().endsWith("-") != true
                && editTextUserAnswer.getText().toString().startsWith("-.") != true
                        && textViewGenerateQuiz.getText().toString().equals("") != true
                && editTextUserAnswer.getText().toString().endsWith("0.") != true
                        && editTextUserAnswer.getText().toString().endsWith("0.") != true
                        && editTextUserAnswer.getText().toString().endsWith("1.") != true
                        && editTextUserAnswer.getText().toString().endsWith("2.") != true
                        && editTextUserAnswer.getText().toString().endsWith("3.") != true
                        && editTextUserAnswer.getText().toString().endsWith("4.") != true
                        && editTextUserAnswer.getText().toString().endsWith("5.") != true
                        && editTextUserAnswer.getText().toString().endsWith("6.") != true
                        && editTextUserAnswer.getText().toString().endsWith("7.") != true
                        && editTextUserAnswer.getText().toString().endsWith("8.") != true
                        && editTextUserAnswer.getText().toString().endsWith("9.") != true
                        && editTextUserAnswer.getText().toString().endsWith("10.") != true

                )


                    validate();

                else customToast();
                break;
            case R.id.btnGenerate:
                generate();
                break;
            case R.id.btnScore:
                if (editTextUserAnswer.getText().toString().equals("") != true
                        && textViewGenerateQuiz.getText().toString().equals("") != true
                        && editTextUserAnswer.getText().toString().startsWith("-.") != true
                )
                showResult();
                else

               customToast();
                break;
            case R.id.btnFinish:
                finish();
                System.exit(0);
                break;
            case R.id.btnNumberZero:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "0");
                break;
            case R.id.btnNumber1:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "1");
                break;
            case R.id.btnNumber2:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "2");
                break;
            case R.id.btnNumber3:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "3");
                break;
            case R.id.btnNumber4:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "4");
                break;
            case R.id.btnNumber5:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "5");
                break;
            case R.id.btnNumber6:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "6");
                break;
            case R.id.btnNumber7:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "7");
                break;
            case R.id.btnNumber8:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "8");
                break;
            case R.id.btnNumber9:
                editTextUserAnswer.setText(editTextUserAnswer.getText() + "9");
                break;
            case R.id.btnPoint:
                int point = editTextUserAnswer.getText().toString().indexOf(".");
                if ((point < 0)&&(editTextUserAnswer.getText().toString().equals("") != true)
                &&(editTextUserAnswer.getText().toString().startsWith("-") !=true)) {
                    editTextUserAnswer.setText(editTextUserAnswer.getText() + ".");
                }
                else customToast2();
                break;
            case R.id.btnMinus:
                if ((editTextUserAnswer.getText().toString().equals(""))&&
                        (textViewGenerateQuiz.getText().toString().equals("") != true))
                    editTextUserAnswer.setText("-");

                break;
            case R.id.btnClear:
                editTextUserAnswer.setText("");
                textViewShowAnswer.setText("");
                textViewGenerateQuiz.setText("clear");
        }
    }

    public void generate() {
        quiz = new Quiz();
        editTextUserAnswer.setText("");
        Random number = new Random();
        Random operatorChoice = new Random();
        int operator = operatorChoice.nextInt(4);

        switch (operator) {
            case 0:
                num1 = number.nextInt(10);
                num2 = number.nextInt(10);
                operatorSwitch = "+";
                calculation = num1 + num2;
                break;
            case 1:
                num1 = number.nextInt(10);
                num2 = number.nextInt(10);
                operatorSwitch = "-";
                calculation = num1 - num2;
                break;
            case 2:
                num1 = number.nextInt(10);
                num2 = number.nextInt(10);
                operatorSwitch = "*";
                calculation = num1 * num2;
                break;
            case 3:
                operatorSwitch = "/";
                num1 = number.nextInt(10);
                num2 = number.nextInt(10)+1;
                calculation= (num1*1.0) / num2;
                df.format(calculation);
                break;
            default:
                operatorSwitch = "";
        }

        quiz.setNum1(num1);
        quiz.setNum2(num2);

        quiz.setOperator(operatorSwitch);
        quiz.setCalculation(calculation);

        String generate = num1 + operatorSwitch + num2;
        textViewGenerateQuiz.setText(generate);
    }

    private void validate() {

      double user_answer = Double.parseDouble(editTextUserAnswer.getText().toString());

        calculation = Double.valueOf(df.format(calculation));

        if (user_answer != calculation) {
            quiz.setScore(0);
            Toast.makeText(this, "Wrong answer! Right answer is: " + calculation,
            Toast.LENGTH_SHORT).show();
            textViewShowAnswer.setText("Wrong answer");
            whatAnswer = "Wrong answer";
        } else {
            if (user_answer == calculation) {
                quiz.setScore(1);
                Toast.makeText(this, "Right answer! " + calculation,
                 Toast.LENGTH_SHORT).show();
               textViewShowAnswer.setText("Right answer");
                whatAnswer = "Right answer";
            }
        }
        quizList.add(quiz);
       quiz.setUser_answer(user_answer);
       quiz.setWhatAnswer(whatAnswer);
    }

    public void showResult() {
        try {
            Bundle bundle = new Bundle();
            bundle.putSerializable("bundleContent", quizList);
            Intent intent = new Intent(this, ShowResult.class);
            intent.putExtra("intentExtra", bundle);
            startActivityForResult(intent, 1);
        }catch (Exception e) {

            Toast.makeText(this, "Please validate first!", Toast.LENGTH_LONG).show();
        }

    }

    public void backspace(View view)
    { String str = editTextUserAnswer.getText().toString();
    if(str.length() == 0)
        return;
    str = str.substring(0, str.length() - 1);
    editTextUserAnswer.setText(str);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                User user = new User();
                user = (User) data.getSerializableExtra("user");
                textViewMathQuiz.setText(user.getName().toString() + ", your score is " + user.getScore().toString());
            }
            if (resultCode == RESULT_CANCELED)
                textViewMathQuiz.setText("incognito");
        }
    }
}
