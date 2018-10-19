package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import controller.MouseHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        MouseAdapter mouseAdapter = new MouseHandler(appState, paintCanvas.getGraphics2D());
        paintCanvas.addMouseListener(mouseAdapter);

        controller.setup();

        // For example purposes only; remove from your final project.
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.RED);

/*        graphics2d.fillRect(12, 13, 200, 400);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(300, 150, 150, 200);
        graphics2d.drawRect(150, 150, 100, 200);
        graphics2d.setColor(Color.RED);
        graphics2d.drawRect(50, 600, 500, 10);*/
    }
}
