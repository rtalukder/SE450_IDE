package controller.commands;

import controller.Point;
import controller.ShapeList;
import model.persistence.ShapeData;
import view.gui.PaintCanvas;
import controller.ShapeList;

import java.awt.*;

public class CreateShapeCommand extends PaintCanvas implements ICommand {
    private Graphics2D graphics;
    private Point startPoint;
    private Point endPoint;
    private ShapeData shapeData;

    public CreateShapeCommand(Graphics2D graphics, Point startPoint, Point endPoint, ShapeData shapeData){
        this.graphics = graphics;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeData = shapeData;

//        ShapeList.addToShapeList(createdShape);
    }

    



    @Override
    public void run() {
        graphics.drawRect(12,12,12,12);
    }

}
