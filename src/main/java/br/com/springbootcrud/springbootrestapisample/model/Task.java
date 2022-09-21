package br.com.springbootcrud.springbootrestapisample.model;


import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
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

 
}
