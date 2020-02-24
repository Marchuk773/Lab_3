package ua.lviv.iot.tools.model;

public abstract class AbstractTool {
	protected double priceInDollars;
	protected double weightInKilos;
	protected String color;
	protected String name;
	protected boolean stainless;

	public AbstractTool(double priceInDollars, double weightInKilos, String color, boolean stainless, String name) {
		this.priceInDollars = priceInDollars;
		this.weightInKilos = weightInKilos;
		this.color = color;
		this.stainless = stainless;
		this.name = name;
	}

	public double getPriceInDollars() {
		return priceInDollars;
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

}