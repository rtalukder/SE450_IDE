package view.gui;

import controller.MouseHandler;
import model.persistence.ApplicationState;
import model.persistence.ShapeData;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {
    private ShapeData shapeData;

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    public void getApplicationState(ApplicationState appState){

    }


}
