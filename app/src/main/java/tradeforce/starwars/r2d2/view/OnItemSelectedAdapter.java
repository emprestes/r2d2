package tradeforce.starwars.r2d2.view;

import android.view.View;
import android.widget.AdapterView;

/**
 * Adapter para listener de item selecionado.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see AdapterView
 * @see AdapterView.OnItemSelectedListener
 */
public class OnItemSelectedAdapter implements AdapterView.OnItemSelectedListener {

    /** {@inheritDoc} */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { }

    /** {@inheritDoc} */
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}
