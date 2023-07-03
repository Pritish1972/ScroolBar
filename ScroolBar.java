import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScroolBar implements AdjustmentListener {
    private Scrollbar red, green, blue;
    private TextField tf;

    public void ScrollAction() {
        Frame frame = new Frame("Color Scrollbar");
        red = new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255);
        green = new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255);
        blue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 20, 0, 255);

        tf = new TextField(20);
        tf.setForeground(Color.WHITE);

        tf.setBounds(50, 50, 300, 55);
        red.setBounds(50, 150, 300, 30);
        green.setBounds(50, 200, 300, 30);
        blue.setBounds(50, 250, 300, 30);

        frame.add(tf);
        frame.add(red);
        frame.add(green);
        frame.add(blue);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing");
                frame.dispose();
            }
        });
        red.addAdjustmentListener(this);
        green.addAdjustmentListener(this);
        blue.addAdjustmentListener(this);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        tf.setBackground(new Color(red.getValue(), green.getValue(), blue.getValue()));
    }

    public static void main(String[] args) {
        ScroolBar scrollBar = new ScroolBar();
        scrollBar.ScrollAction();
    }
}
