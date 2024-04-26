package com.code.rest.strategy;

public class FareCalculationContext {
  private final FareCalculationStrategy strategy;

  public FareCalculationContext(FareCalculationStrategy strategy) {
    this.strategy = strategy;
  }

  public double calculateFare(double distance) {
    return strategy.calculateFare(distance);
  }
}