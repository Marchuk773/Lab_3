package ua.lviv.iot.tools.model;

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

}