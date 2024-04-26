package com.code.rest.strategy;

public class PeakHourFareStrategy implements FareCalculationStrategy {
  @Override
  public double calculateFare(double distance) {
    return 5.0 * distance + 2.0 ;
  }
}