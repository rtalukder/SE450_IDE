package myPackage;

import controller.commands.ICommand;
import controller.commands.CreateShapeCommand;
import controller.Point;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {

    private Point startPoint;
    private Point endPoint;

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


        ICommand command = new CreateShapeCommand();

        // TODO
        /*  Create application state object that has the following:
        * - active shape type
        * - primary color
        * - secondary color
        * - shading type
        *
        * Pass this object into createshapecommand()                 */



        command.run();
    }
}
