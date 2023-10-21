package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Word;

import java.util.List;

public record HomeWordsDTO(
        List<Word> germanWords,
        List<Word> frenchWords,
        List<Word> spanishWords,
        List<Word> italianWords,
        long germanCount,
        long frenchCount,
        long spanishCount,
        long italianCount,
        long totalCount
) {
}
