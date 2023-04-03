package uk.ac.uwl.procrado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.uwl.procrado.model.ToDo;
import uk.ac.uwl.procrado.model.User;
import uk.ac.uwl.procrado.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl extends UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByUserId(Long userId) {
        return null;
    }

    @Override
    public ToDo findById(Long id) {
        return null;
    }

    @Override
    public ToDo save(User user) {
        return null;
    }

    @Override
    public ToDo update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
