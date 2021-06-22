package com.example.tutorialapp;

import org.mariuszgromada.math.mxparser.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static boolean symbol = false;
    public static String currentStatement = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    public void onBtnClick(View view) {
        EditText username = findViewById(R.id.username);
        TextView text = findViewById(R.id.textView);
        text.setText("Hello " + username.getText());
    }
    public void backspace(View view) {
        TextView textView = findViewById(R.id.output);
        String content = textView.getText().toString();
        if (currentStatement == "NaN") {
            emptyTextView(view);
            return;
        }
        if (content.length() > 0) {
            textView.setText(content.substring(0, content.length() - 1));
        }
        if (currentStatement.length() > 0) {
            currentStatement = currentStatement.substring(0, currentStatement.length() - 1);
        }
    }
    public void addToTextView(String text) {
        TextView textView = findViewById(R.id.output);
        String currentText = textView.getText().toString();
        textView.setText(currentText.concat(text));
    }
    public void addToStatment(String text) {
        currentStatement += text;
    }
    public void symbolClick(View view) {
        switch (view.getId()) {
            case R.id.multiplication:
                addToTextView("X");
                addToStatment("*");
                break;
            case R.id.divide:
                addToTextView("÷");
                addToStatment("/");
                break;
            case R.id.addition:
                addToTextView("+");
                addToStatment("+");
                break;
            case R.id.subtract:
                addToTextView("-");
                addToStatment("-");
                break;
        }
    }
    public void numberClick(View view) {
        switch (view.getId()) {
            case R.id.number1:
                if (!symbol) {
                    addToTextView("1");
                    addToStatment("1");
                }
                break;
            case R.id.number2:
                if (!symbol) {
                    addToTextView("2");
                    addToStatment("2");
                }
                break;
            case R.id.number3:
                if (!symbol) {
                    addToTextView("3");
                    addToStatment("3");
                }
                break;
            case R.id.number4:
                if (!symbol) {
                    addToTextView("4");
                    addToStatment("4");
                }
                break;
            case R.id.number5:
                if (!symbol) {
                    addToTextView("5");
                    addToStatment("5");
                }
                break;
            case R.id.number6:
                if (!symbol) {
                    addToTextView("6");
                    addToStatment("6");
                }
                break;
            case R.id.number7:
                if (!symbol) {
                    addToTextView("7");
                    addToStatment("7");
                }
                break;
            case R.id.number8:
                if (!symbol) {
                    addToTextView("8");
                    addToStatment("8");
                }
                break;
            case R.id.number9:
                if (!symbol) {
                    addToTextView("9");
                    addToStatment("9");
                }
                break;
            case R.id.number0:
                if (!symbol) {
                    addToTextView("0");
                    addToStatment("0");
                }
                break;
            case R.id.dot:
                if (!symbol) {
                    addToTextView(".");
                    addToStatment(".");
                }
                break;
        }
    }
    public void calculate(View view) {
        if (!currentStatement.equals("")) {
            Expression e = new Expression(currentStatement);
            double answer = e.calculate();
            TextView output = findViewById(R.id.output);
            output.setText(Double.toString(answer));
            currentStatement = Double.toString(answer);
        }
    }
    public void brackets(View view) {
        switch (view.getId()) {
            case R.id.left_bracket:
                addToTextView("(");
                addToStatment("(");
                break;
            case R.id.right_bracket:
                addToTextView(")");
                addToStatment(")");
                break;
        }
    }
    public void emptyTextView(View view) {
        TextView output = findViewById(R.id.output);
        output.setText("");
        currentStatement = "";
    }
}