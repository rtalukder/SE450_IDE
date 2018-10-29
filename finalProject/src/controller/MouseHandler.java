package controller;

import controller.commands.ICommand;
import controller.commands.CreateShapeCommand;
import controller.commands.MoveCommand;
import controller.commands.SelectCommand;
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

    public MouseHandler(ApplicationState appState, Graphics2D graphics){
        this.appState = appState;
        this.graphics = graphics;
    }

    @Override
    public void mousePressed(MouseEvent e){
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
                if(e.getButton() == MouseEvent.BUTTON1) {
                    command = new CreateShapeCommand(graphics, startPoint, endPoint, shapeData);
                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                    ShapeData rightClickedShapeData = new ShapeData(appState.getActiveSecondaryColor(), appState.getActivePrimaryColor(), appState.getActiveShapeShadingType(), appState.getActiveShapeType());
                    command = new CreateShapeCommand(graphics, startPoint, endPoint, rightClickedShapeData);
                }
                break;
            case "SELECT":
                command = new SelectCommand();
                break;
            case "MOVE":
                command = new MoveCommand();
                break;
        }

        command.run();
    }
}
