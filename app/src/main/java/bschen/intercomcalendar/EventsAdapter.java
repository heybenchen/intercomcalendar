package bschen.intercomcalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import bschen.intercomcalendar.models.Event;
import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class EventsAdapter extends ArrayAdapter<Event> implements StickyListHeadersAdapter {

    public EventsAdapter(final Context context, final int resource,
            final List<Event> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Event event = getItem(position);

        if (convertView == null) {
            convertView =
                    LayoutInflater.from(getContext()).inflate(R.layout.cell_event, parent, false);
        }

        final TextView eventName = ButterKnife.findById(convertView, R.id.event_name);
        final TextView invitedCount = ButterKnife.findById(convertView, R.id.event_invited_count);
        eventName.setText(event.getOccasion());
        invitedCount.setText(getContext().getString(R.string.invited, event.getInvitedCount()));

        return convertView;
    }

    @Override
    public View getHeaderView(final int position, View convertView, final ViewGroup parent) {
        final Event event = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.cell_date, parent, false);
        }

        final TextView date = ButterKnife.findById(convertView, R.id.date);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        date.setText(simpleDateFormat.format(event.getDate()));

        return convertView;
    }

    @Override
    public long getHeaderId(final int position) {
        final Event event = getItem(position);
        return event.getDate().getTime();
    }
}
