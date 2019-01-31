package com.tomek.data;

import java.io.*;
import java.util.*;


public class Shelter implements Serializable {

    private static final int SHELTER_CAPACITY = 10;
    private static int currentAnimalsNumber;
    private static int freeSpots;
    public static List<Dog> animalList;
    private static final long serialUID = 123456789111L;


    public Shelter() {
        currentAnimalsNumber = 0;
        animalList = new ArrayList<>();
        freeSpots = SHELTER_CAPACITY-currentAnimalsNumber;
    }

    protected void saveToFile(Object obj) {
        File shelterFile = new File("shelter.txt");

        try (
                FileOutputStream fos = new FileOutputStream(shelterFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {

            oos.writeObject(obj);

        } catch (IOException ioe) {
            System.out.println("Zapis nie powiódł się.");
            ioe.printStackTrace();
        }
    }

    protected void readFromFile() throws ClassNotFoundException, IOException{
        Shelter shelter = new Shelter();
        try (
                FileInputStream fis = new FileInputStream("shelter.txt");
                ObjectInputStream oos = new ObjectInputStream(fis);
        ) {
            shelter = (Shelter) oos.readObject();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void addAnimal(Dog animal) {
        if (animalList.size() < SHELTER_CAPACITY) {
            animalList.add( animal);
            currentAnimalsNumber++;
            if (SHELTER_CAPACITY - currentAnimalsNumber < 5) {

            }
        } else {
            System.out.println("We're sorry. The shelter is full and we unfortunately can't receive more animals.");
        }
    }

    protected void removeAnimal (String name) {
        animalList.removeIf(x -> x.getName().equals(name));
        System.out.println(name + "found new home!");
    }

    protected void showStatus() {
       animalList.stream()
               .forEach(System.out::println);
        printCapacityCommunicate();
    }

    private void printCapacityCommunicate() {
        if (currentAnimalsNumber >= SHELTER_CAPACITY) {
            System.out.println("The shelter is full. Cant receive more animals.");
        } if (currentAnimalsNumber / SHELTER_CAPACITY * 100 >= 75 ) {
            System.out.println("The shelter is almost full.");
        } else {
            System.out.println("The shelter has plenty free space.");
        }
    }

    private int getSHELTER_CAPACITY() {
        return SHELTER_CAPACITY;
    }

    private int getCurrentAnimalsNumber() {
        return currentAnimalsNumber;
    }

    private void setCurrentAnimalsNumber(int currentAnimalsNumber) {
        this.currentAnimalsNumber = currentAnimalsNumber;
    }

    List<Dog> getAnimalList() {
        return animalList;
    }

    private void setAnimalList(List<Dog> animalList) {
        this.animalList = animalList;
    }
}
