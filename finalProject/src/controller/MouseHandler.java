package controller;

import controller.interfaces.ICommand;
import controller.commands.CreateShapeCommand;
import controller.commands.MoveShapeCommand;
import controller.commands.SelectShapeCommand;
import model.persistence.ApplicationState;
import model.persistence.ShapeData;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ApplicationState appState;
    private MouseEvent e;

    public MouseHandler(ApplicationState appState, Graphics2D graphics){
        this.appState = appState;
        this.graphics = graphics;
    }

    @Override
    public void mousePressed(MouseEvent e){
        this.e = e;
        int xClick = e.getX();
        int yClick = e.getY();

        startPoint = new Point(xClick, yClick);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int xRelease = e.getX();
        int yRelease = e.getY();

        endPoint = new Point(xRelease, yRelease);

        ShapeData shapeData = new ShapeData(appState.getActivePrimaryColor(), appState.getActiveSecondaryColor(), appState.getActiveShapeShadingType(), appState.getActiveShapeType());
        ICommand command = null;

        switch (appState.getActiveStartAndEndPointMode().toString()){
            case "DRAW":
                // left click
                if(e.getButton() == MouseEvent.BUTTON1) {
                    command = new CreateShapeCommand(graphics, startPoint, endPoint, shapeData);
                }
                // right click
                else if(e.getButton() == MouseEvent.BUTTON3) {
                    // primary and secondary colors are switches for ShapeData params
                    ShapeData rightClickedShapeData = new ShapeData(appState.getActiveSecondaryColor(), appState.getActivePrimaryColor(), appState.getActiveShapeShadingType(), appState.getActiveShapeType());
                    command = new CreateShapeCommand(graphics, startPoint, endPoint, rightClickedShapeData);
                }
                break;
            case "SELECT":
                command = new SelectShapeCommand(startPoint, endPoint);
                break;
            case "MOVE":
                command = new MoveShapeCommand(startPoint, endPoint);
                break;
        }

        command.run();
    }
}
