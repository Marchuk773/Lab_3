package ua.lviv.iot.tools.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.tools.spring.first.rest.model.AbstractTool;

public class ToolsManagerTest extends BaseToolsManagerTest {
    private ToolsManager toolsManager;

    @BeforeEach
    public void setUp() {
        toolsManager = new ToolsManager();
        toolsManager.addTools(toolsList);
    }

    @Test
    public void testFindByPrice() {
        List<AbstractTool> tools = toolsManager.findByPrice(30, 35);
        assertEquals(2, tools.size());
        assertEquals(30, tools.get(0).getPriceInDollars());
        assertEquals(34, tools.get(1).getPriceInDollars());
    }

}