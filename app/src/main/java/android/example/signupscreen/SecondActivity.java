package android.example.signupscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message =
                intent.getStringExtra(MainActivity.NAME_MESSAGE);
        String email =
                intent.getStringExtra(MainActivity.EMAIL_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.nameDisplay);
        textView.setText(message);
        TextView emailView = (TextView) findViewById(R.id.emailDisplay);
        emailView.setText(email);
    }
}