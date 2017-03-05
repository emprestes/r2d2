package tradeforce.starwars.r2d2.controller;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.controller.Controllers.Character;

/**
 * Fragment para exibir dados de geolocalização em mapa.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see SupportMapFragment
 */
public class LocationMapFragment extends SupportMapFragment {

    /** {@inheritDoc} */
    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);

        getMapAsync(map -> {
            LatLng pos;
            Person p;
            Bundle b;

            b = getArguments();
            p = (Person) b.getSerializable(Character.KEY_MODEL);
            if (p != null) {
                pos = new LatLng(p.getLatitude(), p.getLongitude());
                map.addMarker(new MarkerOptions()
                        .position(pos)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_bb8_location))
                        .title(getString(R.string.you_were_here, pos.toString())));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 10.0f));
            }
        });
    }
}
