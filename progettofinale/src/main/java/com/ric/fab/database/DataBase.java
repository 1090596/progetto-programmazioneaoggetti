package com.ric.fab.database;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    @Expose
    String nome;
    @Expose
    String tipo;
    @Expose
    String data;
    @Expose
    Long size;
    @Expose
    String tag;
    @Expose
    String modifica;
    @Expose
    int altezza;
    @Expose
    int lunghezza;

    static List<DataBase> dataBaseList = new ArrayList<>();

    public DataBase(String tag, String nome, String modifica, Long size, String tipo, int altezza, int lunghezza) {
        this.tag = tag;
        this.nome = nome;
        this.modifica = modifica;
        this.size = size;
        this.tipo = tipo;
        this.altezza = altezza;
        this.lunghezza = lunghezza;

    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public Long getSize() {
        return size;
    }

    public String getTag() {
        return tag;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public String getModifica() {
        return modifica;
    }

    public String getTipo() {
        return tipo;
    }

    public static List<DataBase> getDataBaseList() {
        return dataBaseList;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", data='" + data + '\'' +
                ", size=" + size +
                ", tag='" + tag + '\'' +
                ", modifica='" + modifica + '\'' +
                ", altezza=" + altezza +
                ", lunghezza=" + lunghezza +
                '}';
    }
}
