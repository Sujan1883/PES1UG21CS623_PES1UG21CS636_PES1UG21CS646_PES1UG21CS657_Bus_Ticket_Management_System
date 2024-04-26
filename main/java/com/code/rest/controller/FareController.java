package com.code.rest.controller;

import com.code.rest.strategy.FareCalculationContext;
import com.code.rest.strategy.FareCalculationStrategy;
import com.code.rest.strategy.FareStrategySelector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FareController {

  private final FareStrategySelector strategySelector;

  public FareController(FareStrategySelector strategySelector) {
    this.strategySelector = strategySelector;
  }

  @GetMapping("/fare")
  public double calculateFare(@RequestParam double distance, @RequestParam boolean isPeakHour) {
    FareCalculationStrategy strategy = strategySelector.selectStrategy(isPeakHour);
    FareCalculationContext context = new FareCalculationContext(strategy);
    return context.calculateFare(distance);
  }
}
