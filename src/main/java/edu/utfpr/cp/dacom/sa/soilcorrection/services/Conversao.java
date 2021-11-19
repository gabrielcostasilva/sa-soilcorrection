package edu.utfpr.cp.dacom.sa.soilcorrection.services;

public interface Conversao<T, R> {

    public R converte(T valor);
}
