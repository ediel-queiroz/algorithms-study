package com.github.ediel_queiroz.breadthfirstsearch.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CityDto(@JsonProperty("name") String name) {

  public static CityDto of(String name) {
    return new CityDto(name);
  }

}
