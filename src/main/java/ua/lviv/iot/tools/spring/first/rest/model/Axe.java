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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((handleMaterial == null) ? 0 : handleMaterial.hashCode());
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
        Axe other = (Axe) obj;
        if (handleMaterial == null) {
            if (other.handleMaterial != null)
                return false;
        } else if (!handleMaterial.equals(other.handleMaterial))
            return false;
        return true;
    }

    public String toString() {
        return "Axe (handleMaterial = " + handleMaterial + "; priceInDollars = " + priceInDollars
                + "; weightInKilos = " + weightInKilos + "; color = " + color + "; stainless = "
                + stainless + ")";
    }

}