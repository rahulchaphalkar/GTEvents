package edu.gatech.gtevents.gtevents.feedscreen.myeventsfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.gatech.gtevents.gtevents.R;

/**
 * A fragment that will handle the list of events the user has created.
 */
public class MyEventsFragment extends Fragment implements View.OnClickListener {

    private MyEventsListAdapter eventsListAdapter;

    public MyEventsFragment() {
    }

    public static MyEventsFragment newInstance() {
        return new MyEventsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventsListAdapter = new MyEventsListAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_events, container, false);

        ((ListView) view.findViewById(R.id.myEventsListView)).setAdapter(eventsListAdapter);
        ((ListView) view.findViewById(R.id.myEventsListView)).setOnItemClickListener(eventsListAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {
    }
}
