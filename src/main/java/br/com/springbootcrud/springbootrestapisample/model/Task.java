package br.com.springbootcrud.springbootrestapisample.model;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@SequenceGenerator(name = "seq_task", sequenceName = "seq_task", allocationSize = 1, initialValue = 1)
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_task")
    private Long id;

    private boolean isTaskComplete;

    private String taskName;

    @CreationTimestamp
    @Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTaskComplete() {
        return isTaskComplete;
    }

    public void setTaskComplete(boolean taskComplete) {
        isTaskComplete = taskComplete;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", isTaskComplete=" + isTaskComplete +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
