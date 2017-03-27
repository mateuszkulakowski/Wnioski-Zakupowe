/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Mateusz
 */
public class Wniosek implements Serializable{
    
    private int Wniosek_ID;
    private String Stan;
    private Integer Nr_rej_wniosku;
    private String Jednostka_org_uczelni;
    private String Wnioskodawca;
    private Integer Wnioskodawca_tel;
    private String Os_dok_opisu_prz_zam;
    private Integer Os_dok_opisu_prz_zam_tel;
    private String Os_dok_opisu_prz_zam_e_mail;
    private String Przedmiot_zamowienia;
    private Date Przedmiot_zamowienia_okres;
    private String Metoryczne_uzas_cel_dok_zakupu;
    private Date Termin_realizacji_zam;
    private Double Szacunkowa_wartosc_zam;
    private String Ustalenia_szac_wartosci;
    private String Osoba_dok_ustalenia_szac_wart_zam;
    private Double Kwota_przeznaczona_sfinans_zam;
    private String Zrodlo_sfinansowania;
    private Date Data_osoby_szacujacej;
    private Integer Osoba_szacujacaID;
    private Date Data_wnioskodawcy;
    private Integer Osoba_wnioskodawcaID;
    private String Potwierdzenie_pokrycia_fin_ze_srodkow;
    private Date Potwierdzenie_pokrycia_fin_ze_srodkow_data;
    private Integer Kierownik_dzialu_naukID;
    private String Potwierdzenie_zgodnosci_budzet;
    private Date Potwierdzenie_zgodnosci_budzet_data;
    private Integer Kierownik_BRPM_BWM_ID;
    private String Zgodnosc_z_planem_rzeczowym;
    private String Kontrasygnata_uwagi;
    private Date Kontrasygnata_data;
    private Integer Kwestor_ID;
    private Integer Szef_pionuID;
    
    private Date Data_zlozenia_w_dziale_zam_pub;
    private Integer Osoba_przyjmujaca_wniosek_ID;
    private String Uwagi_działu_zam_pub_dot_wniosku;
    private String Komisja_przetargowa;
    private String Dzial_aparatury_badawczej;
    private String Wnioskodawca_z_uzg_z_dz_nauki;
    private String Dzial;
    private String Dzial_value;
    private String Pusty;
    private String Pusty_value;
    private String Wnioskodawca_tabelka;
    private Integer Kierownik_dzialu_zam_pub_ID;
    private Integer Pelnomocnik_rektora_ID;

    public int getWniosek_ID() {
        return Wniosek_ID;
    }

    public void setWniosek_ID(int Wniosek_ID) {
        this.Wniosek_ID = Wniosek_ID;
    }

    public String getStan() {
        return Stan;
    }

    public void setStan(String stan) {
        this.Stan = stan;
    }

    public Integer getNr_rej_wniosku() {
        return Nr_rej_wniosku;
    }

    public void setNr_rej_wniosku(Integer Nr_rej_wniosku) {
        this.Nr_rej_wniosku = Nr_rej_wniosku;
    }

    public String getJednostka_org_uczelni() {
        return Jednostka_org_uczelni;
    }

    public void setJednostka_org_uczelni(String Jednostka_org_uczelni) {
        this.Jednostka_org_uczelni = Jednostka_org_uczelni;
    }

    public String getWnioskodawca() {
        return Wnioskodawca;
    }

    public void setWnioskodawca(String Wnioskodawca) {
        this.Wnioskodawca = Wnioskodawca;
    }

    public Integer getWnioskodawca_tel() {
        return Wnioskodawca_tel;
    }

    public void setWnioskodawca_tel(Integer Wnioskodawca_tel) {
        this.Wnioskodawca_tel = Wnioskodawca_tel;
    }

    public String getOs_dok_opisu_prz_zam() {
        return Os_dok_opisu_prz_zam;
    }

    public void setOs_dok_opisu_prz_zam(String Os_dok_opisu_prz_zam) {
        this.Os_dok_opisu_prz_zam = Os_dok_opisu_prz_zam;
    }

    public Integer getOs_dok_opisu_prz_zam_tel() {
        return Os_dok_opisu_prz_zam_tel;
    }

    public void setOs_dok_opisu_prz_zam_tel(Integer Os_dok_opisu_prz_zam_tel) {
        this.Os_dok_opisu_prz_zam_tel = Os_dok_opisu_prz_zam_tel;
    }

    public String getOs_dok_opisu_prz_zam_e_mail() {
        return Os_dok_opisu_prz_zam_e_mail;
    }

    public void setOs_dok_opisu_prz_zam_e_mail(String Os_dok_opisu_prz_zam_e_mail) {
        this.Os_dok_opisu_prz_zam_e_mail = Os_dok_opisu_prz_zam_e_mail;
    }

    public String getPrzedmiot_zamowienia() {
        return Przedmiot_zamowienia;
    }

    public void setPrzedmiot_zamowienia(String Przedmiot_zamowienia) {
        this.Przedmiot_zamowienia = Przedmiot_zamowienia;
    }

    public Date getPrzedmiot_zamowienia_okres() {
        return Przedmiot_zamowienia_okres;
    }

    public void setPrzedmiot_zamowienia_okres(Date Przedmiot_zamowienia_okres) {
        this.Przedmiot_zamowienia_okres = Przedmiot_zamowienia_okres;
    }

    public String getMetoryczne_uzas_cel_dok_zakupu() {
        return Metoryczne_uzas_cel_dok_zakupu;
    }

    public void setMetoryczne_uzas_cel_dok_zakupu(String Metoryczne_uzas_cel_dok_zakupu) {
        this.Metoryczne_uzas_cel_dok_zakupu = Metoryczne_uzas_cel_dok_zakupu;
    }

    public Date getTermin_realizacji_zam() {
        return Termin_realizacji_zam;
    }

    public void setTermin_realizacji_zam(Date Termin_realizacji_zam) {
        this.Termin_realizacji_zam = Termin_realizacji_zam;
    }

    public Double getSzacunkowa_wartosc_zam() {
        return Szacunkowa_wartosc_zam;
    }

    public void setSzacunkowa_wartosc_zam(Double Szacunkowa_wartosc_zam) {
        this.Szacunkowa_wartosc_zam = Szacunkowa_wartosc_zam;
    }

    public String getUstalenia_szac_wartosci() {
        return Ustalenia_szac_wartosci;
    }

    public void setUstalenia_szac_wartosci(String Ustalenia_szac_wartosci) {
        this.Ustalenia_szac_wartosci = Ustalenia_szac_wartosci;
    }

    public String getOsoba_dok_ustalenia_szac_wart_zam() {
        return Osoba_dok_ustalenia_szac_wart_zam;
    }

    public void setOsoba_dok_ustalenia_szac_wart_zam(String Osoba_dok_ustalenia_szac_wart_zam) {
        this.Osoba_dok_ustalenia_szac_wart_zam = Osoba_dok_ustalenia_szac_wart_zam;
    }

    public Double getKwota_przeznaczona_sfinans_zam() {
        return Kwota_przeznaczona_sfinans_zam;
    }

    public void setKwota_przeznaczona_sfinans_zam(Double Kwota_przeznaczona_sfinans_zam) {
        this.Kwota_przeznaczona_sfinans_zam = Kwota_przeznaczona_sfinans_zam;
    }

    public String getZrodlo_sfinansowania() {
        return Zrodlo_sfinansowania;
    }

    public void setZrodlo_sfinansowania(String Zrodlo_sfinansowania) {
        this.Zrodlo_sfinansowania = Zrodlo_sfinansowania;
    }

    public Date getData_osoby_szacujacej() {
        return Data_osoby_szacujacej;
    }

    public void setData_osoby_szacujacej(Date Data_osoby_szacujacej) {
        this.Data_osoby_szacujacej = Data_osoby_szacujacej;
    }

    public Integer getOsoba_szacujacaID() {
        return Osoba_szacujacaID;
    }

    public void setOsoba_szacujacaID(Integer Osoba_szacujacaID) {
        this.Osoba_szacujacaID = Osoba_szacujacaID;
    }

    public Date getData_wnioskodawcy() {
        return Data_wnioskodawcy;
    }

    public void setData_wnioskodawcy(Date Data_wnioskodawcy) {
        this.Data_wnioskodawcy = Data_wnioskodawcy;
    }

    public Integer getOsoba_wnioskodawcaID() {
        return Osoba_wnioskodawcaID;
    }

    public void setOsoba_wnioskodawcaID(Integer Osoba_wnioskodawcaID) {
        this.Osoba_wnioskodawcaID = Osoba_wnioskodawcaID;
    }

    public String getPotwierdzenie_pokrycia_fin_ze_srodkow() {
        return Potwierdzenie_pokrycia_fin_ze_srodkow;
    }

    public void setPotwierdzenie_pokrycia_fin_ze_srodkow(String Potwierdzenie_pokrycia_fin_ze_srodkow) {
        this.Potwierdzenie_pokrycia_fin_ze_srodkow = Potwierdzenie_pokrycia_fin_ze_srodkow;
    }

    public Date getPotwierdzenie_pokrycia_fin_ze_srodkow_data() {
        return Potwierdzenie_pokrycia_fin_ze_srodkow_data;
    }

    public void setPotwierdzenie_pokrycia_fin_ze_srodkow_data(Date Potwierdzenie_pokrycia_fin_ze_srodkow_data) {
        this.Potwierdzenie_pokrycia_fin_ze_srodkow_data = Potwierdzenie_pokrycia_fin_ze_srodkow_data;
    }

    public Integer getKierownik_dzialu_naukID() {
        return Kierownik_dzialu_naukID;
    }

    public void setKierownik_dzialu_naukID(Integer Kierownik_dzialu_naukID) {
        this.Kierownik_dzialu_naukID = Kierownik_dzialu_naukID;
    }

    public String getPotwierdzenie_zgodnosci_budzet() {
        return Potwierdzenie_zgodnosci_budzet;
    }

    public void setPotwierdzenie_zgodnosci_budzet(String Potwierdzenie_zgodnosci_budzet) {
        this.Potwierdzenie_zgodnosci_budzet = Potwierdzenie_zgodnosci_budzet;
    }

    public Date getPotwierdzenie_zgodnosci_budzet_data() {
        return Potwierdzenie_zgodnosci_budzet_data;
    }

    public void setPotwierdzenie_zgodnosci_budzet_data(Date Potwierdzenie_zgodnosci_budzet_data) {
        this.Potwierdzenie_zgodnosci_budzet_data = Potwierdzenie_zgodnosci_budzet_data;
    }

    public Integer getKierownik_BRPM_BWM_ID() {
        return Kierownik_BRPM_BWM_ID;
    }

    public void setKierownik_BRPM_BWM_ID(Integer Kierownik_BRPM_BWM_ID) {
        this.Kierownik_BRPM_BWM_ID = Kierownik_BRPM_BWM_ID;
    }

    public String getZgodnosc_z_planem_rzeczowym() {
        return Zgodnosc_z_planem_rzeczowym;
    }

    public void setZgodnosc_z_planem_rzeczowym(String Zgodnosc_z_planem_rzeczowym) {
        this.Zgodnosc_z_planem_rzeczowym = Zgodnosc_z_planem_rzeczowym;
    }

    public String getKontrasygnata_uwagi() {
        return Kontrasygnata_uwagi;
    }

    public void setKontrasygnata_uwagi(String Kontrasygnata_uwagi) {
        this.Kontrasygnata_uwagi = Kontrasygnata_uwagi;
    }

    public Date getKontrasygnata_data() {
        return Kontrasygnata_data;
    }

    public void setKontrasygnata_data(Date Kontrasygnata_data) {
        this.Kontrasygnata_data = Kontrasygnata_data;
    }

    public Integer getKwestor_ID() {
        return Kwestor_ID;
    }

    public void setKwestor_ID(Integer Kwestor_ID) {
        this.Kwestor_ID = Kwestor_ID;
    }

    public Integer getSzef_pionuID() {
        return Szef_pionuID;
    }

    public void setSzef_pionuID(Integer Szef_pionuID) {
        this.Szef_pionuID = Szef_pionuID;
    }

    public Date getData_zlozenia_w_dziale_zam_pub() {
        return Data_zlozenia_w_dziale_zam_pub;
    }

    public void setData_zlozenia_w_dziale_zam_pub(Date Data_zlozenia_w_dziale_zam_pub) {
        this.Data_zlozenia_w_dziale_zam_pub = Data_zlozenia_w_dziale_zam_pub;
    }

    public Integer getOsoba_przyjmujaca_wniosek_ID() {
        return Osoba_przyjmujaca_wniosek_ID;
    }

    public void setOsoba_przyjmujaca_wniosek_ID(Integer Osoba_przyjmujaca_wniosek_ID) {
        this.Osoba_przyjmujaca_wniosek_ID = Osoba_przyjmujaca_wniosek_ID;
    }

    public String getUwagi_działu_zam_pub_dot_wniosku() {
        return Uwagi_działu_zam_pub_dot_wniosku;
    }

    public void setUwagi_działu_zam_pub_dot_wniosku(String Uwagi_działu_zam_pub_dot_wniosku) {
        this.Uwagi_działu_zam_pub_dot_wniosku = Uwagi_działu_zam_pub_dot_wniosku;
    }

    public String getKomisja_przetargowa() {
        return Komisja_przetargowa;
    }

    public void setKomisja_przetargowa(String Komisja_przetargowa) {
        this.Komisja_przetargowa = Komisja_przetargowa;
    }

    public String getDzial_aparatury_badawczej() {
        return Dzial_aparatury_badawczej;
    }

    public void setDzial_aparatury_badawczej(String Dzial_aparatury_badawczej) {
        this.Dzial_aparatury_badawczej = Dzial_aparatury_badawczej;
    }

    public String getWnioskodawca_z_uzg_z_dz_nauki() {
        return Wnioskodawca_z_uzg_z_dz_nauki;
    }

    public void setWnioskodawca_z_uzg_z_dz_nauki(String Wnioskodawca_z_uzg_z_dz_nauki) {
        this.Wnioskodawca_z_uzg_z_dz_nauki = Wnioskodawca_z_uzg_z_dz_nauki;
    }

    public String getDzial() {
        return Dzial;
    }

    public void setDzial(String Dzial) {
        this.Dzial = Dzial;
    }

    public String getDzial_value() {
        return Dzial_value;
    }

    public void setDzial_value(String Dzial_value) {
        this.Dzial_value = Dzial_value;
    }

    public String getPusty() {
        return Pusty;
    }

    public void setPusty(String Pusty) {
        this.Pusty = Pusty;
    }

    public String getPusty_value() {
        return Pusty_value;
    }

    public void setPusty_value(String Pusty_value) {
        this.Pusty_value = Pusty_value;
    }

    public String getWnioskodawca_tabelka() {
        return Wnioskodawca_tabelka;
    }

    public void setWnioskodawca_tabelka(String Wnioskodawca_tabelka) {
        this.Wnioskodawca_tabelka = Wnioskodawca_tabelka;
    }

    public Integer getKierownik_dzialu_zam_pub_ID() {
        return Kierownik_dzialu_zam_pub_ID;
    }

    public void setKierownik_dzialu_zam_pub_ID(Integer Kierownik_dzialu_zam_pub_ID) {
        this.Kierownik_dzialu_zam_pub_ID = Kierownik_dzialu_zam_pub_ID;
    }

    public Integer getPelnomocnik_rektora_ID() {
        return Pelnomocnik_rektora_ID;
    }

    public void setPelnomocnik_rektora_ID(Integer Pelnomocnik_rektora_ID) {
        this.Pelnomocnik_rektora_ID = Pelnomocnik_rektora_ID;
    }
    
    
    
}
