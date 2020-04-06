package ua.lviv.iot.tools.spring.first.rest.model;

import ua.lviv.iot.tools.spring.first.rest.model.Tool;

public class Axe extends Tool {
    private String handleMaterial;

    public Axe(double priceInDollars, double weightInKilos, String color, boolean stainless,
            String handleMaterial, String name) {
        super(priceInDollars, weightInKilos, color, stainless, name);
        this.handleMaterial = handleMaterial;
    }

    public String getHandleMaterial() {
        return handleMaterial;
    }

    public String getHeaders() {
        return super.getHeaders() + ", handleMaterial";
    }

    public String toCSV() {
        return super.toCSV() + " handleMaterial = " + getHandleMaterial();
    }

    public String toString() {
        return "Axe (handleMaterial = " + handleMaterial + "; priceInDollars = " + priceInDollars
                + "; weightInKilos = " + weightInKilos + "; color = " + color + "; stainless = "
                + stainless + ")";
    }

}