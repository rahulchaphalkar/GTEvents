package edu.gatech.gtevents.gtevents.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.gtevents.gtevents.R;
import edu.gatech.gtevents.gtevents.eventcreationscreen.EventCreationScreenActivity;

/**
 * Main screen for allowing the user to login using GT credentials.
 */
public class LoginScreenActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getSupportActionBar().setTitle(R.string.login_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.loginButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.action_settings:
                // TODO (acalabrese): Do something like adding a settings screen.
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String username = ((EditText) (findViewById(R.id.usernameEditText))).getText().toString();
        String password = ((EditText) (findViewById(R.id.passwordEditText))).getText().toString();

        if (CredentialVerifier.verify(username, password)) {
            // This is the case that the credentials passed.
            // TODO (acalabrese): Here we are just going to start the next activity and then destroy
            // this one. We might need to do some bookkeeping here.

            // Start the next activity.
            Intent createEventActivityIntent =
                    new Intent(LoginScreenActivity.this, EventCreationScreenActivity.class);
            // TODO (acalabrese): See if we need to pass optional parameters here.
            startActivity(createEventActivityIntent);
            finish();
        } else {
            // This is the case the user fucked up.
            Toast.makeText(LoginScreenActivity.this,
                    getResources().getString(R.string.error_message),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
