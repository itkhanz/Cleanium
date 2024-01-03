package com.itkhanz.designpatterns.strategy.initial.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "set")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NetInfo {
  private String net_bank;
  private String net_account;
  private String net_pin;
}
