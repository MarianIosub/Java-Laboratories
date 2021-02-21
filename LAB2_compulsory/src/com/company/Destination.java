package com.company;



public class Destination {
    private int comodities;

    private String name;
    Destination(){
        comodities=0;
        name=null;
    }

    public void setComodities(int comodities) {
        this.comodities = comodities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComodities() {
        return comodities;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "Your destination having name: "+name+" and capacity: "+comodities;
    }

}
