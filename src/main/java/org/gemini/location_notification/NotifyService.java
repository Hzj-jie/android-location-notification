package org.gemini.location_notification;

import android.location.Location;
import android.util.Log;
import org.gemini.shared.Debugging;
import org.gemini.shared.Event;
import org.gemini.shared.FusedLocationListener;
import org.gemini.shared.LocationListener;
import org.gemini.shared.LogCollector;
import org.gemini.shared.KeepAliveService;

public final class NotifyService extends KeepAliveService {
  private static final String TAG = Debugging.createTag("NotifyService");
  private LocationListener listener;

  public NotifyService () {
    Debugging.catchUnhandledExceptions();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    LogCollector.startInDebug(this);
    FusedLocationListener.Configuration config =
        new FusedLocationListener.Configuration();
    config.context = getApplicationContext();
    listener = FusedLocationListener.create(config);
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
    Log.w(TAG, "onLocationChanged: " + location.toString());
  }
}
