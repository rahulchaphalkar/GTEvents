package edu.gatech.gtevents.gtevents.feedscreen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.gatech.gtevents.gtevents.R;

/**
 * A FragmentPagerAdapter implementation for the feed screen.
 */
public class FeedScreenFragmentPagerAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT = 3;

    private String tabTitles[];
    private Context context;

    private Fragment frag1;
    private Fragment frag2;
    private Fragment frag3;

    public FeedScreenFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

        tabTitles = new String[PAGE_COUNT];
        tabTitles[0] = context.getResources().getString(R.string.feed_tab1_name);
        tabTitles[1] = context.getResources().getString(R.string.feed_tab2_name);
        tabTitles[2] = context.getResources().getString(R.string.feed_tab3_name);

        frag1 = EventListFeedFragment.newInstance();
        frag2 = EventListFeedFragment.newInstance();
        frag3 = EventListFeedFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return frag1;

            case 1:
                return frag2;

            case 2:
                return frag3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
