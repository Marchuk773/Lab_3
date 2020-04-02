package ua.lviv.iot.tools.spring.first.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

@Repository
public interface ToolsRepository extends JpaRepository<Tool, Integer> {

}