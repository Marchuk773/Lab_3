package ua.lviv.iot.tools.spring.first.rest.business;

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

}