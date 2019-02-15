package com.kyrychenko.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    private Map<String,Integer> wordSynonymsCount;

    public WordCounter() {
        this.wordSynonymsCount = new HashMap<>();
    }

    public WordCounter addWordSynonymsCount(Map<String,Integer> newMap) {
        return this.setWordSynonymsCount(Stream.concat(this.wordSynonymsCount.entrySet().stream(), newMap.entrySet().stream())
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        Integer::sum
                        )
                ));

    }

    public Map<String, Integer> getWordSynonymsCount() {
        return wordSynonymsCount;
    }

    public WordCounter setWordSynonymsCount(Map<String, Integer> wordSynonymsCount) {
        this.wordSynonymsCount = wordSynonymsCount;
        return this;
    }
}
