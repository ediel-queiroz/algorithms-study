package com.github.ediel_queiroz.breadthfirstsearch.service;

import org.springframework.stereotype.Component;

@Component
public class DefaultCityFinder implements CityFinder {

  @Override
  public String findNearestCity(Integer line, Integer column) {
    // TODO: replace with real implementation
    return "Ribeirão Preto";
  }

}
