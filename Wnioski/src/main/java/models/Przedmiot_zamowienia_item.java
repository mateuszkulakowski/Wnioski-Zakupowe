/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Mateusz
 */
public class Przedmiot_zamowienia_item {
    
    private int Przedmiot_zam_item_id;
    private String Nazwa_opis_przedmiotu_zam;
    private String Jednostka_miary;
    private Integer Ilosc;
    private Double Kwota_przeznaczona_na_real;
    private Integer Pozycja_w_planie_zam_jedn;
    private String Opinia_dot_trybu_udzielania_zam;
    private Integer Przedmiot_zamowienia_ID;

    public int getPrzedmiot_zam_item_id() {
        return Przedmiot_zam_item_id;
    }

    public void setPrzedmiot_zam_item_id(int Przedmiot_zam_item_id) {
        this.Przedmiot_zam_item_id = Przedmiot_zam_item_id;
    }

    public String getNazwa_opis_przedmiotu_zam() {
        return Nazwa_opis_przedmiotu_zam;
    }

    public void setNazwa_opis_przedmiotu_zam(String Nazwa_opis_przedmiotu_zam) {
        this.Nazwa_opis_przedmiotu_zam = Nazwa_opis_przedmiotu_zam;
    }

    public String getJednostka_miary() {
        return Jednostka_miary;
    }

    public void setJednostka_miary(String Jednostka_miary) {
        this.Jednostka_miary = Jednostka_miary;
    }

    public Integer getIlosc() {
        return Ilosc;
    }

    public void setIlosc(Integer Ilosc) {
        this.Ilosc = Ilosc;
    }

    public Double getKwota_przeznaczona_na_real() {
        return Kwota_przeznaczona_na_real;
    }

    public void setKwota_przeznaczona_na_real(Double Kwota_przeznaczona_na_real) {
        this.Kwota_przeznaczona_na_real = Kwota_przeznaczona_na_real;
    }

    public Integer getPozycja_w_planie_zam_jedn() {
        return Pozycja_w_planie_zam_jedn;
    }

    public void setPozycja_w_planie_zam_jedn(Integer Pozycja_w_planie_zam_jedn) {
        this.Pozycja_w_planie_zam_jedn = Pozycja_w_planie_zam_jedn;
    }

    public String getOpinia_dot_trybu_udzielania_zam() {
        return Opinia_dot_trybu_udzielania_zam;
    }

    public void setOpinia_dot_trybu_udzielania_zam(String Opinia_dot_trybu_udzielania_zam) {
        this.Opinia_dot_trybu_udzielania_zam = Opinia_dot_trybu_udzielania_zam;
    }

    public Integer getPrzedmiot_zamowienia_ID() {
        return Przedmiot_zamowienia_ID;
    }

    public void setPrzedmiot_zamowienia_ID(Integer Przedmiot_zamowienia_ID) {
        this.Przedmiot_zamowienia_ID = Przedmiot_zamowienia_ID;
    }
    
    
    
    
}
