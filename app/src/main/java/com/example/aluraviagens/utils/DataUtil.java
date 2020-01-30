package com.example.aluraviagens.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String FORMATO_DE_DATA_BRASILEIRO = "dd/MM";

    public static String formataDataParaPadraoBrasileiro(int dias) {
        Calendar dataDaIda = Calendar.getInstance();
        Calendar dataDaVolta = Calendar.getInstance();
        dataDaVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiroDeData = new SimpleDateFormat(FORMATO_DE_DATA_BRASILEIRO);
        String dataDaIdaFormatada = formatoBrasileiroDeData.format(dataDaIda.getTime());
        String dataDaVoltaFormatada = formatoBrasileiroDeData.format(dataDaVolta.getTime());
        return dataDaIdaFormatada + " - " + dataDaVoltaFormatada
                + " de " + dataDaVolta.get(Calendar.YEAR);
    }
}
