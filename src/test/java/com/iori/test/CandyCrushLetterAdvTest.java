package com.iori.test;

import com.iori.service.CandyCrushLetterService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * advance test
 */
@Slf4j
public class CandyCrushLetterAdvTest {

    private static CandyCrushLetterService candyCrushLetterService = new CandyCrushLetterService();

    @Test
    public void test001() {
        doTest("abcccbad");
    }

    @Test
    public void test002() {
        doTest("aaabbbccc");
    }

    @Test
    public void test003() {
        doTest("aaaa");
    }

    @Test
    public void test004() {
        doTest("bbccddeee");
    }

    @Test
    public void test005() {
        doTest("bbbb");
    }

    private void doTest(String word) {
        log.info("Input: " + word);
        log.info("Output: ");
        candyCrushLetterService.replaceLetter(word, true);
    }

}
