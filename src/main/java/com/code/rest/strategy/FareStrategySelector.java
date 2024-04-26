package com.code.rest.strategy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

@Component
public class FareStrategySelector {

  public FareCalculationStrategy selectStrategy(boolean isPeakHour) {
    if (isPeakHour) {
      return new PeakHourFareStrategy();
    } else {
      return new OffPeakHourFareStrategy();
    }
  }
}