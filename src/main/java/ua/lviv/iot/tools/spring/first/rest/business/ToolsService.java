package ua.lviv.iot.tools.spring.first.rest.business;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.tools.spring.first.rest.dataaccess.ToolsRepository;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

@Service
public class ToolsService extends AbstractService<Tool> {

    @Autowired
    private ToolsRepository toolsRepository;

    @Override
    protected JpaRepository<Tool, Integer> getRepository() {
        return toolsRepository;
    }

    public List<Tool> findFilteredTools(String type, String manufacturer) {
        List<Tool> tools = toolsRepository.findAll();
        List<Tool> filteredTools = new LinkedList<>();
        if (type.equals("None") && manufacturer.equals("None")) {
            return tools;
        }
        for (Tool tool : tools) {
            if ((tool.getType().equals(type) || type.equals("None"))
                    && (tool.getManufacturer().equals(manufacturer)
                            || manufacturer.equals("None"))) {
                filteredTools.add(tool);
            }
        }
        return filteredTools;
    }

}