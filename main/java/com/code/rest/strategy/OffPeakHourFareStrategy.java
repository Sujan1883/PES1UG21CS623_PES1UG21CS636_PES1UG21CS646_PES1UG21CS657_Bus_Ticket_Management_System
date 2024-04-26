package com.code.rest.strategy;

public class OffPeakHourFareStrategy implements FareCalculationStrategy {
  @Override
  public double calculateFare(double distance) {
    return 4.0 * distance;
  }
}
