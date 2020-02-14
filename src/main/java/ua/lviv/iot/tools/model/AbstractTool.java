package ua.lviv.iot.tools.model;

public abstract class AbstractTool {
	protected double priceInDollars;
	protected double weightInKilos;
	protected String color;
	protected boolean stainless;

	public AbstractTool(double priceInDollars, double weightInKilos, String color, boolean stainless) {
		this.priceInDollars = priceInDollars;
		this.weightInKilos = weightInKilos;
		this.color = color;
		this.stainless = stainless;
	}

	public double getPriceInDollars() {
		return priceInDollars;
	}

	public String getColor() {
		return color;
	}

	public double getWeightInKilos() {
		return weightInKilos;
	}

}