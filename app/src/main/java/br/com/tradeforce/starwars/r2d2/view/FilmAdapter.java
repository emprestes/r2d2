package br.com.tradeforce.starwars.r2d2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.tradeforce.starwars.r2d2.R;
import tradeforce.starwars.domain.model.Film;

public final class FilmAdapter extends BaseAdapter {

    private final Context context;

    private final List<Film> films;

    private final LayoutInflater inflater;

    private final int idRowLayout;

    public FilmAdapter(Context context, int idRowLayout, Collection<Film> films) {
        super();

        this.films = new ArrayList<>();
        this.films.addAll(films);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.idRowLayout = idRowLayout;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return films.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Film f = films.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(idRowLayout, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView image = (TextView) convertView.findViewById(R.id.url);

        name.setText(context.getString(R.string.film_title, f.getTitle(), f.getEpisode_id()));
        image.setText(f.getUrl());

        return convertView;
    }
}
