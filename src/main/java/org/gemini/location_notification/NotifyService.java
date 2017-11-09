package org.gemini.location_notification;

import android.location.Location;
import android.util.Log;
import org.gemini.shared.Debugging;
import org.gemini.shared.Event;
import org.gemini.shared.LocationListener;
import org.gemini.shared.KeepAliveService;
import org.gemini.shared.SystemLocationListener;

public final class NotifyService extends KeepAliveService {
  private static final String TAG = Debugging.createTag("NotifyService");
  private LocationListener listener;

  @Override
  public void onCreate() {
    super.onCreate();
    SystemLocationListener.Configuration config =
        new SystemLocationListener.Configuration();
    config.context = getApplicationContext();
    config.gps();
    config.intervalMs = 10000;
    listener = new SystemLocationListener(config);
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
    Log.w(TAG, "X: " + location.getLongitude() +
               ", Y: " + location.getLatitude() +
               ", accuracy: " + location.getAccuracy() +
               ", from provider: " + location.getProvider());
  }
}
