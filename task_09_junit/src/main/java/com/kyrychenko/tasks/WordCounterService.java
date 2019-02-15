package com.kyrychenko.tasks;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounterService {
    private WordCounter wordCounter;

    public WordCounterService(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public void calculateSimilarWordsNumber(List<String> words){
        Map<String, Integer> wordsNumber = words.stream().collect(Collectors.toMap(
                word -> word,
                word -> 1,
                Integer::sum
        ));
        this.wordCounter.addWordSynonymsCount(wordsNumber);
    }

    public Map<String, Integer> getNumbersOfWordsMap(){
        return this.wordCounter.getWordSynonymsCount();
    }
}
