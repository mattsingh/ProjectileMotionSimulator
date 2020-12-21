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

    public Simulation(double vInit, double angle, double acceleration, double heightInitial) {
        this.vInit = vInit;
        this.angle = Math.toRadians(angle);
        this.acceleration = Math.abs(acceleration);
        this.heightInitial = heightInitial;
        this.time = quadraticFormula(-this.acceleration / 2, this.vInit * Math.sin(this.angle), this.heightInitial);
        this.distance = getXPositionTime(this.vInit * Math.cos(this.angle), time);

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
        for (double i = 0; i <= time; i += time / 1000) {
            xPosition = getXPositionTime(vInit * Math.cos(angle), i);
            yPosition = getYPositionTime(heightInitial, vInit * Math.sin(angle), acceleration, i);
            if (yPosition >= 0)
                series.add(xPosition, yPosition);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        return dataset;
    }

    private static double getYPositionTime(double heightInitial, double velocity, double acceleration, double time) {
        return  heightInitial + velocity * time + (-acceleration * Math.pow(time, 2)) / 2;
    }

    private static double getXPositionTime(double velocity, double time) {
        return velocity * time;
    }

    private static double quadraticFormula(double a, double b, double c) {
        return (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }

    public double getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public ChartPanel getPanel() {
        return new ChartPanel(chart);
    }
}
