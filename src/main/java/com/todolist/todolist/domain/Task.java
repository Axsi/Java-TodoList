package com.todolist.todolist.domain;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "Tasks") //assigning table name with the name attribute
public class Task {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne
//            (fetch = FetchType.EAGER)
 //  @JoinColumn(name = "person_id", nullable = false, updatable = false) //the table with the foreign key is the side that has joinColumn
//  private Person person;

    private String description;

    public Task(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
