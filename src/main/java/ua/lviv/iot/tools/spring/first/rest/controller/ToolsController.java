package ua.lviv.iot.tools.spring.first.rest.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.tools.spring.first.rest.business.ToolsService;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

@CrossOrigin
@RequestMapping("/tools")
@RestController
public class ToolsController {

    private AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private ToolsService toolsService;

    @GetMapping
    public List<Tool> getTools() {
        return new LinkedList<Tool>(toolsService.findAllObjects());
    }

    @GetMapping(path = "/filters")
    public List<Tool> getFilteredTools(final @RequestParam("type") String type,
            final @RequestParam("manufacturer") String manufacturer) {
        return new LinkedList<Tool>(toolsService.findFilteredTools(type, manufacturer));
    }

    @GetMapping(path = "/{id}")
    public Tool getTool(final @PathVariable("id") Integer toolId) {
        return toolsService.findObject(toolId);
    }

    @PostMapping
    public Tool createTool(final @RequestBody Tool tool) {
        tool.setId(idCounter.incrementAndGet());
        return toolsService.createObject(tool);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tool> updateTool(final @PathVariable("id") Integer toolId,
            final @RequestBody Tool tool) {
        Tool oldTool = getTool(toolId);
        if (oldTool != null) {
            Tool returnedTool = new Tool(oldTool.getHeader(), oldTool.getDescription(),
                    oldTool.getPrice(), oldTool.getType(), oldTool.getImg(),
                    oldTool.getManufacturer(), oldTool.getId());
            returnedTool.setId(toolId);
            tool.setId(toolId);
            toolsService.updateObject(toolId, tool);
            return ResponseEntity.ok(returnedTool);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTool(final @PathVariable("id") Integer toolId) {
        if (getTool(toolId) != null) {
            toolsService.deleteObject(toolId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}