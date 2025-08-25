package com.github.ediel_queiroz.breadthfirstsearch.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultCityFinderTest {

  private final CityFinder finder = new DefaultCityFinder();

  @Test
  @DisplayName("should return nearest city with success")
  void shouldReturnNearestCityWithSuccess() {
    // arrange

    // act
    var nearestCity = finder.findNearestCity(1, 1);

    // assert
    assertThat(nearestCity).isEqualTo("Ribeirão Preto");

  }

}
