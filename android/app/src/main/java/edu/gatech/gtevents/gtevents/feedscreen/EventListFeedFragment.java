package edu.gatech.gtevents.gtevents.feedscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.gatech.gtevents.gtevents.R;

/**
 * A fragment representing the current list of events happening.
 */
public class EventListFeedFragment extends Fragment {

    private EventFeedListAdapter eventFeedListAdapter;

    public EventListFeedFragment() {
    }

    public static EventListFeedFragment newInstance() {
        return new EventListFeedFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventFeedListAdapter = new EventFeedListAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list_feed, container, false);
        ((ListView) view.findViewById(R.id.eventListView)).setAdapter(eventFeedListAdapter);
        eventFeedListAdapter.refreshList();
        return view;
    }
}
