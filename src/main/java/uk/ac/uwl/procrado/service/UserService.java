package uk.ac.uwl.procrado.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.uwl.procrado.model.ToDo;
import uk.ac.uwl.procrado.model.User;
import uk.ac.uwl.procrado.repository.UserRepository;

import java.util.List;

@Service
public abstract class UserService {

    @Autowired

    private UserRepository userRepository;

    public abstract Iterable<User> findAll();

    public List<User> findAllByUserId(Long userId) {
        return userRepository.findAllByUserId(userId);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setTodos(user.getTodos());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
        userRepository.delete(existingUser);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public abstract ToDo findById(Long id);

    public abstract ToDo save(User user);

    public abstract ToDo update(User user);

    public abstract void delete(User user);
}
