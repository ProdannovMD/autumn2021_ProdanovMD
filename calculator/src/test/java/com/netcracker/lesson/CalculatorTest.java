package com.netcracker.lesson;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void addTest() {
        Assert.assertEquals(0, Calculator.add(2, -2));
        Assert.assertEquals(3, Calculator.add(0, 3));
        Assert.assertEquals(3, Calculator.add(3, 0));
        Assert.assertEquals(53, Calculator.add(22, 31));
    }

    @Test
    public void subtractTest() {
        Assert.assertEquals(0, Calculator.subtract(2, 2));
        Assert.assertEquals(-3, Calculator.subtract(0, 3));
        Assert.assertEquals(3, Calculator.subtract(3, 0));
        Assert.assertEquals(111, Calculator.subtract(123, 12));
    }

    @Test
    public void multiplyTest() {
        Assert.assertEquals(0, Calculator.multiply(0, 3));
        Assert.assertEquals(0, Calculator.multiply(3, 0));
        Assert.assertEquals(3, Calculator.multiply(1, 3));
        Assert.assertEquals(3, Calculator.multiply(3, 1));
        Assert.assertEquals(-9, Calculator.multiply(-3, 3));
        Assert.assertEquals(-9, Calculator.multiply(3, -3));
        Assert.assertEquals(33, Calculator.multiply(11, 3));
    }

    @Test
    public void divideTest() {
        Assert.assertEquals(0, Calculator.divide(0, 3));
        Assert.assertEquals(0, Calculator.divide(1, 3));
        Assert.assertEquals(3, Calculator.divide(3, 1));
        Assert.assertEquals(-1, Calculator.divide(-3, 3));
        Assert.assertEquals(-1, Calculator.divide(3, -3));
        Assert.assertEquals(1, Calculator.divide(3, 3));
        Assert.assertEquals(11, Calculator.divide(33, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void divideNegativeTest() {
        Calculator.divide(1, 0);
    }

}
