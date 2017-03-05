package tradeforce.starwars.r2d2.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

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
