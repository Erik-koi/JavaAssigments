package com.example.javafxproject;

import java.util.NoSuchElementException;

public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();
        dictionary.addWord("apple", "A round fruit with red, green, or yellow skin.");
        dictionary.addWord("book", "A written or printed work consisting of pages.");
        dictionary.addWord("computer", "An electronic device for storing and processing data.");
        dictionary.addWord("java", "A popular programming language and a type of coffee.");
        dictionary.addWord("cat", "A small domesticated carnivorous mammal.");
    }

    public String search(String word) {
        if (word == null || word.isBlank()) {
            return "Please enter a word to search.";
        }

        try {
            return dictionary.searchWord(word);
        } catch (NoSuchElementException exception) {
            return "Word not found: " + word.trim();
        }
    }
}
