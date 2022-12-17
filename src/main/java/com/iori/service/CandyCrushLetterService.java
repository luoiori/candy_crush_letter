package com.iori.service;

import lombok.extern.slf4j.Slf4j;

/**
 * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
 * characters are identical, remove them from the string. Repeat this process until
 * there is no more than 3 identical characters sitting besides each other.
 * <p>
 * Example:
 * Input: aabcccbbad
 * Output:
 * -> aabbbad
 * -> aaad
 * -> d
 * <p>
 * #Stage 2 - advanced requirement
 * Instead of removing the consecutively identical characters, replace them with a
 * single character that comes before it alphabetically.
 * Example:
 * ccc -> c
 * bbb -> a
 * <p>
 * Input: abcccbad
 * Output:
 * -> abbbad, ccc is replaced by b
 * -> aaad, bbb is replaced by a
 * -> d
 */
@Slf4j
public class CandyCrushLetterService {

    public void replaceLetter(String word) {
        replaceLetter(word, 0, false);
    }

    public void replaceLetter(String word, boolean replaceByPreviousLetter) {
        String ret = replaceLetter(word, 0, replaceByPreviousLetter);
        if (replaceByPreviousLetter)
            log.info("-> {}", ret);
    }

    private String replaceLetter(String word, int start, boolean replaceByPreviousLetter) {
        int minLength = 3;
        for (; start < word.length() && start + minLength <= word.length(); ) {
            String subWord = word.substring(start, start + minLength);
            if (isIdenticalCharacters(subWord)) {
                for (int j = start + minLength; j <= word.length(); j++) {
                    subWord = word.substring(start, j);
                    // loop until different character or ended
                    if (!isIdenticalCharacters(subWord) || j == word.length()) {
                        // if current character is the end, process the whole, else process except the latest character
                        boolean justEnd = isIdenticalCharacters(subWord) && j == word.length();
                        // if replace, get replace character
                        String replaceCharacter = (replaceByPreviousLetter ? getPreviousLetter(subWord.charAt(0)) : "");
                        word = word.substring(0, start)
                                + replaceCharacter
                                + word.substring(j - (justEnd ? 0 : 1));
                        String toReplaceCharacters = subWord.substring(0, subWord.length() - (justEnd ? 0 : 1));
                        String extraInfo = ", " + toReplaceCharacters + " is replaced by " + replaceCharacter;
                        log.info("-> {}{}",
                                word,
                                replaceByPreviousLetter ? extraInfo : ""
                        );
                        // word changes, repeat
                        return replaceLetter(word, 0, replaceByPreviousLetter);
                    }
                }
            }
            start++;

        }
        return word;
    }

    /**
     * @param character
     * @return if 'a' return "" else return the previous letter
     */
    private String getPreviousLetter(char character) {
        char first = 'a';
        if (character == first) return "";
        return String.valueOf((char) (character - 1));
    }

    /**
     * whether the word is identical
     *
     * @param word
     * @return true identical characters or false
     */
    private boolean isIdenticalCharacters(String word) {
        if (word == null || word.length() == 0) return false;
        char firstLetter = word.charAt(0);
        for (char l : word.toCharArray()) {
            if (l != firstLetter) return false;
        }
        return true;
    }

}
