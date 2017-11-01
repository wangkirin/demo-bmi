package io.servicecomb.samples.bmi;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = CalculatorApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT
)
public class CalculatorApplicationIT {
  private final RestTemplate restTemplate = new RestTemplate();

  @Test
  public void getCalculatorResult() {
    String serviceAddress = "http://localhost:8081";
    ResponseEntity<Double> responseEntity = restTemplate.getForEntity(
        serviceAddress + "/bmi?height=170&weight=68",
        Double.class);

    assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
  }
}
