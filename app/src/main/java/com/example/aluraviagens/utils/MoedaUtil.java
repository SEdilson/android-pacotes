package com.example.aluraviagens.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String IDIOMA = "pt";
    public static final String PAIS = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_DESEJADO = "R$ ";

    public static String converteParaReais(BigDecimal precoDoPacote) {
        NumberFormat formatoBrasileiro = DecimalFormat
                .getCurrencyInstance(new Locale(IDIOMA, PAIS));
        return formatoBrasileiro.format(precoDoPacote)
                .replace(FORMATO_PADRAO, FORMATO_DESEJADO);
    }
}
