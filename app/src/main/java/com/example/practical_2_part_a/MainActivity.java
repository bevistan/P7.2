package com.example.practical_2_part_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.practical_2_part_a.extra.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Button buttonToast;
    private int mCount=0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

        buttonToast = (Button) findViewById(R.id.button_toast);
        buttonToast.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String message = mShowCount.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_massage, Toast.LENGTH_SHORT);

        toast.show();
    }
    public void countUp(View view) {
        ++mCount;
        if(mShowCount !=null);
           mShowCount.setText(Integer.toString(mCount));
    }
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        String message = mShowCount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);


    }
}