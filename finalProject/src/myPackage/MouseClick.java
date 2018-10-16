package myPackage;

import controller.commands.ICommand;
import controller.commands.CreateShapeCommand;
import controller.Point;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends MouseAdapter {

    private int xClick;
    private int yClick;
    private int xRelease;
    private int yRelease;

    @Override
    public void mousePressed(MouseEvent e){
        xClick = e.getX();
        yClick = e.getY();

        System.out.println("Mouse clicked x-coordinate: " + e.getX());
        System.out.println("Mouse clicked y-coordinate: " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e){
        xRelease = e.getX();
        yRelease = e.getY();

        System.out.println("Mouse released x-coordinate: " + e.getX());
        System.out.println("Mouse released y-coordinate: " + e.getY());


        ICommand command = new CreateShapeCommand(new Point(xClick, yClick, xRelease, yRelease).normalizedCoordinates());

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
