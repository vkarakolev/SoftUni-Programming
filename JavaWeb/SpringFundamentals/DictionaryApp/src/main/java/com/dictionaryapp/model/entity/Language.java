package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {
        @Enumerated(EnumType.STRING)
        @Column(unique = true, nullable = false)
        private LanguageName name;
        @Column(nullable = false)
        private String description;
        @OneToMany(mappedBy = "language")
        private List<Word> words;

        public LanguageName getName() {
                return name;
        }

        public Language setName(LanguageName name) {
                this.name = name;
                this.setDescription(name);
                return this;
        }

        public String getDescription() {
                return description;
        }

        public Language setDescription(String description) {
                this.description = description;
                return this;
        }

        public List<Word> getWords() {
                return words;
        }

        public Language setWords(List<Word> words) {
                this.words = words;
                return this;
        }

        private void setDescription(LanguageName name) {
                String description = "";

                switch (name) {
                        case GERMAN -> description = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
                        case FRENCH -> description = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
                        case SPANISH -> description = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
                        case ITALIAN -> description = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";

                }

                this.description = description;
        }
}
