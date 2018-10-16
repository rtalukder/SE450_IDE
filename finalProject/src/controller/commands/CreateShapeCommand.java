package controller.commands;

import controller.Point;
import view.*;
import view.gui.PaintCanvas;

public class CreateShapeCommand extends PaintCanvas implements ICommand {

//    private IShape shape = null;
    private Point point;


    @Override
    public void run() {


    }

    public CreateShapeCommand(Point point){
        paint();
    }


}
