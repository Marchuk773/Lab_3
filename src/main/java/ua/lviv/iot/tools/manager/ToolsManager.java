package ua.lviv.iot.tools.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

public class ToolsManager {

    private List<Tool> gardenerToolsList = new LinkedList<>();

    public ToolsManager(List<Tool> gardenerToolsList) {
        this.gardenerToolsList = gardenerToolsList;
    }

    public ToolsManager() {
    }

    public void addTool(Tool addedObject) {
        this.gardenerToolsList.add(addedObject);
    }

    public void addTools(List<Tool> addedObjects) {
        this.gardenerToolsList.addAll(addedObjects);
    }

    public List<Tool> findByPrice(double searchedPrice) {
        List<Tool> foundTools = new LinkedList<>();
        for (Tool gardenerTool : gardenerToolsList) {
            if (gardenerTool.getPrice() == searchedPrice) {
                foundTools.add(gardenerTool);
            }
        }
        return foundTools;
    }

    public List<Tool> findByPrice(double lowerPrice, double higherPrice) {
        List<Tool> foundTools = new LinkedList<>();
        for (Tool gardenerTool : gardenerToolsList) {
            if ((gardenerTool.getPrice() >= lowerPrice)
                    && (gardenerTool.getPrice() <= higherPrice)) {
                foundTools.add(gardenerTool);
            }
        }
        return foundTools;
    }

    public void printItems(List<Tool> items) {
        for (Tool itemsIterator : items) {
            System.out.println(itemsIterator);
        }
    }

}