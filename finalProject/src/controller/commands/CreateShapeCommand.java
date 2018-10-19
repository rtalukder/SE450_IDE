package controller.commands;

import com.sun.media.sound.InvalidDataException;
import controller.Point;
import controller.ShapeList;
import controller.shapes.IShape;
import controller.shapes.ShapeFactory;
import model.ShapeType;
import model.persistence.ShapeData;
import view.gui.PaintCanvas;

import java.awt.*;

public class CreateShapeCommand extends PaintCanvas implements ICommand {
    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeData shapeData;

    private IShape shape;

    public CreateShapeCommand(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData) throws InvalidDataException {
        this.graphics = graphics;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeData = shapeData;

        String shapeTypeString = (shapeData.activeShapeType).toString();

        switch(shapeTypeString){
            case "RECTANGLE":
                shape = ShapeFactory.createRectangle(graphics, startPoint, endPoint, shapeData);
                break;

            case "ELLIPSE":
                shape = ShapeFactory.createEllipse(graphics, startPoint, endPoint, shapeData);
                break;

            case "TRIANGLE":
                shape = ShapeFactory.createTriangle(graphics, startPoint, endPoint, shapeData);
                break;
            }
        }

    @Override
    public void run() {
        ShapeList.addToShapeList(shape);
        shape.drawShape();
        //update();
        //shape.drawShape(graphics);
    }

}
