package br.com.vivo.challenge.backend.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    /**
     * Construtor padrão privado para a classe não ser instanciada indevidamente.
     */
    private ListUtils() {
    }

    /**
     * Método para converter um Iterable de T em uma lista de T
     *
     * @param itr o iterable de T
     * @param <T> a classe alvo
     * @return a lista da classe alvo
     */
    public static <T> List<T> getListFromIterable(Iterable<T> itr) {
        List<T> listT = new ArrayList<>();
        itr.forEach(listT::add);
        return listT;
    }
}