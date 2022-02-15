package android.example.signupscreen;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_MESSAGE = "android.example.com.activities.extra.NAME";
    public static final String EMAIL_MESSAGE = "android.example.com.activities.extra.EMAIL";
    private EditText nameEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = (EditText) findViewById(R.id.editTextTextPersonName);
        emailEditText = (EditText) findViewById(R.id.editTextEmailAddress);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.groups:
                Toast.makeText(this, "new group", Toast.LENGTH_LONG).show();
            case R.id.settings:
                Toast.makeText(this, "settings", Toast.LENGTH_LONG).show();

                break;

        }
        return true;
    }

    public void launchSecondActivity(View view) {
        //Log.d(LOG_TAG, "Button Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        intent.putExtra(NAME_MESSAGE, message);
        intent.putExtra(EMAIL_MESSAGE, email);

        Person person = new Person(message,email);
        intent.putExtra("person",person);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_coffee:
                if (checked)
                    Toast.makeText(this, "You Love Coffee", Toast.LENGTH_LONG).show();
                    break;
            case R.id.radio_tea:
                if (checked)
                    Toast.makeText(this, "You Enjoy Tea", Toast.LENGTH_LONG).show();
                    break;
        }
    }




}