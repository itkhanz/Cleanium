package com.itkhanz.designpatterns.strategy.instructor.emirates.components.search;

import com.itkhanz.designpatterns.strategy.instructor.emirates.components.DatePicker;

import java.util.Map;

public interface FlightSearch {
  void search(Map<String, String> searchDetails);
  void setDatePicker(DatePicker datePicker);
}
