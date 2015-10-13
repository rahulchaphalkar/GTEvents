package edu.gatech.gtevents.gtevents.feedscreen.savedeventsfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.gatech.gtevents.gtevents.R;

/**
 * A fragment for dealing with the user's saved events.
 */
public class SavedEventsFragment extends Fragment implements View.OnClickListener {

    private SavedEventsListAdapter savedEventsListAdapter;

    public SavedEventsFragment() {
    }

    public static SavedEventsFragment newInstance() {
        return new SavedEventsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedEventsListAdapter = new SavedEventsListAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_events, container, false);

        ((ListView) view.findViewById(R.id.savedEventsListView)).setAdapter(savedEventsListAdapter);
        ((ListView) view.findViewById(R.id.savedEventsListView)).setOnItemClickListener(savedEventsListAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {
    }
}
