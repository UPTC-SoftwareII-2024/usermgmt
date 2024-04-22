package edu.uptc.swii.usermgmt.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appusers")
public class User {

    @Id
    private String Id;
    private String userId;
    private String firstName;
    private String lastName;
    private Integer age;

    public User() {
    }

    public User(String id, String userId, String firstName, String lastName, Integer age) {
        Id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", age=" + age + "]";
    }

}
