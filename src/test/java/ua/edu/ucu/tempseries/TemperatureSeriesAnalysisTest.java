package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.00383;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.3;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testPositiveClosestToZero() {
        double[] temperatureSeries = {3.0, -1.0, 5.0, 1.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(11.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(1.0);
    }

    @Test
    public void testGreaterClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessThanWithEmptyResult() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0, 1.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[0];

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThan(1.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[0];

        // expect exception here
        double[] actualResult = seriesAnalysis.findTempsLessThan(0.1);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.0, 1.0};

        double[] actualResult = seriesAnalysis.findTempsLessThan(2.9);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterThanWithEmptyResult() {
        // setup input data and expected result
        double[] temperatureSeries = {10.0, 1.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[0];

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThan(11.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[0];

        // expect exception here
        double[] actualResult = seriesAnalysis.findTempsGreaterThan(0.1);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterThan() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, 5.0, 10.3};

        double[] actualResult = seriesAnalysis.findTempsGreaterThan(3.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        // setup input data and expected result
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0, 10.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        String expResult = "TempSummaryStatistics{avgTemp=2.8600000000000003, devTemp=5.003838526571377, minTemp=-5.0, maxTemp=10.3}";

        // call tested method
        String actualResult = seriesAnalysis.summaryStatistics().toString();

        // compare expected result with actual result
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTempsSize() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        int actualResult = seriesAnalysis.addTemps(1, 2, 0.4, -4.5);
        int expResult = 4;
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTempsToExistingSize() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[]{-3, 5});
        int actualResult = seriesAnalysis.addTemps(1, 2, 0.4, -4.5, 0);
        int expResult = 7;
        assertEquals(expResult, actualResult);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithImpossibleTemp() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[]{-3, 5});
        seriesAnalysis.addTemps(1, 2, 0.4, -4.5, -274);
    }

    @Test
    public void testEmptyAnalysisConstructor() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        int expResult = 0;
        int actualResult = seriesAnalysis.addTemps();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAnalysisConstructorWithArguments() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[]{1, 0.2});
        int expResult = 2;
        int actualResult = seriesAnalysis.addTemps();
        assertEquals(expResult, actualResult);
    }

    @Test(expected = InputMismatchException.class)
    public void testAnalysisConstructor() {
        new TemperatureSeriesAnalysis(new double[]{1, 0.2, -273.4});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryConstructor() {
        new TempSummaryStatistics();
    }

    @Test
    public void testToString() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(new double[]{1, 0.2});
        String actualResult = seriesAnalysis.toString();
        String expResult = "TemperatureSeriesAnalysis{tempSeries=[1.0, 0.2], currentSize=2}";
        assertEquals(expResult, actualResult);
    }
}
