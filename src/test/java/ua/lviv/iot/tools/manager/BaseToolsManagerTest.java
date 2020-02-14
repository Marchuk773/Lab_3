package ua.lviv.iot.tools.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.tools.model.AbstractTool;
import ua.lviv.iot.tools.model.Axe;
import ua.lviv.iot.tools.model.Saw;
import ua.lviv.iot.tools.model.Scissors;

public class BaseToolsManagerTest {
	protected List<AbstractTool> toolsList;

	@BeforeEach
	public void createTools() {
		toolsList = new LinkedList<AbstractTool>();
		toolsList.add(new Saw(30, 2, "Blue", true, 10));
		toolsList.add(new Axe(20, 3, "Brown", true, "Wood"));
		toolsList.add(new Scissors(34, 1.5, "Green", true, "For leaves"));

	}
}