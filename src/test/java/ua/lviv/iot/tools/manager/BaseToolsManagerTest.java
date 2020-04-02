package ua.lviv.iot.tools.manager;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;
import ua.lviv.iot.tools.spring.first.rest.model.Axe;
import ua.lviv.iot.tools.spring.first.rest.model.Saw;
import ua.lviv.iot.tools.spring.first.rest.model.Scissors;

public class BaseToolsManagerTest {
    protected List<Tool> toolsList;

    @BeforeEach
    public void createTools() {
        toolsList = new LinkedList<Tool>();
        toolsList.add(new Saw(30, 2, "Blue", true, 10, "best saw"));
        toolsList.add(new Axe(20, 3, "Brown", true, "Wood", "best axe"));
        toolsList.add(new Scissors(34, 1.5, "Green", true, "For leaves", "best scissors"));

    }
}