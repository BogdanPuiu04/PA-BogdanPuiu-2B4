
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Locale;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(5, 6, W, H);
    }

    private void createOffscreenImage(BufferedImage img) {
        image = img;
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(5, 6, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    public void loadImage(BufferedImage image) {
        graphics.drawImage(image, 0, 0, null);
        repaint();
    }

    private void drawShape(int x, int y) {
        int radius = (int)frame.configPanel.getRadius().getValue(); //generate a random number
        int sides = (int) frame.configPanel.getSidesField().getValue();
        String colorString = (String) frame.configPanel.getColorCombo().getSelectedItem();
        Color color;
        switch (colorString.toLowerCase()) {
            case "red":
                color = Color.RED;
                break;
            case "yellow":
                color = Color.yellow;
                break;
            case "blue":
                color = Color.blue;
                break;
            case "cyan":
                color = Color.cyan;
                break;
            case "magenta":
                color=Color.magenta;
                break;
            default:
                color = Color.black;
        }
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        graphics.setColor(Color.BLACK);
        graphics.draw(new RegularPolygon(x, y, radius, sides));
    }


    @Override
    public void update(Graphics g) {
        g.drawImage(image, 0, 0, this);
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void resetCanvas() {
        this.createOffscreenImage();
        repaint();
    }
}





