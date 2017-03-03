package tradeforce.starwars.r2d2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.r2d2.R;

public class PersonAdapter extends BaseAdapter {

    private final List<Person> values;

    private final LayoutInflater inflater;

    private final int idRowLayout;

    public PersonAdapter(Context context, int idRowLayout, Collection<Person> values) {
        super();

        this.values = new ArrayList<>();
        this.values.addAll(values);
        this.inflater = LayoutInflater.from(context);
        this.idRowLayout = idRowLayout;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return values.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person p = values.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(idRowLayout, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView image = (TextView) convertView.findViewById(R.id.url);

        name.setText(p.getName());
        image.setText(p.getUrl());
        convertView.setTag(p);

        return convertView;
    }
}
