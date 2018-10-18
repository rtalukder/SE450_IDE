package view.gui;

import model.persistence.ShapeData;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {
    private ShapeData shapeData;

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }


}
