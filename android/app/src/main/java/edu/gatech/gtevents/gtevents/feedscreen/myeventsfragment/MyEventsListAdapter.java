package edu.gatech.gtevents.gtevents.feedscreen.myeventsfragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.gtevents.gtevents.R;
import edu.gatech.gtevents.gtevents.eventdetailscreen.EventDetailActivity;
import edu.gatech.gtevents.gtevents.shared.GTEvent;

/**
 * An adapter that will get the events the user has created from the server.
 */
public class MyEventsListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private List<GTEvent> eventList;
    private Context context;

    public MyEventsListAdapter(Context context) {
        eventList = new ArrayList<>();
        this.context = context;
        refreshList();
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
            convertView = inflater.inflate(R.layout.list_item_my_event, parent, false);
        }

        GTEvent event = (GTEvent) getItem(position);

        ((TextView) convertView.findViewById(R.id.eventNameTextView)).setText(event.getName());
        ((TextView) convertView.findViewById(
                R.id.eventDescriptionTextView)).setText(event.getDescription());
        ((TextView) convertView.findViewById(R.id.eventTimeTextView)).setText(event.getTime());

        return convertView;
    }

    /**
     * Used to refresh the list with the latest values from the server.
     * @return true if the list was populated correctly, false otherwise.
     */
    public boolean refreshList() {
        // TODO (acalabrese): There should be some communication with the server here.
        eventList.clear();

        for (int i = 0 ; i < 20 ; i++) {
            GTEvent temp = new GTEvent();
            temp.setDescription("Test Description " + i);
            temp.setName("Test Name " + i);
            temp.setTime(i + ":00");
            temp.setLocation("Temp Location " + i);
            temp.setOrganization("Temp Organization " + i);
            eventList.add(temp);
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(context, EventDetailActivity.class);
        intent.putExtra(EventDetailActivity.EVENT_KEY, eventList.get(position));
        context.startActivity(intent);
    }
}
