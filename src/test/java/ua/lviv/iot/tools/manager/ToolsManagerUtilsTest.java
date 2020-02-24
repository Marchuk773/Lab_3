package ua.lviv.iot.tools.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToolsManagerUtilsTest extends BaseToolsManagerTest {

	@Test
	public void testSortingByNameAsc() {
		ToolsManagerUtils.sortByName(toolsList, SortType.ASCENDING);
		assertEquals("best axe", toolsList.get(0).getName());
		assertEquals("best saw", toolsList.get(1).getName());
		assertEquals("best scissors", toolsList.get(2).getName());
	}

	@Test
	public void testSortingByPriceDes() {
		ToolsManagerUtils.sortByPrice(toolsList, SortType.DESCENDING);
		assertEquals(34, toolsList.get(0).getPriceInDollars());
		assertEquals(30, toolsList.get(1).getPriceInDollars());
		assertEquals(20, toolsList.get(2).getPriceInDollars());
	}

	@Test
	public void testSortingByWeightDes() {
		ToolsManagerUtils.sortByWeightInKilos(toolsList, SortType.DESCENDING);
		assertEquals(3, toolsList.get(0).getWeightInKilos());
		assertEquals(2, toolsList.get(1).getWeightInKilos());
		assertEquals(1.5, toolsList.get(2).getWeightInKilos());
	}

	@Test
	public void testSortingByColorDes() {
		ToolsManagerUtils.sortByColor(toolsList, SortType.DESCENDING);
		assertEquals("Green", toolsList.get(0).getColor());
		assertEquals("Brown", toolsList.get(1).getColor());
		assertEquals("Blue", toolsList.get(2).getColor());
	}

}