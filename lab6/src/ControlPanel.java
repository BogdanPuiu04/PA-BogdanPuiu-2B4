import javax.accessibility.AccessibleRelation;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    //create all buttons (Load, Reset, Exit)
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init()  {

        add(saveBtn);
        add(resetBtn);
        add(loadBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);


    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("D:/PA/lab6/test.PNG"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


    private void load(ActionEvent e) {
        try {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                BufferedImage img = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                frame.canvas.loadImage(img);
            }


        }
      catch (IOException ex) {
          System.err.println(ex);
       }

    }
    private void exit(ActionEvent e){
        System.exit(0);
    }
    private void reset(ActionEvent e){
        frame.canvas.resetCanvas();
    }
}
