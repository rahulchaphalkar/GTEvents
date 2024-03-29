package edu.gatech.gtevents.gtevents.feedscreen.eventfeedfragment;

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
 * An adapter that acts as a bridge between the list view of events, and the backend, populating the
 * local list with events.
 */
public class EventFeedListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    public static final float BUTTON_OFF_ALPHA = 0.3f;

    private List<GTEvent> eventList;
    private Context context;

    public EventFeedListAdapter(Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_event_feed, parent, false);
        }

        GTEvent event = (GTEvent) getItem(position);

        ((TextView) convertView.findViewById(R.id.eventNameTextView)).setText(event.getName());
        ((TextView) convertView.findViewById(
                R.id.eventDescriptionTextView)).setText(event.getDescription());
        ((TextView) convertView.findViewById(R.id.eventTimeTextView)).setText(event.getTime());

        convertView.findViewById(R.id.likeButton).setFocusable(false);

        convertView.findViewById(R.id.likeButton).setOnClickListener(
                new ItemLikeButtonListener(event));

        convertView.findViewById(R.id.likeButton).setAlpha(
                event.isSaved() ? 1.0f : BUTTON_OFF_ALPHA);

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

    private class ItemLikeButtonListener implements View.OnClickListener {
        private GTEvent event;

        public ItemLikeButtonListener(GTEvent event) {
            this.event = event;
        }

        @Override
        public void onClick(View v) {
            // TODO(acalabrese): Update the view and server here.
            if (v.getId() == R.id.likeButton) {
                event.setSaved(!event.isSaved());
                notifyDataSetInvalidated();
            }
        }
    }
}
