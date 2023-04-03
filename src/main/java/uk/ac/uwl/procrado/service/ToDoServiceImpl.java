package uk.ac.uwl.procrado.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.ac.uwl.procrado.model.ToDo;
import uk.ac.uwl.procrado.repository.ToDoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {
    private static final Logger logger = LoggerFactory.getLogger(ToDoServiceImpl.class);
    ToDoRepository toDoRepository;

    // Dependency injection via Constructor
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> findAll() {
        return null;
    }

    @Override
    public List<ToDo> findAllByUserId(Long userId) {
        return null;
    }

    @Override
    public ToDo findById(Long id) {
//        if (id == null) return Exception(f);
        Optional<ToDo> todo = toDoRepository.findById(id);
        try {
            if (todo.isPresent())
                return todo.get();
        } catch (Exception e) {
            logger.info("Error finding Todo with id: {}", id);
        }
        return null;
    }

    @Override
    public ToDo save(ToDo toDo) {
        return null;
    }

    @Override
    public ToDo update(ToDo toDo) {
        return null;
    }

    @Override
    public void delete(ToDo toDo) {

    }
}
