package fr.ubordeaux.ao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SVG {
    private ArrayList<Shape> shapes;
    private int width;
    private int height;

    public SVG(int width, int height) {
        this.width = width;
        this.height = height;
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void toFile(String filepath) throws IOException {
        if (!filepath.contains(".svg")) {
            filepath += ".svg";
        }
        System.out.println("Saving " + shapes.size() + " SVG shapes to " + filepath);
        StringBuilder fileContent = new StringBuilder();
        String svgHeader = "<svg height=\"" + height + "\" width=\"" + width + "\">\n";
        fileContent.append(svgHeader);
        shapes.forEach(shape -> fileContent.append(shape.toSVG()).append("\n"));
        fileContent.append("</svg>");

        File svgFile = new File(filepath);
        FileWriter fileWriter = new FileWriter(svgFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(fileContent.toString());
        bufferedWriter.close();

        System.out.println("File written successfully");
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(50,0,10,10);
        Shape line = new Line(0,60,50,60);
        Shape circle = new Circle(50,200,30);
        Shape ellipse = new Ellipse(50,300,50,20);

        SVG svg = new SVG(500,500);
        svg.addShape(rectangle);
        svg.addShape(line);
        svg.addShape(circle);
        svg.addShape(ellipse);

        try {
            svg.toFile("test");
        } catch (IOException e) {
            System.err.println("File error");
            e.printStackTrace();
        }
    }
}