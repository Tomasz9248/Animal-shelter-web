package com.tomek.data;

public class Animal {

    private String name;
    private String race;
    private int age;

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
    public  boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Animal animal = (Animal) obj;
        return (name.equals(animal.name) &&
                age == animal.age &&
                race.equals(animal.race));
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getRace().hashCode();
        return result;
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