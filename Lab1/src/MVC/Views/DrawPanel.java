package MVC.Views;

import MVC.Model.ModelWorld;
import MVC.Model.Vehicles.Movable;
import MVC.Model.Vehicles.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    ModelWorld model;

    // Just a single image, TODO: Generalize
    private BufferedImage volvoServiceImage;

    // TODO: Make this general for all cars
    /*public void moveit(Vehicle vehicle, int x, int y){

    }*/
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ModelWorld model) {
        this.setDoubleBuffered(true);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.model = model;

        try {
            volvoServiceImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Movable vehicle : model.getVehicles().keySet()) {
            String path = model.getVehicles().get(vehicle);
            BufferedImage image = null;
            try {
                image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/" + path)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.drawImage(image, (int) Math.round(vehicle.getPosition().getFirst()), (int) Math.round(vehicle.getPosition().getLast()), null);
        }
        g.drawImage(volvoServiceImage, 300, 300, null);
    }
}
