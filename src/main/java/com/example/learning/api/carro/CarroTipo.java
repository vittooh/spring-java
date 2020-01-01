package com.example.learning.api.carro;

public enum CarroTipo {
    CLASSICO("CLASSICO"),
    ESPORTIVO("ESPORTIVO"),
    LUXO("LUXO");

    private String name;

    CarroTipo(String nome) {
        this.name = nome;
    }


    public static CarroTipo getEnum(String value) {
        switch (value) {
            case "CLASSICO":
                return CarroTipo.CLASSICO;
            case "ESPORTIVO":
                return CarroTipo.CLASSICO;
            case "LUXO":
                return CarroTipo.CLASSICO;
            default:
                return null;
        }
    }


}
