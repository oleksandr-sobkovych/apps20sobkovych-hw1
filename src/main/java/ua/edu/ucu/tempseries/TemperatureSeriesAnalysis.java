package ua.edu.ucu.tempseries;

import array.operations.ArrayCheckMargin;
import array.operations.ArrayLengthExtend;
import comparisons.*;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] tempSeries;
    private int currentSize;
    private static final int LOWER_BOUND = -273, EXTEND = 2;
    private static final Less less = new Less();
    private static final GreaterEqual greater = new GreaterEqual();
    private static final ArrayCheckMargin checkMargin = new ArrayCheckMargin();
    private static final ArrayLengthExtend ext = new ArrayLengthExtend(EXTEND);

    public TemperatureSeriesAnalysis() {
        /*
        Default constructor.
        */
        this.currentSize = 0;
        this.tempSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        /*
        Constructor with parameters, creates an array of exact length, test for absolute zero.
        Still initializes an empty array if exception is caught.
         */
        this();
        if (checkMargin.checkAnyMargin(temperatureSeries, LOWER_BOUND, temperatureSeries.length, less)) {
            throw new InputMismatchException("Initial array has impossibly low temperatures");
        }
        else {
            this.currentSize = temperatureSeries.length;
            this.tempSeries = temperatureSeries.clone();
        }
    }

    private void emptySeriesCheck(String methodName) {
        /*
        Check if array is empty.
        */
        if (currentSize == 0) {
            throw new IllegalArgumentException("no " + methodName + " for empty array");
        }
    }

    public double average() {
        /*
        Find mean of series in linear time.
         */
        emptySeriesCheck("average");
        double sum = 0;
        for (int i = 0; i < currentSize; i++) sum += tempSeries[i];
        return sum / currentSize;
    }

    public double deviation() {
        /*
        Find standard deviation of series in linear time.
         */
        emptySeriesCheck("deviation");
        double avg = average();
        double sum = 0;
        for (int i = 0; i < currentSize; i++) sum += Math.pow(tempSeries[i] - avg, 2);
        return Math.sqrt(sum / currentSize);
    }

    private double extreme(CompareDoubles compareDoubles) {
        /*
        Find extreme of series in linear time according to comparator.
         */
        double current = this.tempSeries[0];
        for (int i = 0; i < currentSize; i++) {
            if (compareDoubles.compare(tempSeries[i], current)) {
                current = tempSeries[i];
            }
        }
        return current;
    }

    public double min() {
        emptySeriesCheck("min");
        return extreme(less);
    }

    public double max() {
        emptySeriesCheck("max");
        return extreme(greater);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        /*
        Find closest temperature to value. If there are multuple take the greater one.
         */
        emptySeriesCheck("closest temperatures to " + tempValue);
        double current = this.tempSeries[0];
        for (int i = 0; i < currentSize; i++) {
            double tempDistance = Math.abs(tempSeries[i]-tempValue);
            double currentDistance = Math.abs(current-tempValue);
            if ((tempDistance < currentDistance) ||
                    ((tempDistance == currentDistance && (tempSeries[i] > current)))) {
                current = tempSeries[i];
            }
        }
        return current;
    }

    private double[] findTempsComparedToMargin(double tempValue, CompareDoubles compareDoubles) {
        /*
        Find all values in accordance with the comparator. Fits the values.
         */
        double[] fitting = new double[0];
        int size = 0;
        for (int i = 0; i < currentSize; i++) {
            if (size == fitting.length) {
                fitting = Arrays.copyOf(fitting, ext.extend(fitting.length));
            }
            if (compareDoubles.compare(tempSeries[i], tempValue)) {
                fitting[size] = tempSeries[i];
                size++;
            }
        }
        return Arrays.copyOf(fitting, size);
    }
    
    public double[] findTempsLessThan(double tempValue) {
        return findTempsComparedToMargin(tempValue, less);
    }

    public double[] findTempsGreaterThan(double tempValue) {
        // actually finds greater-equal than in accordance with the task
        return findTempsComparedToMargin(tempValue, greater);
    }

    public TempSummaryStatistics summaryStatistics() {
        /*
        Return a representation of statistics.
         */
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        /*
        Add any number of temperatures. Check for absolute zero, extend array in accordance with the coefficient.
         */
        if (checkMargin.checkAnyMargin(temps, LOWER_BOUND, temps.length, less)) {
            throw new InputMismatchException("impossibly low temperature in arguments");
        } else {
            int newLen = tempSeries.length;
            while (temps.length + currentSize > newLen) {
                newLen = ext.extend(newLen);
            }
            this.tempSeries = Arrays.copyOf(tempSeries, newLen);
            for (double temp : temps) {
                tempSeries[currentSize] = temp;
                currentSize++;
            }
            return currentSize;
        }
    }

    @Override
    public String toString() {
        return "TemperatureSeriesAnalysis{" +
                "tempSeries=" + Arrays.toString(tempSeries) +
                ", currentSize=" + currentSize +
                '}';
    }
}
