package com.nopcommerce.element.wait;

public enum WaitDuration {
  WAIT_LONG(15L), // 15 seconds
  WAIT_MEDIUM(10L), // 10 seconds
  WAIT_SHORT(5L); // 5 seconds

  private final long durationSeconds;

  WaitDuration(long durationSeconds) {
    this.durationSeconds = durationSeconds;
  }

  public long getDurationSeconds() {
    return durationSeconds;
  }
}
