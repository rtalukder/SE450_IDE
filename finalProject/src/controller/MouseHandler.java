package controller;

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
    private ShapeData shapeDetails;
    private Point startPoint;
    private Point endPoint;

    public MouseHandler(ApplicationState appState, Graphics2D graphics){
        shapeDetails = appState.getShapeDataObject();
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

        ICommand command = new CreateShapeCommand(graphics, startPoint, endPoint, shapeDetails);
        command.run();
    }
}
