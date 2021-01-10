package br.com.vivo.challenge.backend.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    /**
     * Construtor padrão privado para a classe não ser instanciada indevidamente.
     */
    private DateUtils() {
    }

    /**
     * Método responsável por gerar um LocalDateTime a partir de uma String pattern
     *
     * @param str valor de entrada
     * @return valor transformado
     */
    public static LocalDateTime getLocalDateTimeFromString(String str){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return LocalDateTime.parse(str, pattern);
    }
}
