package ua.yandex.shad.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {    

    private static final int TEMP_SERIES_ARRAY_CAPACITY_DEFAULT = 10;
    private static final double ABSOLUTE_MINIMUM_TEMP           = -273;
    private static final double EPSILON                         = 0.00001;

    private double[] temperatureSeries     = null;
    private int temperatureSeriesArrayCapacity;
    private int temperatureSeriesArraySize = 0;

    public TemperatureSeriesAnalysis() {
        temperatureSeriesArrayCapacity = TEMP_SERIES_ARRAY_CAPACITY_DEFAULT;
        temperatureSeries          = new double[temperatureSeriesArrayCapacity];
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatureSeriesArraySize     = temperatureSeries.length;
        temperatureSeriesArrayCapacity = temperatureSeriesArraySize
                                       + TEMP_SERIES_ARRAY_CAPACITY_DEFAULT;
        this.temperatureSeries = new double[temperatureSeriesArrayCapacity];
        for (int i = 0; i < temperatureSeriesArraySize; i++) {
            if (temperatureSeries[i] < ABSOLUTE_MINIMUM_TEMP) {
                throw new InputMismatchException();
            }
            this.temperatureSeries[i] = temperatureSeries[i];
        }
    }
    
    public double average() {
        if (temperatureSeriesArraySize == 0) {
            throw new IllegalArgumentException();
        }
        
        double totalTemperature = 0;
        for (int i = 0; i < temperatureSeriesArraySize; i++) {
            totalTemperature += temperatureSeries[i];
        }
        
        return totalTemperature / temperatureSeriesArraySize;
    }    
    
    public double deviation() {
        //if temperatureSeries is empty then
        //this.average() will throw IllegalArgumentException;
        double averageTemperature = this.average();
        
        double sumOfSquaresOfDeviationsFromAverage = 0;
        for (int i = 0; i < temperatureSeriesArraySize; i++) {
            double difference = temperatureSeries[i] - averageTemperature;
            sumOfSquaresOfDeviationsFromAverage += difference * difference;
        }
        
        return Math.sqrt(sumOfSquaresOfDeviationsFromAverage
                         / temperatureSeriesArraySize);
    }
    
    public double min() {
        if (temperatureSeriesArraySize == 0) {
            throw new IllegalArgumentException();
        }
        
        double minTemperature = temperatureSeries[0];
        for (int i = 1; i < temperatureSeriesArraySize; i++) {
            if (temperatureSeries[i] < minTemperature) {
                minTemperature = temperatureSeries[i];
            }
        }
        
        return minTemperature;
    }
     
    public double max() {
        if (temperatureSeriesArraySize == 0) {
            throw new IllegalArgumentException();
        }
        
        double maxTemperature = temperatureSeries[0];
        for (int i = 1; i < temperatureSeriesArraySize; i++) {
            if (temperatureSeries[i] > maxTemperature) {
                maxTemperature = temperatureSeries[i];
            }
        }
        
        return maxTemperature;
    }
    
    public double findTempClosestToZero() {
        //if temperatureSeries is empty then
        //findTempClosestToValue() will throw IllegalArgumentException;
        return findTempClosestToValue(0.0);
    }
    
    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeriesArraySize == 0) {
            throw new IllegalArgumentException();
        }
        
        double tempClosestToVal              = temperatureSeries[0];
        double absDiffTempClosestToValAndVal = tempClosestToVal;
        if (tempClosestToVal < 0) {
            absDiffTempClosestToValAndVal = -tempClosestToVal;
        }
        for (int i = 1; i < temperatureSeriesArraySize; i++) {
            double absDiffCurrTempAndVal = temperatureSeries[i] - tempValue;
            if (absDiffCurrTempAndVal < 0) {
                absDiffCurrTempAndVal = -absDiffCurrTempAndVal;
            }
            
            if (absDiffCurrTempAndVal < absDiffTempClosestToValAndVal) {
                absDiffTempClosestToValAndVal = absDiffCurrTempAndVal;
                tempClosestToVal              = temperatureSeries[i];
            }
            
            if (Math.abs(absDiffCurrTempAndVal
                                -absDiffTempClosestToValAndVal) < EPSILON
                && temperatureSeries[i] > -EPSILON) {
                absDiffTempClosestToValAndVal = absDiffCurrTempAndVal;
                tempClosestToVal              = temperatureSeries[i];
            }
        }
        
        return tempClosestToVal;
    }
    
    private double[] findTempsLessOrGreaterThen(double tempValue,
                                                boolean searchGreater) {
        if (temperatureSeriesArraySize == 0) {
            throw new IllegalArgumentException();
        }
        
        int foundTempsNumber      = 0;
        double[] tempsLessThenVal = new double[temperatureSeriesArraySize];
        
        for (int i = 0; i < temperatureSeriesArraySize; i++) {
            if (temperatureSeries[i] - tempValue < EPSILON != searchGreater
                && Math.abs(temperatureSeries[i] - tempValue) >= EPSILON) {
                tempsLessThenVal[foundTempsNumber++] = temperatureSeries[i];
            }
        }
        
        if (foundTempsNumber == 0) {
            return new double[0];
        }
        
        double[] result = new double[foundTempsNumber];
        for (int i = 0; i < foundTempsNumber; i++) {
            result[i] = tempsLessThenVal[i];
        }
        
        return result;
    }
    
    public double[] findTempsLessThen(double tempValue) {
        //if temperatureSeries is empty then
        //findTempsLessOrGreaterThen() will throw IllegalArgumentException;
        return findTempsLessOrGreaterThen(tempValue, false);
    }
    
    public double[] findTempsGreaterThen(double tempValue) {
        //if temperatureSeries is empty then
        //findTempsLessOrGreaterThen() will throw IllegalArgumentException;
        return findTempsLessOrGreaterThen(tempValue, true);
    }
    
    public TempSummaryStatistics summaryStatistics() {
        if (temperatureSeriesArraySize == 0) {
            throw new IllegalArgumentException();
        }
        
        return new TempSummaryStatistics(average(), deviation(), 
                                         min(), max());
    }
    
    public int addTemps(double ... temps) {
        if (temps.length == 0) {
            return temperatureSeriesArraySize;
        }
        
        int newTempSeriesCapacity = temperatureSeriesArrayCapacity;
        int newTempSeriesSize     = temperatureSeriesArraySize + temps.length;
        while (newTempSeriesCapacity < newTempSeriesSize) {
            newTempSeriesCapacity = newTempSeriesCapacity
                                    + newTempSeriesCapacity;
        }
        
        double[] newTempSeries;
        boolean needToCreateNewArray = false;
        if (newTempSeriesCapacity == temperatureSeriesArrayCapacity) {
            newTempSeries = temperatureSeries;
        }
        else {
            newTempSeries        = new double[newTempSeriesCapacity];
            needToCreateNewArray = true;
        }

        for (int i = 0; i < temps.length; i++) {
            if (temps[i] < ABSOLUTE_MINIMUM_TEMP) {
                throw new InputMismatchException();
            }
            newTempSeries[temperatureSeriesArraySize + i] = temps[i];
        }
        if (needToCreateNewArray) {
            for (int i = 0; i < temperatureSeriesArraySize; i++) {
                newTempSeries[i] = temperatureSeries[i];
            }
            
            temperatureSeries              = newTempSeries;
            temperatureSeriesArrayCapacity = newTempSeriesCapacity;
        }
        
        temperatureSeriesArraySize = newTempSeriesSize;
        
        return temperatureSeriesArraySize;
    }
    
}
