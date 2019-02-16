package com.kyrychenko.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WordCounterServiceTest {

    public static final List<String> WORDS = Arrays.asList("cool", "bad", "cool");

    @Mock
    private WordCounter wordCounter;

    @InjectMocks
    private WordCounterService wordCounterService;

    @Captor
    private ArgumentCaptor<Map<String, Integer>> wordsNumberCaptor;

    private Map<String, Integer> expectedMap;


    @BeforeEach
    public void setUp(){
        expectedMap = new HashMap<>();
        expectedMap.put("cool",2);
        expectedMap.put("bad", 1);
    }

    @Test
    void testCalculateSimilarWordsNumber() {
        this.wordCounterService.calculateSimilarWordsNumber(WORDS);
        verify(wordCounter).addWordSynonymsCount(wordsNumberCaptor.capture());
        assertEquals(expectedMap, wordsNumberCaptor.getValue());
    }

    @Test
    void testGetNumbersOfWordsMap_ShouldReturnData() {
        when(wordCounter.getWordSynonymsCount()).thenReturn(expectedMap);
        assertEquals(expectedMap, wordCounterService.getNumbersOfWordsMap());
    }

    @Test
    void testGetNumbersOfWordsMap_ShouldReturnMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        when(wordCounter.getWordSynonymsCount()).thenReturn(emptyMap);
        assertEquals(emptyMap, wordCounterService.getNumbersOfWordsMap());
    }
}