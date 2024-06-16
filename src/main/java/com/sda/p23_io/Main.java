package com.sda.p23_io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // I want to read the content of input.txt
        // and print out to console
        File input = new File("/Users/hatefpalizgar/Desktop/java-remote-ee-33/src/main/java/com/sda/p23_io/input.txt");
        File output = new File("/Users/hatefpalizgar/Desktop/java-remote-ee-33/src/main/java/com/sda/p23_io/output.txt");

        // read from a file
        readFromFile(input);

        // write to a file
        writeToFile(output);


        // write an object to a file
        Car car = new Car("Ford", 5000);
         writeObjectToFile(car);

        // read an object from a file
        File file = new File("/Users/hatefpalizgar/Desktop/java-remote-ee-33/src/main/java/com/sda/p23_io/ford");
        readObjectFromFile(file); // Car{model='Ford', price=5000.0}

    }

    public static void readFromFile(File file) {
        // Solution 1
        /*
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader); // BufferedReader is a wrapper around fileReader
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("IOException is caught!");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("IOException is caught!");
            }
        }
        */


        // Solution 2
        // try-with-resources
        // takes care of closing all resources like reader automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // write() replaces/overwrites the whole file
            // writer.write("Happy birthday!!!!");
            writer.append("Hello World!\nThis is my first app\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeObjectToFile(Car car) {
        File file = new File("/Users/hatefpalizgar/Desktop/java-remote-ee-33/src/main/java/com/sda/p23_io/ford");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(car); // This will store car object in a file called "ford"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObjectFromFile(File file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Car receivedObject = (Car) objectInputStream.readObject(); // casting Object > Car
            System.out.println(receivedObject);
            System.out.println(receivedObject.getPrice()); // 5000.0
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
