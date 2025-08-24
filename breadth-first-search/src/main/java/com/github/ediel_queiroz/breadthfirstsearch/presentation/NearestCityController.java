package com.github.ediel_queiroz.breadthfirstsearch.presentation;

import com.github.ediel_queiroz.breadthfirstsearch.service.CityFinder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/nearest-city")
public class NearestCityController {

  private final CityFinder cityFinder;

  public NearestCityController(final CityFinder cityFinder) {
    this.cityFinder = cityFinder;
  }

  @GetMapping
  public CityDto findNearestCity(
      @RequestParam("line") @PositiveOrZero(message = "line number must be at least 0") @NotNull Integer line,
      @RequestParam("column") @PositiveOrZero(message = "line number must be at least 0") @NotNull Integer column) {

    return CityDto.of(cityFinder.findNearestCity(line, column));
  }

}
