package uk.ac.uwl.procrado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.ac.uwl.procrado.model.ToDo;
import uk.ac.uwl.procrado.repository.ToDoRepository;
import uk.ac.uwl.procrado.service.ToDoService;

@Component
public class BootStrap implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);
    ToDoRepository toDoRepository;
    ToDoService toDoService;

    public BootStrap(ToDoRepository toDoRepository, ToDoService toDoService) {
        this.toDoRepository = toDoRepository;
        this.toDoService = toDoService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("------Bootstrap loaded------");
        logger.info("----------------------------");

        logger.info(String.valueOf(toDoRepository.count()));
    }
}
