import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Simulation {
    private double time;
    private double vInit;
    private double angle;
    private double acceleration;
    private double heightInitial;
    private double distance;
    private JFreeChart chart;

    public Simulation(double time, double vInit, double angle, double acceleration, double heightInitial) {
        this.time = time;
        this.vInit = vInit;
        this.angle = Math.toRadians(angle);
        this.acceleration = Math.abs(acceleration);
        this.heightInitial = heightInitial;
        this.distance = getPositionTime(vInit * Math.cos(angle), time);

        chart = ChartFactory.createXYLineChart(
                null,
                null,
                null,
                createDataset(),
                PlotOrientation.VERTICAL,
                false, false, false);
    }

    private XYDataset createDataset() {
        XYSeries series = new XYSeries(0);

        double xPosition;
        double yPosition = 0;
        for (double i = 0; yPosition >= 0; i += time / 100) {
            xPosition = getPositionTime(vInit * Math.cos(angle), i);
            yPosition = getPositionTime(heightInitial, vInit * Math.sin(angle), acceleration, i);
            if (yPosition >= 0)
                series.add(xPosition, yPosition);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        return dataset;
    }

    private static double getPositionTime(double heightInitial, double velocity, double acceleration, double time) {
        return  heightInitial + velocity * time + (acceleration * Math.pow(time, 2)) / 2;
    }

    private static double getPositionTime(double velocity, double time) {
        return velocity * time;
    }

    public ChartPanel getPanel() {
        return new ChartPanel(chart);
    }
}
