package ua.lviv.iot.tools.model;

public class Saw extends AbstractTool {
	private double lengthInCentimetres;

	public Saw(double priceInDollars, double weightInKilos, String color, boolean stainless, double lengthInCentimetres,
			String name) {
		super(priceInDollars, weightInKilos, color, stainless, name);
		this.lengthInCentimetres = lengthInCentimetres;
	}

	public String toString() {
		return "Saw (lengthInCentimetres = " + lengthInCentimetres + "; priceInDollars = " + priceInDollars
				+ "; weightInKilos = " + weightInKilos + "; color = " + color + "; stainless = " + stainless + ")";
	}

}