package bschen.intercomcalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Date;

import bschen.intercomcalendar.models.Response;
import bschen.intercomcalendar.utils.JsonUtils;
import butterknife.Bind;
import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.calendar_view) MaterialCalendarView mMaterialCalendarView;
    @Bind(R.id.events_list) StickyListHeadersListView mEventsList;

    private EventsAdapter mEventsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initCalendar();
        initEvents();
    }

    private void initCalendar() {
        selectDate(new Date());
    }

    private void initEvents() {
        final String eventsJson = JsonUtils.loadJsonFromAsset(this, "events.json");
        final Gson gson = new Gson();
        final Response response = gson.fromJson(eventsJson, Response.class);

        mEventsAdapter = new EventsAdapter(this, R.layout.cell_event, response.getEvents());
        mEventsList.setAdapter(mEventsAdapter);
        mEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view,
                    final int position, final long id) {
                selectDate(mEventsAdapter.getItem(position).getDate());
            }
        });
    }

    private void selectDate(final Date date) {
        mMaterialCalendarView.setCurrentDate(date);
        mMaterialCalendarView.setSelectedDate(date);
    }

}
