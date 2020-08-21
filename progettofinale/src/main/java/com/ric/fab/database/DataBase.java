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
    String data_creazione;
    @Expose
    static List<DataBase> dataBaseList= new ArrayList<>();
    public DataBase(String nome,String tipo,String data,String data_creazione){
        this.nome=nome;
        this.tipo=tipo;
        this.data=data;
        this.data_creazione=data_creazione;

    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getData_creazione() {
        return data_creazione;
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
                ", data_creazione='" + data_creazione + '\'' +
                '}';
    }
}
