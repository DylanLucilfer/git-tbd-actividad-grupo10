package cl.duocuc.actividad.controller;

import cl.duocuc.actividad.model.Task;
import cl.duocuc.actividad.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> listar() {
        return taskService.listar();
    }

    @PostMapping
    public Task crear(@RequestBody Task task) {
        return taskService.crear(task);
    }

    // Buscar una tarea por ID
    @GetMapping("/{id}")
    public Task buscarPorId(@PathVariable Long id) {
        return taskService.buscarPorId(id);
    }
}


//Nicolas Estuvo aqui
