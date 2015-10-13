package edu.gatech.gtevents.gtevents.eventdetailscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import edu.gatech.gtevents.gtevents.R;
import edu.gatech.gtevents.gtevents.shared.GTEvent;

/**
 * Main screen for displaying the details for an event.
 */
public class EventDetailActivity extends AppCompatActivity {
    public static final String EVENT_KEY = "EVENT";

    private GTEvent event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail_screen);
        Bundle bundle = getIntent().getExtras();
        event = bundle.getParcelable(EVENT_KEY);

        getSupportActionBar().setTitle(event.name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populateFields();
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
     * Fills in the text fields with the appropriate values.
     */
    private void populateFields() {
        ((TextView) findViewById(R.id.eventNameTextView)).setText(event.name);
        ((TextView) findViewById(R.id.eventDescriptionTextView)).setText(event.description);
        ((TextView) findViewById(R.id.eventTimeTextView)).setText(event.time);
        ((TextView) findViewById(R.id.eventOrganizationTextView)).setText(event.organization);
        ((TextView) findViewById(R.id.eventLocationTextView)).setText(event.location);
    }
}
