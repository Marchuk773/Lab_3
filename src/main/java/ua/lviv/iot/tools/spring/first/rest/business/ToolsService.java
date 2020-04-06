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

    public Tool findTool(Integer toolId) {
        return toolsRepository.findById(toolId).orElse(null);
    }

    public List<Tool> findAllTools() {
        return toolsRepository.findAll();
    }

    public void updateTool(Integer toolId, Tool tool) {
        tool.setId(toolId);
        toolsRepository.save(tool);
    }

}