package br.com.control.revenda.entity.enums;

public enum EnvironmentEnum {

    PRODUCTION("PROD"),
    DEVELOP("DEV"),
    QA("QA");

    public String enviroment;

    EnvironmentEnum(String valor) {
        enviroment = valor;
    }

}
