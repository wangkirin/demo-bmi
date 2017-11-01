package io.servicecomb.samples.bmi;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorServiceImplTest {

  @Test
  public void testCalculate() throws Exception {

    CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    try {
      calculatorService.calculate(-170, 68);
      Assert.fail("Expect exception but not");
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(true, true);
    }

    try {
      calculatorService.calculate(170, -68);
      Assert.fail("Expect exception but not");
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(true, true);
    }

    try {
      calculatorService.calculate(0, 68);
      Assert.fail("Expect exception but not");
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(true, true);
    }

    try {
      calculatorService.calculate(170, 0);
      Assert.fail("Expect exception but not");
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(true, true);
    }

    try {
      Assert.assertThat(calculatorService.calculate(170, 68),is(23.5));
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(true, false);
    }

  }

}