import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JFrame{
    private JPanel pnlMain;
    private JPanel pnlChart;
    private JTextField txtTime;
    private JTextField txtInitialVelocity;
    private JTextField txtAngle;
    private JTextField txtAcceleration;
    private JTextField txtInitialHeight;
    private JTextField txtDistance;
    private JLabel lblTime;
    private JLabel lblInitialVelocity;
    private JLabel lblAngle;
    private JLabel lblAcceleration;
    private JLabel lblDistance;
    private JLabel lblInitialHeight;
    private JButton btnGraph;


    public App() {
        setTitle("Projectile Motion Simulator");
        setContentPane(pnlMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        btnGraph.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                graphButtonClicked();
            }
        });
    }

    public double getInitialVelocity() {
        return Double.parseDouble(txtInitialVelocity.getText());
    }

    public double getAngle() {
        return Double.parseDouble(txtAngle.getText());
    }

    public double getAcceleration() {
        return Double.parseDouble(txtAcceleration.getText());
    }

    public double getInitialHeight() {
        return Double.parseDouble(txtInitialHeight.getText());
    }

    private void graphButtonClicked() {
        Simulation sim = new Simulation(getInitialVelocity(), getAngle(),  getAcceleration(), getInitialHeight());
        pnlChart.add(sim.getPanel());
        txtTime.setText(sim.getTime() + "");
        txtDistance.setText(sim.getDistance() + "");
        pack();
    }

    public static void main(String[] args) {
        new App();
    }
}
