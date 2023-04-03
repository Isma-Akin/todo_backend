package uk.ac.uwl.procrado.service;

import org.springframework.stereotype.Service;
import uk.ac.uwl.procrado.model.ToDo;

import java.util.List;

@Service
public interface ToDoService {
    List<ToDo> findAll();
    List<ToDo> findAllByUserId(Long userId);
    ToDo findById(Long id);
    ToDo save(ToDo toDo);
    ToDo update(ToDo toDo);
    void delete(ToDo toDo);
}
