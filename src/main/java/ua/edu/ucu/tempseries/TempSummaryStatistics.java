package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public final double avgTemp, devTemp, minTemp, maxTemp;

    public TempSummaryStatistics() throws IllegalArgumentException {
        throw new IllegalArgumentException("summary cannot be " +
                "unassociated with analysis");
    }

    public TempSummaryStatistics(TemperatureSeriesAnalysis seriesAnalysis) {
        avgTemp = seriesAnalysis.average();
        devTemp = seriesAnalysis.deviation();
        minTemp = seriesAnalysis.min();
        maxTemp = seriesAnalysis.max();
    }

    @Override
    public String toString() {
        return "TempSummaryStatistics{" +
                "avgTemp=" + avgTemp +
                ", devTemp=" + devTemp +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
