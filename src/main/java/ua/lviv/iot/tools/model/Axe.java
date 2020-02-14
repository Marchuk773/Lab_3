package ua.lviv.iot.tools.model;

public class Axe extends AbstractTool {
	private String handleMaterial;

	public Axe(double priceInDollars, double weightInKilos, String color, boolean stainless, String handleMaterial) {
		super(priceInDollars, weightInKilos, color, stainless);
		this.handleMaterial = handleMaterial;
	}

	public String toString() {
		return "Axe (handleMaterial = " + handleMaterial + "; priceInDollars = " + priceInDollars + "; weightInKilos = "
				+ weightInKilos + "; color = " + color + "; stainless = " + stainless + ")";
	}

}