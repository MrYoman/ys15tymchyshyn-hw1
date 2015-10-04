package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;
import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {
    
    //It's not my test!!!
    @Test
    public void testAverage() {
        double[] temperatureSeries = {1.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 0.0;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.average();
    }
    
    @Test
    public void testAverageWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {23.0, -200, -273.0, 11.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -109.75;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testAverageWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {23.0, -200, 273.0, 11.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 26.75;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testAverageWhenExistsGreaterThenMinusAbsoluteMinTemp() {
        double[] temperatureSeries = {0.0, -200, 400.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 52.5;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = InputMismatchException.class)
    public void testConstructorWhenExistsTempLessThenAbsoluteMinimumTemp() {
        double[] temperatureSeries = {23.0, -200, -273.1, 11.3};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
    }
    
    @Test
    public void testConstructorWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {23.0, -200, -273.0, 11.3};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
    }
    
    @Test
    public void testEmptyConstructor() {
        TemperatureSeriesAnalysis seriesAnalysis = 
                                                new TemperatureSeriesAnalysis();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.deviation();
    }
    
    @Test
    public void testDeviationWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {10.0, -200, -273.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 123.762878;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testDeviationWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {1.0, -200, 273.0, -20.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 151.226188;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testDeviationWhenExistsGreaterThenMinusAbsoluteMinTemp() {
        double[] temperatureSeries = {0.0, -200, 400.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 217.413776;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testDeviation() {
        double[] temperatureSeries = {10.5, -100, 500.0, 123.0, 4.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 208.504532;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMinWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.min();
    }
    
    @Test
    public void testMinWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {10.0, -200, -273.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -273.0;
        double actualResult = seriesAnalysis.min();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMinWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {1.0, -200, 273.0, -20.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -200.0;
        double actualResult = seriesAnalysis.min();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMinWhenExistsGreaterThenMinusAbsoluteMinTemp() {
        double[] temperatureSeries = {-159.0, -11, 400.0, 10.0, -158.9};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -159.0;
        double actualResult = seriesAnalysis.min();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMin() {
        double[] temperatureSeries = {10.5, -100.0, 500.0, -200.0, 4.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -200.0;
        double actualResult = seriesAnalysis.min();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMaxWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.max();
    }
    
    @Test
    public void testMaxWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {120.0, 20.0, -156.2, -273.0, 15.6};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 120.0;
        double actualResult = seriesAnalysis.max();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMaxWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {145.0, -205.0, 273.0, -20.0, 273.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 273.0;
        double actualResult = seriesAnalysis.max();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMaxWhenExistsGreaterThenMinusAbsoluteMinTemp() {
        double[] temperatureSeries = {-159.0, 500.0, 400.0, 10.0, -158.9};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 500.0;
        double actualResult = seriesAnalysis.max();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testMax() {
        double[] temperatureSeries = {600.01, -100.0, 500.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 600.01;
        double actualResult = seriesAnalysis.max();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToZero();
    }
    
    @Test
    public void testFindTempClosestToZeroWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {120.0, 20.0, -156.2, -273.0, 15.6};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 15.6;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToZeroWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {145.0, -205.0, 273.0, -20.0, 273.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -20.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToZeroIsTempGreaterThenMinusAbsMinTemp() {
        double[] temperatureSeries = {-159.0, 500.0, 400.0, 10.0, -158.9};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 10.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToZeroWhenExistPositAndNegatAnswers() {
        double[] temperatureSeries = {600.01, -1.0, 1.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToZeroWhenExistsZero() {
        double[] temperatureSeries = {600.01, -1.0, 0.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 0.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {600.01, -100.0, 500.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -100.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToValue(1.0);
    }
    
    @Test
    public void testFindTempClosestToValueWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {120.0, 20.0, -156.2, -273.0, 15.6};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 20.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(18.0);
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToValueWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {145.0, -205.0, 273.0, -20.0, 273.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = -20.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(-100.0);
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToValueIsTempGreaterThenMinusAbsMinTemp() {
        double[] temperatureSeries = {-159.0, 500.0, 400.0, 10.0, -158.9};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 10.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(9.0);
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToValueWhenExistPositAndNegatAnswers() {
        double[] temperatureSeries = {600.01, -1.0, 3.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 3.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(2.0);
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToValueWhenExistsValue() {
        double[] temperatureSeries = {600.01, -1.0, 5.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(5.0);
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {600.01, -100.0, 600.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult    = 600.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(500.0);
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsLessThen(1.0);
    }
    
    @Test
    public void testFindTempsLessThenWhenResultIsEmpty() {
        double[] temperatureSeries = {600.01, -100.0, 600.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[0];
        double[] actualResult = seriesAnalysis.findTempsLessThen(-200.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test
    public void testFindTempsLessThenIfTwoTempsAreEqual() {
        double[] temperatureSeries = {12.0, -100.0, 12.0, 456.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[] {12.0, -100.0, 12.0, -30.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(15.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test
    public void testFindTempsLessThenWhenExistsSupremum() {
        double[] temperatureSeries = {600.01, -100.0, 50.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[] {-100.0, -30.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(50.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {600.01, -100.0, 600.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[] {-100.0, -30.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(-20.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsGreaterThen(1.0);
    }
    
    @Test
    public void testFindTempsGreaterThenWhenResultIsEmpty() {
        double[] temperatureSeries = {600.01, -100.0, 600.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[0];
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1000.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test
    public void testFindTempsGreaterThenIfTwoTempsAreEqual() {
        double[] temperatureSeries = {12.0, -100.0, 12.0, 456.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[] {12.0, 12.0, 456.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(10.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test
    public void testFindTempsGreaterThenWhenExistsInfinum() {
        double[] temperatureSeries = {600.01, -100.0, 50.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[] {600.01, 900.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(50.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {0.0, -100.0, 600.0, 900.0, -30.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult    = new double[] {0.0, 600.0, 900.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-20.0);
        
        if (Arrays.equals (actualResult, expResult)) {
            return;
        }
        fail();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWhenTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        seriesAnalysis.summaryStatistics();
    }
    
    @Test
    public void testSummaryStatisticsAvgIfExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {23.0, -200, -273.0, 11.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = -109.75;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getAverageTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsAvgIfExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {23.0, -200, 273.0, 11.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 26.75;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getAverageTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsIfIsTempGreaterThenMinusAbsoluteMinTemp() {
        double[] temperatureSeries = {0.0, -200, 400.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 52.5;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getAverageTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsAverage() {
        double[] temperatureSeries = {1.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 0.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getAverageTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsDeviationWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {10.0, -200, -273.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 123.762878;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getDeviationTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsDevWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {1.0, -200, 273.0, -20.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 151.226188;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getDeviationTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsDevIfIsTempGreaterThenMinusAbsMinTemp() {
        double[] temperatureSeries = {0.0, -200, 400.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 217.413776;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getDeviationTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsDeviation() {
        double[] temperatureSeries = {10.5, -100, 500.0, 123.0, 4.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 208.504532;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getDeviationTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMinWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {10.0, -200, -273.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = -273.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMinTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMinWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {1.0, -200, 273.0, -20.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = -200.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMinTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMinIfExistsGreaterThenMinusAbsMinTemp() {
        double[] temperatureSeries = {-159.0, -11, 400.0, 10.0, -158.9};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = -159.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMinTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMin() {
        double[] temperatureSeries = {10.5, -100.0, 500.0, -200.0, 4.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = -200.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMinTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMaxWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {120.0, 20.0, -156.2, -273.0, 15.6};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 120.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMaxTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMaxWhenExistsMinusAbsoluteMinimumTemp() {
        double[] temperatureSeries = {145.0, -205.0, 273.0, -20.0, 273.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 273.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMaxTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMaxIfExistsGreaterThenMinusAbsMinTemp() {
        double[] temperatureSeries = {-159.0, 500.0, 400.0, 10.0, -158.9};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 500.0;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMaxTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testSummaryStatisticsMax() {
        double[] temperatureSeries = {600.01, -100.0, 500.0, -200.0, 600.0};
        TemperatureSeriesAnalysis seriesAnalysis =
                               new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult              = 600.01;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult           = sumStat.getMaxTemp();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testAddTempsWhenTempSeriesAreBothEmpty() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        
        int expResult    = 0;
        int actualResult = seriesAnalysis.addTemps(new double[0]);
        
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testAddTempsWhenStartTempSeriesSizeIsZero() {
        TemperatureSeriesAnalysis seriesAnalysis =
                                               new TemperatureSeriesAnalysis();
        
        int expResult    = 2;
        int actualResult = seriesAnalysis.addTemps(9.9, 8.0);
        
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testAddTempsWhenAddTempSeriesSizeIsZero() {
        double[] temperatureSeries = {156.2, -10.0, 0.0, 3.2, 15.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        int expResult    = 5;
        int actualResult = seriesAnalysis.addTemps(new double[0]);
        
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testAddTempsWhenCapacityIsTooSmall() {
        double[] temperatureSeries = {156.2, -10.0, 0.0, 3.2, 15.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        int expResult    = 35;
        int actualResult = seriesAnalysis.addTemps(new double[30]);
        
        assertEquals(expResult, actualResult);
    }
    
    @Test(expected = InputMismatchException.class)
    public void testAddTempsWhenExistsAbsoluteMinimumTemp() {
        double[] temperatureSeries = {-274.0, -10.0, 0.0, 3.2, 15.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        seriesAnalysis.addTemps(new double[30]);
    }
    
    @Test
    public void testAddTempsWhenCapacityIsEnoughBig() {
        double[] temperatureSeries = {156.2, -10.0, 0.0, 3.2, 15.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        int expResult    = 8;
        int actualResult = seriesAnalysis.addTemps(0.5, 4.3, -15.7);
        
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testAddTempsWhenFirstlyExistsAbsoluteMinTemp() {
        double[] temperatureSeries = {156.2, -10.0, 0.0, -273.0, 15.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        int expResult    = 35;
        int actualResult = seriesAnalysis.addTemps(new double[30]);
        
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testAddTempsWhenInAddArrayExistsAbsoluteMinTemp() {
        double[] temperatureSeries = {156.2, -10.0, 0.0, 45.2, 15.5};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        int expResult    = 6;
        int actualResult = seriesAnalysis.addTemps(-273.0);
        
        assertEquals(expResult, actualResult);
    }
 
    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {156.2, -10.0, 0.0, -273.0, 15.5,
                                      654.2, -89.0, 9.0, -123.0, 17.5, 0.2};
        TemperatureSeriesAnalysis seriesAnalysis =
                              new TemperatureSeriesAnalysis(temperatureSeries);
        
        int expResult    = 21;
        int actualResult = seriesAnalysis.addTemps(146.0, -17.0, -8.0, -273.0, 
                                                   15.5, 0.0, 78.3, 456.2,
                                                   78.5, 15.3);
        
        assertEquals(expResult, actualResult);
    }
 
}
