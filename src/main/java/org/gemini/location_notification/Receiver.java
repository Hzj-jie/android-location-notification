package org.gemini.location_notification;

import org.gemini.shared.KeepAliveReceiver;

public final class Receiver extends KeepAliveReceiver {
  protected Class<?> serviceClass() {
    return NotifyService.class;
  }
}
