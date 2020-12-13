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
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                graphButtonClicked();
            }
        });
    }

    private void graphButtonClicked() {
        pnlChart.add(Test.getPanel());
        pack();
    }

    public static void main(String[] args) {
        new App();
    }
}
