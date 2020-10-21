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
            return (int) (firstTool.getPrice() - secondTool.getPrice());
        }

    }


    public static void sortByPrice(List<Tool> tools, SortType sortType) {
        PriceInDollarsComparator PRICE_IN_DOLLARS_COMPARATOR = new PriceInDollarsComparator();
        tools.sort(sortType == SortType.ASCENDING ? PRICE_IN_DOLLARS_COMPARATOR
                : PRICE_IN_DOLLARS_COMPARATOR.reversed());
    }

    
}
