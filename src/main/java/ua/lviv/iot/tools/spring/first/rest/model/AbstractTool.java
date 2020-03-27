package ua.lviv.iot.tools.spring.first.rest.model;

public class AbstractTool {
    protected double priceInDollars;
    protected double weightInKilos;
    protected String color;
    protected String name;
    protected boolean stainless;
    protected Integer id;

    public AbstractTool(double priceInDollars, double weightInKilos, String color,
            boolean stainless, String name) {
        this.priceInDollars = priceInDollars;
        this.weightInKilos = weightInKilos;
        this.color = color;
        this.stainless = stainless;
        this.name = name;
    }

    public AbstractTool(double priceInDollars, double weightInKilos) {
        this(priceInDollars, weightInKilos, null, true, null);
    }

    public AbstractTool() {
        this(0, 0, null, true, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPriceInDollars() {
        return priceInDollars;
    }

    public boolean isStainless() {
        return stainless;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getWeightInKilos() {
        return weightInKilos;
    }

    public String getHeaders() {
        return "priceInDollars, weightInKilos, color, name, stainless";
    }

    public String toCSV() {
        return "price = " + getPriceInDollars() + " weight = " + getWeightInKilos() + " color = "
                + getColor() + " name = " + getName() + " stainless = " + isStainless();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(priceInDollars);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (stainless ? 1231 : 1237);
        temp = Double.doubleToLongBits(weightInKilos);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractTool other = (AbstractTool) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(priceInDollars) != Double
                .doubleToLongBits(other.priceInDollars))
            return false;
        if (stainless != other.stainless)
            return false;
        if (Double.doubleToLongBits(weightInKilos) != Double.doubleToLongBits(other.weightInKilos))
            return false;
        return true;
    }

}