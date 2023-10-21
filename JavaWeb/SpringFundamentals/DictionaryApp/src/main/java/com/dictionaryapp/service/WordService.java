package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.dto.HomeWordsDTO;

import java.util.UUID;

public interface WordService {

    boolean add(AddWordDTO addWordDTO);

    HomeWordsDTO getWordsForHome();

    void remove(UUID id);

    void removeAll();
}
