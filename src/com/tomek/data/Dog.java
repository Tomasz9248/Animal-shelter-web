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

    //    public LocalDate getAdditionDate() {
//        return additionDate;
//    }
//
//    public void setAdditionDate(LocalDate additionDate) {
//        this.additionDate = additionDate;
//    }

    @Override
    public int compareTo(Dog o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Aportuje: " + isFetching + ", ");
        sb.append("Rodowód: " + isPurebred);
//        sb.append("Data dodania: " + additionDate);
        return sb.toString();
    }
}