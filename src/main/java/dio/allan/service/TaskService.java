package dio.allan.service;

import dio.allan.model.Tarefa;


public interface TaskService {
    Tarefa findById(Long id);
    Tarefa create(Tarefa tarefa);
}
