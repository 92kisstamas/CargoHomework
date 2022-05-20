package com.company.CargoHomework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Cargo {
    private LocalDate localdate;
    private String source;
    private String destination;
    private String type;
    private double value;

    public int getGrossValue () {
        return 0;
    }

    public Cargo() {
    }

    public Cargo(LocalDate localdate, String source,
                 String destination, String type, double value) {
        this.localdate = localdate;
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.value = value;
    }

    public Cargo (String line) {
        String[] temp = line.split(";");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        formatter = formatter.withLocale(Locale.forLanguageTag(temp[0]));

        localdate = LocalDate.parse(temp[0], formatter);
        source = temp[1];
        destination = temp[2];
        type = temp[3];
        value = Double.parseDouble(temp[4]);
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
