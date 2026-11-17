package com.example.javafxproject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

public class Dictionary {
    private final Map<String, String> words = new HashMap<>();

    public void addWord(String word, String meaning) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Word must not be empty.");
        }
        if (meaning == null || meaning.isBlank()) {
            throw new IllegalArgumentException("Meaning must not be empty.");
        }

        words.put(normalize(word), meaning.trim());
    }

    public String searchWord(String word) {
        String normalizedWord = normalize(word);
        String meaning = words.get(normalizedWord);
        if (meaning == null) {
            throw new NoSuchElementException("Word not found: " + word);
        }
        return meaning;
    }

    private String normalize(String word) {
        if (word == null) {
            return "";
        }
        return word.trim().toLowerCase(Locale.ROOT);
    }
}
