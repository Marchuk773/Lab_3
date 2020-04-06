package ua.lviv.iot.tools.spring.first.rest.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.tools.spring.first.rest.business.ToolsService;
import ua.lviv.iot.tools.spring.first.rest.model.Tool;

@RequestMapping("/tools")
@RestController
public class ToolsController {
    private AtomicInteger idCounter = new AtomicInteger();
    @Autowired
    private ToolsService toolsService;

    @GetMapping
    public List<Tool> getTools() {
        return new LinkedList<Tool>(toolsService.findAllTools());
    }

    @GetMapping(path = "/{id}")
    public Tool getTool(final @PathVariable("id") Integer toolId) {
        return toolsService.findTool(toolId);
    }

    @PostMapping
    public Tool createTool(final @RequestBody Tool tool) {
        tool.setId(idCounter.incrementAndGet());
        toolsService.createTool(tool);
        return tool;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tool> updateTool(final @PathVariable("id") Integer toolId,
            final @RequestBody Tool tool) {
        Tool oldTool = getTool(toolId);
        if (oldTool != null) {
            Tool returnedTool = new Tool(oldTool.getPriceInDollars(), oldTool.getWeightInKilos(),
                    oldTool.getColor(), oldTool.isStainless(), oldTool.getName());
            returnedTool.setId(toolId);
            toolsService.updateTool(toolId, tool);
            return ResponseEntity.ok(returnedTool);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTool(final @PathVariable("id") Integer toolId) {
        if (getTool(toolId) != null) {
            toolsService.deleteTool(toolId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}