package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumToEnglishTest {

    @Test
    void testNumberToEnglish() {
        assertEquals("one", NumToEnglish.numberToEnglish(1));
        assertEquals("twenty three", NumToEnglish.numberToEnglish(23));
        assertEquals("twelve", NumToEnglish.numberToEnglish(12));
        assertEquals("one hundred twenty three", NumToEnglish.numberToEnglish(123));
        assertEquals("one hundred two", NumToEnglish.numberToEnglish(102));
        assertEquals("one hundred twenty", NumToEnglish.numberToEnglish(120));
        assertEquals("one thousand two hundred thirty four", NumToEnglish.numberToEnglish(1234));
        assertEquals("one thousand one", NumToEnglish.numberToEnglish(1001));
        assertEquals("twelve thousand", NumToEnglish.numberToEnglish(12000));
        assertEquals("one million one hundred twenty three", NumToEnglish.numberToEnglish(1000123));
        assertEquals("minus one hundred twenty three", NumToEnglish.numberToEnglish(-123));
        assertEquals("zero", NumToEnglish.numberToEnglish(0));
    }
}