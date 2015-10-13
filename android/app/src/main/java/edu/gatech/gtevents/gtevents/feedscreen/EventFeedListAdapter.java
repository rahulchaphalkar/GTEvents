package edu.gatech.gtevents.gtevents.feedscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.gtevents.gtevents.R;
import edu.gatech.gtevents.gtevents.shared.GTEvent;

/**
 * An adapter that acts as a bridge between the list view of events, and the backend, populating the
 * local list with events.
 */
public class EventFeedListAdapter extends BaseAdapter {

    private List<GTEvent> eventList;
    private Context context;

    public EventFeedListAdapter(Context context) {
        eventList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_event_feed, parent, false);
        }

        GTEvent event = (GTEvent) getItem(position);

        ((TextView) convertView.findViewById(R.id.eventNameTextView)).setText(event.name);
        ((TextView) convertView.findViewById(
                R.id.eventDescriptionTextView)).setText(event.description);
        ((TextView) convertView.findViewById(R.id.eventTimeTextView)).setText(event.time);

        return convertView;
    }

    /**
     * Used to refresh the list with the latest values from the server.
     * @return true if the list was populated correctly, false otherwise.
     */
    public boolean refreshList() {
        // TODO (acalabrese): There should be some communication with the server here.
        GTEvent g1 = new GTEvent();
        GTEvent g2 = new GTEvent();
        GTEvent g3 = new GTEvent();

        g1.name = "Test Name 1";
        g1.time = "1:00";
        g1.description = "Test Description 1";
        g1.location = "COC";
        g1.organization = "Housing";

        g2.name = "Test Name 2";
        g2.time = "2:00";
        g2.description = "Test Description 2";
        g2.location = "CULC";
        g2.organization = "AAA";

        g3.name = "Test Name 3";
        g3.time = "3:00";
        g3.description = "Test Description 3";
        g3.location = "Harris";
        g3.organization = "GT Athletics";

        eventList.clear();
        eventList.add(g1);
        eventList.add(g2);
        eventList.add(g3);

        return true;
    }
}
