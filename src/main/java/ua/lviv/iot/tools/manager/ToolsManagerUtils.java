package ua.lviv.iot.tools.manager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.tools.manager.SortType;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

public class ToolsManagerUtils {

    private static class PriceInDollarsComparator implements Comparator<Tool>, Serializable {

        private static final long serialVersionUID = 1L;

        @Override
        public int compare(Tool firstTool, Tool secondTool) {
            return (int) (firstTool.getPriceInDollars() - secondTool.getPriceInDollars());
        }

    }

    private class NameComparator implements Comparator<Tool> {

        @Override
        public int compare(Tool firstTool, Tool secondTool) {
            return firstTool.getName().compareTo(secondTool.getName());
        }

    }

    public static void sortByPrice(List<Tool> tools, SortType sortType) {
        PriceInDollarsComparator PRICE_IN_DOLLARS_COMPARATOR = new PriceInDollarsComparator();
        tools.sort(sortType == SortType.ASCENDING ? PRICE_IN_DOLLARS_COMPARATOR
                : PRICE_IN_DOLLARS_COMPARATOR.reversed());
    }

    public static void sortByName(List<Tool> tools, SortType sortType) {
        switch (sortType) {
        case ASCENDING:
            tools.sort(new ToolsManagerUtils().new NameComparator());
            break;
        case DESCENDING:
            tools.sort(new ToolsManagerUtils().new NameComparator().reversed());
            break;
        default:
            break;
        }

    }

    public static void sortByColor(List<Tool> tools, SortType sortType) {
        Comparator<Tool> colorComparator = new Comparator<Tool>() {

            @Override
            public int compare(Tool firstTool, Tool secondTool) {
                return (int) (firstTool.getColor().compareTo(secondTool.getColor()));
            }

        };

        tools.sort(sortType == SortType.ASCENDING ? colorComparator : colorComparator.reversed());
    }

    public static void sortByWeightInKilos(List<Tool> tools, SortType sortType) {
        switch (sortType) {
        case ASCENDING:
            tools.sort((Tool firstTool, Tool secondTool) -> (int) (firstTool.getWeightInKilos()
                    - secondTool.getWeightInKilos()));
            break;
        case DESCENDING:
            tools.sort((Tool firstTool, Tool secondTool) -> Double
                    .compare(secondTool.getWeightInKilos(), firstTool.getWeightInKilos()));
            break;
        default:
            break;
        }
    }
}
