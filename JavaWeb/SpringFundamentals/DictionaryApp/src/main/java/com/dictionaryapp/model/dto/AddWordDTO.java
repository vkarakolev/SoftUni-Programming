package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record AddWordDTO(
        @NotNull
        @Size(min = 2, max = 40)
        String term,
        @NotNull
        @Size(min = 2, max = 80)
        String translation,
        @Size(min = 2, max = 200)
        String example,
        @NotNull
        LocalDate inputDate,
        @NotNull
        LanguageName language
) {
}
