package uk.ac.uwl.procrado.model;

//import org.apache.catalina.User;
import jakarta.persistence.*;

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


    public boolean istaskCompleted() {
        return taskCompleted;
    }
    public boolean istaskCancelled() {
        return taskCancelled;
    }
    public boolean isFavourite() {
        return isFavourite;
    }
//    public boolean isTaskCompleted() {
//        return taskCompleted;
//    }
//    public boolean isTaskCancelled() {
//        return taskCancelled;
//    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
//    public void settaskCancelled(boolean taskCancelled) {
//        this.taskCancelled = taskCancelled;
//    }
    public void setisFavourite(boolean favourite) {
        isFavourite = favourite;
    }
//    public void setTaskCompleted(boolean taskCompleted) {
//        this.taskCompleted = taskCompleted;
//    }
    public void setTaskCancelled(boolean taskCancelled) {
        this.taskCancelled = taskCancelled;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void settask(String task) {
        this.task = task;
    }


    public boolean getTaskCompleted() { return taskCompleted; }
    public boolean getTaskCancelled() { return taskCancelled; }

    public Date getDateCreated() {
        return dateCreated;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public String gettask() {
        return task;
    }
    public String getDescription() {
        return description;
    }
    public User getUser() {
        return user;
    }
    public Long getId() {
        return id;
    }
    public ToDo() {

    }

    public ToDo(Long id) {
        this.id = id;
    }

    public ToDo(String task, String description, User user) {
        this.task = task;
        this.description = description;
        this.user = user;
    }
}



