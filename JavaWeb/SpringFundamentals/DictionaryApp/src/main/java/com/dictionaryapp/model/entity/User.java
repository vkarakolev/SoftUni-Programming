package com.dictionaryapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @OneToMany(mappedBy = "addedBy")
    private List<Word> addedWords;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Word> getAddedWords() {
        return addedWords;
    }

    public User setAddedWords(List<Word> addedWords) {
        this.addedWords = addedWords;
        return this;
    }
}
