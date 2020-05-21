package ua.lviv.iot.tools.spring.first.rest.model;

import ua.lviv.iot.tools.spring.first.rest.model.Tool;

public class Saw extends Tool {

    private double lengthInCentimetres;

    public Saw(double priceInDollars, double weightInKilos, String color, boolean stainless,
            double lengthInCentimetres, String name) {
        super(priceInDollars, weightInKilos, color, stainless, name);
        this.lengthInCentimetres = lengthInCentimetres;
    }

    public double getLengthInCentimetres() {
        return lengthInCentimetres;
    }

    public String getHeaders() {
        return super.getHeaders() + ", lengthInCentimetres";
    }

    public String toCSV() {
        return super.toCSV() + " lengthInCentimetres = " + getLengthInCentimetres();
    }

}