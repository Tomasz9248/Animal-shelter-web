package com.tomek.data;

public class Animal implements Comparable<Dog> {

    private String name;
    private String race;
    private int age;
//    private LocalDate additionDate = LocalDate.now();



    public Animal() {
    }

    public Animal(String name, String race, int age) {
        this.name = name;
        this.race = race;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Dog o) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imię: " + name + ", ");
        sb.append("Rasa: " + race + ", ");
        sb.append("Wiek: " + age + ", ");
        return sb.toString();
    }
}
