package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // This is the field for the text being entered in the calculator
    private EditText display;
    private String lastClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String toAdd){
        //Getting old text from display and putting it to oldString
        String oldString = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldString.substring(0, cursorPos);
        String rightStr = oldString.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(toAdd);
        }else{
            display.setText(String.format("%s%s%s", leftStr, toAdd, rightStr));
        }
        display.setSelection(cursorPos+1);
    }

    public void zeroBTN(View view){
        // If we last clicked = and then click zero then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("0");
        lastClicked = "0";

    }
    public void oneBTN(View view){
        // If we last clicked = and then click one then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("1");
        lastClicked = "1";
    }
    public void twoBTN(View view){
        // If we last clicked = and then click two then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("2");
        lastClicked = "2";
    }
    public void threeBTN(View view){
        // If we last clicked = and then click three then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("3");
        lastClicked = "3";
    }
    public void fourBTN(View view){
        // If we last clicked = and then click four then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("4");
        lastClicked = "4";
    }
    public void fiveBTN(View view){
        // If we last clicked = and then click five then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("5");
        lastClicked = "5";
    }
    public void sixBTN(View view){
        // If we last clicked = and then click six then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("6");
        lastClicked = "6";
    }
    public void sevenBTN(View view){
        // If we last clicked = and then click seven then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("7");
        lastClicked = "7";
    }
    public void eightBTN(View view){
        // If we last clicked = and then click eight then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("8");
        lastClicked = "8";
    }
    public void nineBTN(View view){
        // If we last clicked = and then click nine then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("9");
        lastClicked = "9";
    }
    public void pmBTN(View view){
        // If we last clicked = and then click pm then clear the view
        if(lastClicked.equals("="))
            clearBTN(view);
        updateText("-");
        lastClicked = "pm";
    }
    public void clearBTN(View view){
        display.setText("");
        lastClicked = "clear";
    }
    public void addBTN(View view){
        updateText("+");
        lastClicked = "+";
    }
    public void subBTN(View view){
        updateText("-");
        lastClicked = "-";
    }
    public void mulBTN(View view){
        updateText("×");
        lastClicked = "*";
    }
    public void divBTN(View view){
        updateText("÷");
        lastClicked = "/";
    }
    public void expBTN(View view){
        updateText("^");
        lastClicked = "^";
    }
    public void pointBTN(View view){
        updateText(".");
        lastClicked = ".";
    }
    public void equalBTN(View view){
        String equation = display.getText().toString();
        equation = equation.replaceAll("×", "*");
        equation = equation.replaceAll("÷", "/");

        Expression exp = new Expression(equation);
        String result = String.valueOf(exp.calculate());

        display.setText(result);

        display.setSelection(result.length());
        lastClicked = "=";
    }
    public void parenthesesBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int length = display.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if(display.getText().toString().substring(i, i+1).equals("("))
                openPar++;
            if(display.getText().toString().substring(i, i+1).equals(")"))
                closedPar++;
        }
        if(openPar == closedPar || display.getText().toString().substring(length - 1, length).equals("(")){
            updateText("(");
        }
        else if(closedPar < openPar && !display.getText().toString().substring(length - 1, length).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPos + 1);
        lastClicked = "par";
    }
    public void backspcBTN(View view){
        int cursorPos = display.getSelectionStart();
        int length = display.getText().length();
        if(cursorPos != 0 && length != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
        lastClicked = "BSPC";
    }
}