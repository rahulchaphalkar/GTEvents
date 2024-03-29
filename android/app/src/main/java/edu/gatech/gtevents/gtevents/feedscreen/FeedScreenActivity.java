package edu.gatech.gtevents.gtevents.feedscreen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import edu.gatech.gtevents.gtevents.R;

public class FeedScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_screen);
        setUpTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Instantiates the different tabs.
     */
    private void setUpTabs() {
        ViewPager viewPager = ((ViewPager) findViewById(R.id.feed_view_pager));
        viewPager.setAdapter(new FeedScreenFragmentPagerAdapter(getSupportFragmentManager(), this));

        TabLayout tabLayout = ((TabLayout) findViewById(R.id.feed_tab_layout_bar));
        tabLayout.setupWithViewPager(viewPager);
    }
}
