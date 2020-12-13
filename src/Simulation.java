import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;
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

    public Simulation(double time, double vInit, double angle, double acceleration, double heightInitial, double distance) {
        this.time = time;
        this.vInit = vInit;
        this.angle = angle;
        this.acceleration = acceleration;
        this.heightInitial = heightInitial;
        this.distance = distance;
    }

    private Dataset createDataset() {
        XYSeries series = new XYSeries(0);



        XYSeriesCollection dataset = new XYSeriesCollection(series);
        return dataset;
    }

    private static double getPositionTime(double heightInitial, double velocity, double acceleration, double time) {
        return  heightInitial + velocity * time + (acceleration * Math.pow(time, 2)) / 2;
    }
}
