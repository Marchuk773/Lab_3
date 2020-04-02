package ua.lviv.iot.tools.spring.first.rest.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.tools.spring.first.rest.dataaccess.ToolsRepository;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

@Service
public class ToolsService {
    @Autowired
    private ToolsRepository toolsRepository;

    public Tool createTool(Tool tool) {
        return toolsRepository.save(tool);
    }

    public void deleteTool(Integer toolId) {
        toolsRepository.deleteById(toolId);
    }

    public boolean checkIfToolExists(Integer toolId) {
        return toolsRepository.existsById(toolId);
    }

    public Tool findTool(Integer toolId) {
        return toolsRepository.findById(toolId).get();
    }

    public List<Tool> findAllTools() {
        return toolsRepository.findAll();
    }

    public Tool updateTool(Integer toolId, Tool tool) {
        Tool oldTool = toolsRepository.findById(toolId).get();
        Tool returnedTool = new Tool(oldTool.getPriceInDollars(), oldTool.getWeightInKilos(),
                oldTool.getColor(), oldTool.isStainless(), oldTool.getName());
        returnedTool.setId(toolId);
        tool.setId(toolId);
        toolsRepository.save(tool);
        return returnedTool;
    }

}