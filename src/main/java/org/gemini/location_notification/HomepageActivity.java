package org.gemini.location_notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import org.gemini.shared.Debugging;

public final class HomepageActivity extends Activity {
  private static final String TAG =
      Debugging.createTag("LocationNotification.HomePage");

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    Log.i(TAG, "HomepageActivity.onCreate");
    startService(new Intent(this, NotifyService.class));
  }
}
