package uk.ac.uwl.procrado.model;

//import org.apache.catalina.User;
import jakarta.persistence.*;
import uk.ac.uwl.procrado.model.BaseEntity;
import uk.ac.uwl.procrado.model.User;

import javax.annotation.processing.Generated;
import java.util.Date;

@Entity
@Table(name = "todos")
public class ToDo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private String description;
    private Date dateCreated;
    private Date dueDate;
    private boolean taskCompleted;
    private boolean taskCancelled;
    private boolean isFavourite;
//    private List<String> steps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean istaskCompleted() {
        return taskCompleted;
    }

    public void settaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public boolean istaskCancelled() {
        return taskCancelled;
    }

    public void settaskCancelled(boolean taskCancelled) {
        this.taskCancelled = taskCancelled;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setisFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public ToDo() {

    }

    public Long getId() {
        return id;
    }

    public ToDo(Long id) {
        this.id = id;
    }

    public String gettask() {
        return task;
    }

    public void settask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ToDo(String task, String description, User user) {
        this.task = task;
        this.description = description;
        this.user = user;
    }
}



