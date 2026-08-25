package cl.duocuc.actividad.service;

import cl.duocuc.actividad.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TaskService() {
        tasks.add(new Task(idGenerator.getAndIncrement(), "Configurar Git y GitHub", true));
        tasks.add(new Task(idGenerator.getAndIncrement(), "Practicar Trunk-Based Development", false));
    }

    public List<Task> listar() {
        return tasks;
    }

    public Task crear(Task nueva) {
        nueva.setId(idGenerator.getAndIncrement());
        tasks.add(nueva);
        return nueva;
    }

    public Task buscarPorId(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
}