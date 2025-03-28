package dio.allan.service.impl;

import dio.allan.model.Tarefa;
import dio.allan.repository.TasksRepository;
import dio.allan.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TasksRepository tasksRepository;

    public TaskServiceImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public Tarefa findById(Long id) {
        return tasksRepository.findById(id).get();
    }

    @Override
    public Tarefa create(Tarefa tarefa) {
        if (tarefa.getId() != null && tasksRepository.existsById(tarefa.getId())) {
            throw new IllegalArgumentException("Essa Tarefa ja existe");
        }
        return tasksRepository.save(tarefa);
    }
}
