package com.todolist.todolist.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Persons")
public class Person {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
            (
  //                  mappedBy = "person",  //mappedBy should be used in the parent table in regards to foreign key (the referencing side, non-owning side of the relationship)
            cascade = CascadeType.ALL
                    //, fetch = FetchType.EAGER
            ) //FetchType.LAZY for collections? .LAZY and .EAGER seems to work in this case
    private Task task;

    private String name;

    public Person(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", task=" + task +
                ", name='" + name + '\'' +
                '}';
    }
}
