package com.github.ediel_queiroz.breadthfirstsearch.service;

import com.github.ediel_queiroz.breadthfirstsearch.repository.CityRepository;
import org.springframework.stereotype.Component;

@Component
public class DefaultCityFinder implements CityFinder {

  private CityRepository cityRepository;

  @Override
  public String findNearestCity(Integer line, Integer column) {
    // TODO: replace with real implementation
    return "Test City";
  }

}
