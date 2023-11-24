import java.io.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

abstract class Figure3D {
    public abstract double calculateSurfaceArea();
    public abstract double calculateVolume();
}

class Cube extends Figure3D {
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * sideLength * sideLength;
    }

    @Override
    public double calculateVolume() {
        return sideLength * sideLength * sideLength;
    }
}

class Sphere extends Figure3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Cube> cubes = readCubesFromFile("Cube.class");


        System.out.println("Прочитані дані з файлів:");
        displayData(cubes);


        System.out.println("Дані після додавання та сортування:");
        displayData(cubes);


        ArrayList<Figure3D> allFigures = new ArrayList<>();
        allFigures.addAll(cubes);



        writeToOutputFile(allFigures, "AllFigures.txt");
    }

    public static ArrayList<Cube> readCubesFromFile(String filename) {
        ArrayList<Cube> cubes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                double sideLength = Double.parseDouble(line);
                Cube cube = new Cube(sideLength);
                cubes.add(cube);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cubes;
    }

    public static void displayData(ArrayList<? extends Figure3D> list) {
        for (Figure3D figure : list) {
            System.out.println(figure.toString());
        }
    }

    public static void addDataFromInput(ArrayList<? super Figure3D>... lists) {
        Scanner scanner = new Scanner(System.in);
        for (ArrayList<? super Figure3D> list : lists) {
            System.out.println("Введіть дані для додавання (наприклад, для куба - сторону):");
            double data = scanner.nextDouble();
        }
    }

    public static void writeToOutputFile(ArrayList<Figure3D> list, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Figure3D figure : list) {
                writer.write(figure.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}