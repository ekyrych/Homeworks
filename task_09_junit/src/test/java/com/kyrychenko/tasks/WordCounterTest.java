package com.kyrychenko.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    private Map<String,Integer> severalWordSynonymsCount;
    private Map<String,Integer> severalWordSynonymsCount2;

    private WordCounter wordCounter;

    @BeforeEach
    public void setUp() {
        this.severalWordSynonymsCount = new HashMap<>();
        this.severalWordSynonymsCount.put("first word", 1);
        this.severalWordSynonymsCount.put("second word", 2);


        this.severalWordSynonymsCount2 = new HashMap<>();
        this.severalWordSynonymsCount2.put("first word", 4);
        this.severalWordSynonymsCount2.put("Third word", 3);

        this.wordCounter = new WordCounter();
    }

    @Test
    public void shouldAddSeveralWordSynonymsCount() {
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("first word", 5);
        expectedMap.put("second word", 2);
        expectedMap.put("Third word", 3);


        this.wordCounter.addWordSynonymsCount(this.severalWordSynonymsCount);
        this.wordCounter.addWordSynonymsCount(this.severalWordSynonymsCount2);


        assertEquals(expectedMap, this.wordCounter.getWordSynonymsCount());
    }

    @Test
    public void shouldAddWordSynonymsCount() {
        this.wordCounter.addWordSynonymsCount(this.severalWordSynonymsCount);
        assertEquals(this.severalWordSynonymsCount, this.wordCounter.getWordSynonymsCount());
    }

    @Test
    public void testGetWordSynonymsCount_ShouldBeNotNull() {
        assertNotNull(this.wordCounter.getWordSynonymsCount());
    }
}