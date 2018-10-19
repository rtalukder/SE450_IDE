package controller;

import com.sun.media.sound.InvalidDataException;
import controller.commands.ICommand;
import controller.commands.CreateShapeCommand;
import controller.Point;
import model.persistence.ApplicationState;
import model.persistence.ShapeData;
import main.Main;

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

        System.out.println("Mouse clicked x-coordinate: " + e.getX());
        System.out.println("Mouse clicked y-coordinate: " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e){
        int xRelease = e.getX();
        int yRelease = e.getY();

        endPoint = new Point(xRelease, yRelease);

        System.out.println("Mouse released x-coordinate: " + e.getX());
        System.out.println("Mouse released y-coordinate: " + e.getY());

        System.out.println(appState.getActivePrimaryColor());
        System.out.println(appState.getActiveSecondaryColor());

        ShapeData shapeData = new ShapeData(appState.getActivePrimaryColor(), appState.getActiveSecondaryColor(), appState.getActiveShapeShadingType(), appState.getActiveShapeType());

        ICommand command = null;

        try {
            command = new CreateShapeCommand(graphics, startPoint, endPoint, shapeData);
        } catch (InvalidDataException message) {
            message.printStackTrace();
        }
        command.run();
    }
}
