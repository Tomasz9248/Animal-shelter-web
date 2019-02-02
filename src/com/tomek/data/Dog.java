package com.tomek.data;

public class Dog extends Animal {


    private String isFetching;
    private String isPurebred;
//    private LocalDate additionDate;

public Dog() {

}

    public Dog(String name, String race, int age, String isFetching, String isPurebred) {
        super(name, race, age);
        this.isFetching = isFetching;
        this.isPurebred = isPurebred;
//        additionDate = LocalDate.now();
    }

    public String getIsFetching() {
        return isFetching;
    }

    public void setIsFetching(String isFetching) {
        this.isFetching = isFetching;
    }

    public String getIsPurebred() {
        return isPurebred;
    }

    public void setIsPurebred(String isPurebred) {
        this.isPurebred = isPurebred;
    }

    @Override
    public  boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Dog dog = (Dog) obj;
        return (getName().equals(dog.getName()) &&
                getAge() == dog.getAge() &&
                getRace().equals(dog.getRace()) &&
                getIsFetching().equals(dog.getIsFetching()) &&
                getIsPurebred().equals(dog.getIsPurebred()));
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getIsFetching().hashCode();
        result = 31 * result + getIsPurebred().hashCode();
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Aportuje: " + isFetching + ", ");
        sb.append("Rodowód: " + isPurebred);
        return sb.toString();
    }
}