package main;

import controller.*;
import controller.interfaces.IJPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

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

        ShapeDraw observer = new ShapeDraw(paintCanvas.getGraphics2D());
        ShapeList handler = new ShapeList();
        handler.registerObserver(observer);

        controller.setup();

    }
}
