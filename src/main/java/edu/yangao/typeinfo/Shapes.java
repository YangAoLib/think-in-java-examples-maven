package edu.yangao.typeinfo;
//: typeinfo/Shapes.java

import java.util.*;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    protected boolean flag = false;

    void rotate() {
        // 只有非圆形进行旋转
        if (!(this instanceof Circle)) {
            System.out.println(this + ".rotate()");
        }
    }

    public Shape(boolean flag) {
        this.flag = flag;
    }

    public Shape() {
    }

    abstract public String toString();
}

class Circle extends Shape {

    public Circle() {
        super(true);
    }

    public String toString() {
        return "flag→" + flag + " Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "flag→" + flag + " Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "flag→" + flag + " Triangle";
    }
}

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "flag→" + flag + " Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        for (Shape shape : shapeList) {
            shape.draw();
            shape.rotate();
        }

        Shape shape = shapeList.get(3);
        if (shape instanceof Circle circle) {
            circle.draw();
        }
        System.out.println(shape instanceof Circle);
    }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
