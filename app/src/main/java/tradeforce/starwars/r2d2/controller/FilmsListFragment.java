package tradeforce.starwars.r2d2.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;
import java.util.Collections;

import tradeforce.starwars.domain.model.Film;
import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.repository.sqlite.SQLiteHelper;
import tradeforce.starwars.r2d2.view.FilmAdapter;

/**
 * Fragment para exibir dados de lista de filmes do personagem.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see ListFragment
 * @see EFragment
 */
@EFragment(value = android.R.layout.list_content, forceLayoutInjection = true)
public class FilmsListFragment extends ListFragment {

    /** {@inheritDoc} */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        SQLiteHelper.ReadableDAO<Film> filmDAO;
        ArrayList<Film> films;
        Bundle b;

        b = getArguments();
        filmDAO = SQLiteHelper.getDAOReadable(getActivity(), Film.class);
        try {
            films = new ArrayList<>();
            Person p = (Person) b.getSerializable(Controllers.Character.KEY_MODEL);
            if (p != null) {
                films.addAll(filmDAO.findById(Film._ID_PERSON, p.getId()));
                Collections.sort(films);
            }

            setListAdapter(new FilmAdapter(getActivity(), R.layout.film, films));
        } finally {
            filmDAO.close();
        }
    }
}
