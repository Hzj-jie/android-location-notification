package org.gemini.location_notification;

import android.app.Activity;
import android.os.Bundle;
import org.gemini.shared.Debugging;

public final class EditNotificationActivity extends Activity {
  public EditNotificationActivity() {
    Debugging.catchUnhandledExceptions();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.edit_notification);
  }
}
