package com.dictionaryapp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 40)
    private String term;

    @NotNull
    @Size(min = 2, max = 20)
    private String translation;

    @Size(min = 2, max = 200)
    private String example;
    @NotNull
    private LocalDate inputDate;
    @NotNull
    @ManyToOne
    private Language language;
    @NotNull
    @ManyToOne
    private User addedBy;

    public String getTerm() {
        return term;
    }

    public Word setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public Word setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public Word setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public Word setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Word setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public Word setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }
}
