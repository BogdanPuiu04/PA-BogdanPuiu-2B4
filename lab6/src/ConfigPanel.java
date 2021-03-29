import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo;
    JSpinner radius;
    JLabel sidesLabel;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JSpinner getRadius() {
        return radius;
    }

    private void init() {
        //create the label and the spinner
        JLabel radiusLabel=new JLabel("Size:");
        radius=new JSpinner(new SpinnerNumberModel(30,1,200,1));
        add(radiusLabel);
        add(radius);
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        colorCombo=new JComboBox();
        colorCombo.addItem("Red");
        colorCombo.addItem("Blue");
        colorCombo.addItem("Yellow");
        colorCombo.addItem("Cyan");
        colorCombo.addItem("Magenta");
        add(colorCombo);

    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }
}
