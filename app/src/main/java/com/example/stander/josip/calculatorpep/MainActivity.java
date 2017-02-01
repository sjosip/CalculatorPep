package com.example.stander.josip.calculatorpep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String runningNumber = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOperatoin;
    double result = 0;


    TextView resultView;

    public enum Operation {
        DIVIDE, MULTYPLY, PLUS, MINUS, EQUAL,;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton zeroBtn = (ImageButton) findViewById(R.id.ib_zero);
        ImageButton oneBtn = (ImageButton) findViewById(R.id.ib_one);
        ImageButton twoBtn = (ImageButton) findViewById(R.id.ib_two);
        ImageButton threeBtn = (ImageButton) findViewById(R.id.ib_three);
        ImageButton fourBtn = (ImageButton) findViewById(R.id.ib_four);
        ImageButton fiveBtn = (ImageButton) findViewById(R.id.ib_five);
        ImageButton sixBtn = (ImageButton) findViewById(R.id.ib_six);
        ImageButton sevenBtn = (ImageButton) findViewById(R.id.ib_seven);
        ImageButton eightBtn = (ImageButton) findViewById(R.id.ib_eight);
        ImageButton nineBtn = (ImageButton) findViewById(R.id.ib_nine);

        ImageButton divideBtn = (ImageButton) findViewById(R.id.ib_divide);
        ImageButton multyPlyBtn = (ImageButton) findViewById(R.id.ib_multyply);
        ImageButton minusBtn = (ImageButton) findViewById(R.id.ib_minus);
        ImageButton plusBtn = (ImageButton) findViewById(R.id.ib_plus);
        ImageButton eqalsBtn = (ImageButton) findViewById(R.id.ib_eql);
        ImageButton persBtn = (ImageButton) findViewById(R.id.ib_pers);
        ImageButton sqrtBtn = (ImageButton) findViewById(R.id.ib_sqrt);


        Button clearBtn = (Button) findViewById(R.id.clear);
        resultView = (TextView) findViewById(R.id.tv1);


        resultView.setText("");

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);

            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);

            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);

            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);

            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);

            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);

            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);

            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);

            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesOperation(Operation.DIVIDE);

            }
        });

        multyPlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesOperation(Operation.MULTYPLY);

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesOperation(Operation.MINUS);

            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesOperation(Operation.PLUS);

            }
        });

        eqalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesOperation(Operation.EQUAL);

            }
        });

        persBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainPersActivity.class);
                startActivity(intent);
            }
        });

        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainSqrtActivity.class);
                startActivity(intent);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftValue = "";
                rightValue = "";
                result = 0;
                runningNumber = "";
                currentOperatoin = null;
                resultView.setText("0");

            }
        });

    }

    void procesOperation(Operation operation) {
        if (currentOperatoin != null) {

            if (runningNumber != "") {
                rightValue = runningNumber;
                runningNumber = "";

                switch (currentOperatoin) {
                    case PLUS:
                        result = Double.valueOf(leftValue) + Double.valueOf(rightValue);
                        break;
                    case MINUS:
                        result = Double.valueOf(leftValue) - Double.valueOf(rightValue);
                        break;
                    case DIVIDE:
                        result = Double.valueOf(leftValue) / Double.valueOf(rightValue);
                        break;
                    case MULTYPLY:
                        result = Double.valueOf(leftValue) * Double.valueOf(rightValue);
                        break;

                }

                leftValue = String.valueOf(result);
                resultView.setText(leftValue);
            }

        } else {
            leftValue = runningNumber;
            runningNumber = "";

        }

        currentOperatoin = operation;

    }

    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultView.setText(runningNumber);

    }
}
