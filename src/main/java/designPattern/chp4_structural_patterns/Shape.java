package designPattern.chp4_structural_patterns;

public abstract class Shape {

    abstract void boundingBox(Point bottomLeft, Point topRight);
    abstract Manipulator createManipulator();
}
