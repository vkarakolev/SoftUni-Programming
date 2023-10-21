package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.dto.HomeWordsDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WordServiceImpl implements WordService {
    private final LoggedUser loggedUser;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final WordRepository wordRepository;

    public WordServiceImpl(LoggedUser loggedUser, LanguageRepository languageRepository, UserRepository userRepository, WordRepository wordRepository) {
        this.loggedUser = loggedUser;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
    }


    @Override
    public boolean add(AddWordDTO addWordDTO) {
        User user = userRepository.findByUsername(loggedUser.getUsername());
        Language language = languageRepository.findByName(addWordDTO.language());

        if(language != null &&  user != null) {
            wordRepository.save(map(addWordDTO, user, language));
            return true;
        }
        return false;
    }

    @Override
    public HomeWordsDTO getWordsForHome() {
        List<Word> words =  wordRepository.findAll();
        List<Word> german = new ArrayList<>();
        List<Word> spanish = new ArrayList<>();
        List<Word> french = new ArrayList<>();
        List<Word> italian = new ArrayList<>();

        words.forEach(word -> {
            switch(word.getLanguage().getName()) {
                case FRENCH -> french.add(word);
                case GERMAN -> german.add(word);
                case ITALIAN -> italian.add(word);
                case SPANISH -> spanish.add(word);
            }
        });

        return new HomeWordsDTO(german, french, spanish, italian,
                german.size(), french.size(), spanish.size(), italian.size(), words.size());
    }

    @Override
    public void remove(UUID id) {
        Optional<Word> optional = wordRepository.findById(id);

        if(optional.isPresent()) {
            Word word = optional.get();
            wordRepository.delete(word);
        }
    }

    @Override
    public void removeAll() {
        if(wordRepository.count() > 0) {
            wordRepository.deleteAll();
        }
    }

    private Word map(AddWordDTO addWordDTO,User user, Language language) {
        return new Word()
                .setAddedBy(user)
                .setExample(addWordDTO.example())
                .setTranslation(addWordDTO.translation())
                .setTerm(addWordDTO.term())
                .setInputDate(addWordDTO.inputDate())
                .setLanguage(language);
    }
}
