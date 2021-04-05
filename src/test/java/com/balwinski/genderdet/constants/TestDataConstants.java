package com.balwinski.genderdet.constants;

public class TestDataConstants {

    private TestDataConstants() { }

    public static final String[] MALE_NAMES_SAMPLE = {"paweł kot", "MARCIN Nowak",
            "Rafał Głowacki", "JeRZy Jeż-Rozwadowski", "Krzysztof Maria Jan"};
    public static final String[] FEMALE_NAMES_SAMPLE = {"anna rozwadowska", "MAŁGORZATA Fiałkowska-Bąk",
            "Izabela Maria Soll", "rEnaTA", "Dorota Piotrowska", "Anna Zbigniew Gertruda"};
    public static final String[] NOT_NAMES = {"Public Automobile Service", "Kot w butach",
            "nonamename", "RANDOM WORDS"};
    public static final String[] INCONCLUSIVE_MALE_NAMES_FOR_MULTITOKEN = {"paweł maria kot", "Jan Maria Rokita",
            "Jan Maria-Rokita"};
    public static final String[] INCONCLUSIVE_FEMALE_NAMES_FOR_MULTITOKEN = {"Izabela Marian Soll",
            "Izabela Marian-Soll"};

}
