package com.example.stander.josip.calculatorpep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainSqrtActivity extends AppCompatActivity {

    private TextView tv_totall;
    private EditText et_enNumb;
    private Button b_sqrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqrt);

        tv_totall = (TextView) findViewById(R.id.tv_totall);
        et_enNumb = (EditText) findViewById(R.id.et_enNumb);
        b_sqrt = (Button) findViewById(R.id.b_sqrt);

        b_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float number = (float) Double.parseDouble(et_enNumb.getText().toString());
                float sqrt = (float) Math.sqrt(number);
                tv_totall.setText(Float.toString(sqrt));
            }
        });

    }
}
