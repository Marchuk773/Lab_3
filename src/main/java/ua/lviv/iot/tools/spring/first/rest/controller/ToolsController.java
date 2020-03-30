package ua.lviv.iot.tools.spring.first.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.tools.spring.first.rest.model.AbstractTool;

@RequestMapping("/tools")
@RestController
public class ToolsController {
    private Map<Integer, AbstractTool> tools = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<AbstractTool> getTools() {
        return new LinkedList<AbstractTool>(tools.values());
    }

    @GetMapping(path = "/{id}")
    public AbstractTool getTool(final @PathVariable("id") Integer toolId) {
        return tools.get(toolId);
    }

    @PostMapping
    public AbstractTool createTool(final @RequestBody AbstractTool tool) {
        tool.setId(idCounter.incrementAndGet());
        tools.put(tool.getId(), tool);
        return tool;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AbstractTool> updateTool(final @PathVariable("id") Integer toolId,
            final @RequestBody AbstractTool tool) {
        tool.setId(toolId);
        if (tools.containsKey(toolId)) {
            return ResponseEntity.ok(tools.put(toolId, tool));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AbstractTool> deleteTool(final @PathVariable("id") Integer toolId) {
        HttpStatus status = tools.remove(toolId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

}