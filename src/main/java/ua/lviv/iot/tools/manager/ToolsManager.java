package ua.lviv.iot.tools.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.tools.model.AbstractTool;

public class ToolsManager {
	private List<AbstractTool> gardenerToolsList = new LinkedList<>();

	public ToolsManager(List<AbstractTool> gardenerToolsList) {
		this.gardenerToolsList = gardenerToolsList;
	}

	public ToolsManager() {
	}

	public void addTool(AbstractTool addedObject) {
		this.gardenerToolsList.add(addedObject);
	}

	public void addTools(List<AbstractTool> addedObjects) {
		this.gardenerToolsList.addAll(addedObjects);
	}

	public List<AbstractTool> findByPrice(double searchedPrice) {
		List<AbstractTool> foundTools = new LinkedList<>();
		for (AbstractTool gardenerTool : gardenerToolsList) {
			if (gardenerTool.getPriceInDollars() == searchedPrice) {
				foundTools.add(gardenerTool);
			}
		}
		return foundTools;
	}

	public List<AbstractTool> findByPrice(double lowerPrice, double higherPrice) {
		List<AbstractTool> foundTools = new LinkedList<>();
		for (AbstractTool gardenerTool : gardenerToolsList) {
			if ((gardenerTool.getPriceInDollars() >= lowerPrice) && (gardenerTool.getPriceInDollars() <= higherPrice)) {
				foundTools.add(gardenerTool);
			}
		}
		return foundTools;
	}

	public void printItems(List<AbstractTool> items) {
		for (AbstractTool itemsIterator : items) {
			System.out.println(itemsIterator);
		}
	}

}