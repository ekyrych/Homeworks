package com.kyrychenko.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WordCounterServiceTest {
    @Mock
    private WordCounter wordCounter;

    @InjectMocks
    private WordCounterService wordCounterService;


    @Test
    void calculateSimilarWordsNumber() {
        List<String> words = Arrays.asList("cool", "bad", "cool");
        Map<String,Integer> expected = new HashMap<>();
        expected.put("cool",2);
        expected.put("bad", 1);
        when(wordCounter.addWordSynonymsCount(expected)).thenReturn(this.wordCounter);
        when(wordCounter.getWordSynonymsCount()).thenReturn(expected);
        this.wordCounterService.calculateSimilarWordsNumber(words);
        assertEquals(expected, this.wordCounterService.getNumbersOfWordsMap());
    }

}