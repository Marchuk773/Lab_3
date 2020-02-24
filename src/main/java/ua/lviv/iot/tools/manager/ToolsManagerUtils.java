package ua.lviv.iot.tools.manager;

import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.tools.manager.SortType;
import ua.lviv.iot.tools.model.AbstractTool;

public class ToolsManagerUtils {

	private static final PriceInDollarsComparator PRICE_IN_DOLLARS_COMPARATOR = new PriceInDollarsComparator();

	private static class PriceInDollarsComparator implements Comparator<AbstractTool> {

		@Override
		public int compare(AbstractTool firstTool, AbstractTool secondTool) {
			return (int) (firstTool.getPriceInDollars() - secondTool.getPriceInDollars());
		}

	}

	private class NameComparator implements Comparator<AbstractTool> {

		@Override
		public int compare(AbstractTool firstTool, AbstractTool secondTool) {
			return firstTool.getName().compareTo(secondTool.getName());
		}

	}

	public static void sortByPrice(List<AbstractTool> tools, SortType sortType) {
		tools.sort(sortType == SortType.ASCENDING ? PRICE_IN_DOLLARS_COMPARATOR
				: PRICE_IN_DOLLARS_COMPARATOR.reversed());
	}

	public static void sortByName(List<AbstractTool> tools, SortType sortType) {
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

	public static void sortByColor(List<AbstractTool> tools, SortType sortType) {
		Comparator<AbstractTool> colorComparator = new Comparator<AbstractTool>() {

			@Override
			public int compare(AbstractTool firstTool, AbstractTool secondTool) {
				return (int) (firstTool.getColor().compareTo(secondTool.getColor()));
			}

		};

		tools.sort(sortType == SortType.ASCENDING ? colorComparator : colorComparator.reversed());
	}

	public static void sortByWeightInKilos(List<AbstractTool> tools, SortType sortType) {
		switch (sortType) {
		case ASCENDING:
			tools.sort((AbstractTool firstTool,
					AbstractTool secondTool) -> (int) (firstTool.getWeightInKilos()
							- secondTool.getWeightInKilos()));
			break;
		case DESCENDING:
			tools.sort((AbstractTool firstTool,
					AbstractTool secondTool) -> (int) (secondTool.getWeightInKilos()
							- firstTool.getWeightInKilos()));
			break;
		default:
			break;
		}
	}
}
