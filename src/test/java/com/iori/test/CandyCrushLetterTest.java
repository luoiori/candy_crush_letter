package com.iori.test;

import com.iori.service.CandyCrushLetterService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * basic test
 */
@Slf4j
public class CandyCrushLetterTest {

    private static CandyCrushLetterService candyCrushLetterService = new CandyCrushLetterService();

    @Test
    public void test001() {
        doTest("aabcccbbad");
    }

    @Test
    public void test002() {
        doTest("aaaccaceefff");
    }

    @Test
    public void test003() {
        doTest("xxxyyyzzz");
    }

    @Test
    public void test004() {
        doTest("xxyyzzzyx");
    }

    @Test
    public void test005() {
        doTest("xxxxxxxxyyy");
    }

    private void doTest(String word) {
        log.info("Input: " + word);
        log.info("Output: ");
        candyCrushLetterService.replaceLetter(word);
    }

}
