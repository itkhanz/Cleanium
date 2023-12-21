package com.itkhanz.demos.part10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Locator {
  private LocatorStrategy strategy;
  private String value;
}
