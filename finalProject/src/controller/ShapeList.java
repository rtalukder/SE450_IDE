package controller;

import controller.interfaces.IShapeDrawObserver;
import controller.interfaces.ISubject;
import view.interfaces.IShape;
import java.util.List;
import java.util.ArrayList;

public class ShapeList implements ISubject {
    private static List<IShapeDrawObserver> observers = new ArrayList<>();
    public static List<IShape> shapeList = new ArrayList<>();

    public static void addToShapeList(IShape shape){
        shapeList.add(shape);
        notifyObserver();
    }

    public static void deleteFromShapeList(IShape shape){
        shapeList.remove(shape);
        notifyObserver();
    }

    @Override
    public void registerObserver(IShapeDrawObserver observer) {
        observers.add(observer);
    }

    public static void notifyObserver(){
        for (IShapeDrawObserver observer : observers){
            observer.update();
        }
    }
}
