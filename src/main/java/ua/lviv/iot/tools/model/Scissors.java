package ua.lviv.iot.tools.model;

public class Scissors extends AbstractTool {
	private String typeOfScissors;

	public Scissors(double priceInDollars, double weightInKilos, String color, boolean stainless,
			String typeOfScissors) {
		super(priceInDollars, weightInKilos, color, stainless);
		this.typeOfScissors = typeOfScissors;
	}

	public String toString() {
		return "Scissors (typeOfScissors = " + typeOfScissors + "; priceInDollars = " + priceInDollars
				+ "; weightInKilos = " + weightInKilos + "; color = " + color + "; stainless = " + stainless + ")";
	}

}