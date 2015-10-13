package edu.gatech.gtevents.gtevents.feedscreen.eventfeedfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.gatech.gtevents.gtevents.R;
import edu.gatech.gtevents.gtevents.loginscreen.LoginScreenActivity;

/**
 * A fragment representing the current list of events happening.
 */
public class EventListFeedFragment extends Fragment implements View.OnClickListener {

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
        ((ListView) view.findViewById(R.id.eventListView)).setOnItemClickListener(eventFeedListAdapter);
        view.findViewById(R.id.createEventButton).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        // If the user wants to create an event, we will start the appropriate activity.
        if (v.getId() == R.id.createEventButton) {
            Intent intent = new Intent(getActivity(), LoginScreenActivity.class);
            startActivity(intent);
        }
    }
}
