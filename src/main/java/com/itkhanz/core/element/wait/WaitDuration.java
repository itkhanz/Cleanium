package com.itkhanz.core.element.wait;

public enum WaitDuration {
  LONG(15L), // 15 seconds
  MEDIUM(10L), // 10 seconds
  SHORT(5L); // 5 seconds

  private final long durationSeconds;

  WaitDuration(long durationSeconds) {
    this.durationSeconds = durationSeconds;
  }

  public long getDurationSeconds() {
    return durationSeconds;
  }
}
