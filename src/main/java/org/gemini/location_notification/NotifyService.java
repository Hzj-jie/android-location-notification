package org.gemini.location_notification;

import android.location.Location;
import android.util.Log;
import org.gemini.shared.Debugging;
import org.gemini.shared.Event;
import org.gemini.shared.LocationListener;
import org.gemini.shared.KeepAliveService;

public final class NotifyService extends KeepAliveService {
  private static final String TAG = Debugging.createTag("NotifyService");
  private LocationListener listener;

  @Override
  public void onCreate() {
    super.onCreate();
    LocationListener.Configuration config =
        new LocationListener.Configuration();
    config.allProviders();
    config.context = getApplicationContext();
    listener = new LocationListener(config);
    listener.onLocationChanged().add(new Event.ParameterRunnable<Location>() {
      @Override
      public void run(Location location) {
        onLocationChanged(location);
      }
    });
  }

  @Override
  public void onDestroy() {
    listener.stop();
    super.onDestroy();
  }

  private void onLocationChanged(Location location) {
    // TODO
    Log.w(TAG,
          "X: " + location.getLongitude() + ", Y: " + location.getLatitude());
  }
}
