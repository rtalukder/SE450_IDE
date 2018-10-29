package controller.commands;

import controller.ShapeList;
import controller.shapes.IShape;
import controller.shapes.Shape;
import controller.Point;
import model.persistence.ShapeData;
import view.gui.PaintCanvas;

import java.awt.*;

public class CreateShapeCommand extends PaintCanvas implements ICommand {
    private IShape shape;

    public CreateShapeCommand(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
            shape = new Shape(graphics, startPoint, endPoint, shapeData);
        }

    @Override
    public void run() {
        ShapeList.addToShapeList(shape);
    }

}
