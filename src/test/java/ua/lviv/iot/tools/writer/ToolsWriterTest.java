package ua.lviv.iot.tools.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.tools.manager.BaseToolsManagerTest;
import ua.lviv.iot.tools.spring.first.rest.model.AbstractTool;

public class ToolsWriterTest extends BaseToolsManagerTest {

    @Test
    public void testFile() throws IOException {
        try (Writer fileWriter = new FileWriter("Tools.csv")) {
            ToolsWriter writer = new ToolsWriter();
            writer.setTextWriter(fileWriter);
            writer.writeToFile(toolsList);
        }
    }

    @Test
    public void testWriteToFile() throws IOException {
        try (Writer csvWriter = new StringWriter()) {
            ToolsWriter writer = new ToolsWriter();
            writer.setTextWriter(csvWriter);
            writer.writeToFile(toolsList);
            String expectedString = "";
            for (AbstractTool tool : toolsList) {
                expectedString += tool.getHeaders() + ", " + tool.toCSV() + "\r\n";
            }
            assertEquals(expectedString, writer.toString());
        }
    }

}