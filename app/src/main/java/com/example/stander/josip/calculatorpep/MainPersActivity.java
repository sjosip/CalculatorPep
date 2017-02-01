package com.example.stander.josip.calculatorpep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainPersActivity extends AppCompatActivity {

    private TextView tv_total;
    private EditText et_enPer;
    private EditText et_enNum;
    private Button b_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pers);

        tv_total = (TextView) findViewById(R.id.tv_total);
        et_enPer = (EditText) findViewById(R.id.et_enPer);
        et_enNum = (EditText) findViewById(R.id.et_enNum);

        b_percent = (Button) findViewById(R.id.b_percent);
        b_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float persentage = Float.parseFloat(et_enPer.getText().toString());
                float decimal = persentage / 100;
                float total = decimal * Float.parseFloat(et_enNum.getText().toString());
                tv_total.setText(Float.toString(total));
            }
        });
    }
}

