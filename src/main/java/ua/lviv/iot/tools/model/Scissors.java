package ua.lviv.iot.tools.model;

import ua.lviv.iot.tools.spring.first.rest.model.AbstractTool;

public class Scissors extends AbstractTool {
    private String typeOfScissors;

    public Scissors(double priceInDollars, double weightInKilos, String color, boolean stainless,
            String typeOfScissors, String name) {
        super(priceInDollars, weightInKilos, color, stainless, name);
        this.typeOfScissors = typeOfScissors;
    }

    public String getTypeOfScissors() {
        return typeOfScissors;
    }

    public String getHeaders() {
        return super.getHeaders() + ", typeOfScissors";
    }

    public String toCSV() {
        return super.toCSV() + " typeOfScissors = " + getTypeOfScissors();
    }

    public String toString() {
        return "Scissors (typeOfScissors = " + typeOfScissors + "; priceInDollars = "
                + priceInDollars + "; weightInKilos = " + weightInKilos + "; color = " + color
                + "; stainless = " + stainless + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((typeOfScissors == null) ? 0 : typeOfScissors.hashCode());
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
        Scissors other = (Scissors) obj;
        if (typeOfScissors == null) {
            if (other.typeOfScissors != null)
                return false;
        } else if (!typeOfScissors.equals(other.typeOfScissors))
            return false;
        return true;
    }

}