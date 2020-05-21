package ua.lviv.iot.tools.spring.first.rest.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Tool {

    protected double priceInDollars;

    protected double weightInKilos;

    protected String color;

    protected String name;

    protected boolean stainless;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    @JsonIgnoreProperties("tools")
    protected Manufacturer manufacturer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "gardener_shops", joinColumns = {
            @JoinColumn(name = "tool_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "shop_id", nullable = false) })
    @JsonIgnoreProperties("tools")
    protected Set<Shop> shops;

    public Tool(double priceInDollars, double weightInKilos, String color, boolean stainless,
            String name, Manufacturer manufacturer) {
        this.priceInDollars = priceInDollars;
        this.weightInKilos = weightInKilos;
        this.color = color;
        this.stainless = stainless;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public Tool(double priceInDollars, double weightInKilos, String color, boolean stainless,
            String name) {
        this(priceInDollars, weightInKilos, color, stainless, name, null);
    }

    public Tool(double priceInDollars, double weightInKilos) {
        this(priceInDollars, weightInKilos, null, true, null);
    }

    public Tool() {
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    @JsonIgnore
    public String getHeaders() {
        return "priceInDollars, weightInKilos, color, name, stainless";
    }

    public String toCSV() {
        return "price = " + getPriceInDollars() + " weight = " + getWeightInKilos() + " color = "
                + getColor() + " name = " + getName() + " stainless = " + isStainless();
    }

}