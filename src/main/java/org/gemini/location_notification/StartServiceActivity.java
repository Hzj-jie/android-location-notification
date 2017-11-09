package org.gemini.location_notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import org.gemini.shared.Debugging;

public final class StartServiceActivity extends Activity {
  private static final String TAG =
      Debugging.createTag("LocationNotification.StartService");

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    startService(new Intent(this, NotifyService.class));
    finish();
  }
}
