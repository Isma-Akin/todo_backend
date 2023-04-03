package uk.ac.uwl.procrado.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import uk.ac.uwl.procrado.model.ToDo;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo,Long> {
    List<ToDo> findAllByUserId(Long userId);
}
