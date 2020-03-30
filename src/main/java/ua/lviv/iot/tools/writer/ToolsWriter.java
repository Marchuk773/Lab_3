package ua.lviv.iot.tools.writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.tools.spring.first.rest.model.AbstractTool;

public class ToolsWriter {
    private Writer textWriter;

    public void setTextWriter(Writer textWriter) {
        this.textWriter = textWriter;
    }

    public void writeToFile(List<AbstractTool> tools) throws IOException {
        String textToWrite;
        for (AbstractTool tool : tools) {
            textToWrite = tool.getHeaders() + ", " + tool.toCSV() + "\r\n";
            textWriter.write(textToWrite);
        }
        textWriter.flush();
    }

    public static void readFromFile(String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string;
            while ((string = reader.readLine()) != null) {
                System.out.println(string);
            }
        }
    }

    public String toString() {
        return textWriter.toString();
    }

}