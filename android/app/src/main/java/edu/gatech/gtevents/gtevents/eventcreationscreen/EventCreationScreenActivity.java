package edu.gatech.gtevents.gtevents.eventcreationscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.gatech.gtevents.gtevents.R;

/**
 * Main screen for the creation of events.
 */
public class EventCreationScreenActivity extends AppCompatActivity implements View.OnClickListener {
    public static final float BUTTON_OFF_ALPHA = 0.3f;

    private boolean isFacebookEnabled;
    private boolean isTwitterEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation_screen);
        getSupportActionBar().setTitle(R.string.event_creation_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addClickListeners();
        populateSpinner();
        setupImageButtons();
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

    /**
     * Adds this activity as a listener on the buttons.
     */
    private void addClickListeners() {
        findViewById(R.id.facebookImageButton).setOnClickListener(this);
        findViewById(R.id.twitterImageButton).setOnClickListener(this);
        findViewById(R.id.createEventButton).setOnClickListener(this);
    }

    /**
     * Populates the location spinner with the string array in the resources.
     */
    private void populateSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.locationSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /**
     * Used to configure the start state of the image buttons.
     */
    private void setupImageButtons() {
        // We will start all buttons as false.
        isTwitterEnabled = false;
        isFacebookEnabled = false;

        findViewById(R.id.twitterImageButton).setAlpha(BUTTON_OFF_ALPHA);
        findViewById(R.id.facebookImageButton).setAlpha(BUTTON_OFF_ALPHA);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        float a;

        switch (id) {
            case R.id.facebookImageButton:
                isFacebookEnabled = !isFacebookEnabled;
                a = (isFacebookEnabled ? 1.0f : BUTTON_OFF_ALPHA);
                findViewById(R.id.facebookImageButton).setAlpha(a);
                break;

            case R.id.twitterImageButton:
                isTwitterEnabled = !isTwitterEnabled;
                a = (isTwitterEnabled? 1.0f : BUTTON_OFF_ALPHA);
                findViewById(R.id.twitterImageButton).setAlpha(a);
                break;

            case R.id.createEventButton:
                createEvent();
                break;
        }
    }

    /**
     * Creates the event by pulling the relevant information.
     */
    private void createEvent() {
        String name = ((EditText) findViewById(R.id.eventNameEditText)).getText().toString();
        String description =
                ((EditText) findViewById(R.id.descriptionEditText)).getText().toString();
        String organization =
                ((EditText) findViewById(R.id.organizationEditText)).getText().toString();
        String location =
                ((Spinner) findViewById(R.id.locationSpinner)).getSelectedItem().toString();
        String time = ((EditText) findViewById(R.id.timeEditText)).getText().toString();

        boolean res =
                EventCreator.createEvent(name, description, time, organization, location,
                        isTwitterEnabled, isFacebookEnabled);

        if (res) {
            // If we are successful, we can just finish the activity.
            finish();
        } else {
            // If we are unsuccessful, we should notify the user.
            Toast.makeText(EventCreationScreenActivity.this,
                    getResources().getString(R.string.event_create_fail), Toast.LENGTH_SHORT).show();
        }
    }
}
