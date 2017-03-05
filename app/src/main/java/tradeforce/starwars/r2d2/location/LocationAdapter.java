package tradeforce.starwars.r2d2.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Adapter usado como listener para localização de GPS.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see LocationListener
 * @see Location
 * @see Bundle
 */
public class LocationAdapter implements LocationListener {

    @Override
    public void onLocationChanged(Location location) { }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }
}
