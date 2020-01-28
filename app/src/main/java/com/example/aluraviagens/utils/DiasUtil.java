package com.example.aluraviagens.utils;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String editaTextoDias(int diasPacote) {
        if(diasPacote > 1) {
            return diasPacote + PLURAL;
        } return diasPacote + SINGULAR;
    }
}
