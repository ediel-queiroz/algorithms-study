package com.github.ediel_queiroz.breadthfirstsearch.presentation;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.ediel_queiroz.breadthfirstsearch.service.CityFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class NearestCityControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private CityFinder cityFinder;

  private static String[][] provideInvalidCoordinateValues() {
    return new String[][]{{"-1", "1"}, {"1", "-1"},
        {"-1", "-1"},
        {null, "1"}, {"1", null}, {null, null},
        {"1", "a"}, {"a", "1"}, {"", "a"}, {"a", ""}, {" ", "1"}, {"1", " "}};
  }

  @Test
  @DisplayName("should find the nearest city from coordinates")
  void shouldFindNearestCity() throws Exception {
    // arrange
    var coordinatesLine = "1";
    var coordinatesColumn = "1";

    when(cityFinder.findNearestCity(1, 1)).thenReturn("Ribeirão Preto");

    // act & assert
    mockMvc.perform(
            get("/nearest-city").queryParam("line", coordinatesLine)
                .queryParam("column", coordinatesColumn))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"name\":\"Ribeirão Preto\"}"));

  }

  @ParameterizedTest
  @MethodSource("provideInvalidCoordinateValues")
  @DisplayName("should return bad request when coordinates are invalid")
  void shouldReturnBadRequestWhenCoordinatesAreInvalid(String line, String column)
      throws Exception {

    // act & assert
    mockMvc.perform(get("/nearest-city").queryParam("line", line).queryParam("column", column))
        .andExpect(status().isBadRequest());

  }

}
