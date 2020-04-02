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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(lengthInCentimetres);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Saw other = (Saw) obj;
        if (Double.doubleToLongBits(lengthInCentimetres) != Double
                .doubleToLongBits(other.lengthInCentimetres))
            return false;
        return true;
    }

    public String toString() {
        return "Saw (lengthInCentimetres = " + lengthInCentimetres + "; priceInDollars = "
                + priceInDollars + "; weightInKilos = " + weightInKilos + "; color = " + color
                + "; stainless = " + stainless + ")";
    }

}