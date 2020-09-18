package com.test.hello;

/**
 * @author NIsaev on 18.05.2020
 */
import com.ibm.icu.text.Transliterator;

import java.util.Base64;

public class Transcriptor {

    public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
    public static final String LATIN_TO_CYRILLIC = "Latin-Russian/BGN";

    public static void main(String[] args) {

        System.out.println(new String(Base64.getDecoder().decode("OTQxNzEzNTA0NzgwOTEzNA==")));
        System.out.println(new String(Base64.getDecoder().decode("OTQxNzEzODUzNDM1OTEzNA==")));


        String st = "JAMAL MUSTAFA ABDALLAH SULTAN";
        System.out.println("Orig Name: " +st);

        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String result = toLatinTrans.transliterate(st);
        System.out.println("First change: " +result);

        Transliterator toCyrillicTrans = Transliterator.getInstance(LATIN_TO_CYRILLIC);

        String result2 = toCyrillicTrans.transliterate(result);
        System.out.println("Translit to Back: " +result2);

        String result3 = toCyrillicTrans.transliterate(st);
        System.out.println("ORIG to Cyril: " + result3);
    }
}