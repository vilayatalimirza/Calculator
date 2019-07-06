package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int mode = 0;
    EditText field1,field2;
    TextView result;
    Button mMode,mCalculate;
    double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1 = findViewById(R.id.field1);
        field2 = findViewById(R.id.field2);
        result = findViewById(R.id.resultshow);
        mMode = findViewById(R.id.button);
        mCalculate = findViewById(R.id.button2);
    }
    public void onMode(View view){
        mode++;
        mode = mode%4;
        switch(mode){
            case 0: mMode.setText(R.string.add);
                    break;
            case 1: mMode.setText(R.string.subtract);
                    break;
            case 2: mMode.setText(R.string.multiply);
                    break;
            case 3: mMode.setText(R.string.divide);
                    break;

        }
    }
    public void onCalculate(View view){
        String s1,s2;
        s1 = field1.getText().toString().trim();
        s2 = field2.getText().toString().trim();
        if(s1.length()==0||s2.length()==0){
            Toast.makeText(this, "FIELD EMPTY", Toast.LENGTH_LONG).show();
            return;
        }
        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        switch(mode){
            case 0: ans = n1 + n2;
                    break;
            case 1: ans = n1 - n2;
                    break;
            case 2: ans = n1 * n2;
                    break;
            case 3: ans = n1 / n2;
                    break;

        }
      result.setText(String.valueOf(ans));
    }
}
