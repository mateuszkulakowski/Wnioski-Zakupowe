/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Mateusz
 */
public class Przedmiot_zamowienia {
    
    private int Przedmiot_zamowienia_id;
    private Integer Wniosek_ID;
    private Date Data_osoby_dokonujacej_opisu;
    private Integer Osoba_dokonujaca_opisu_ID;
    private Integer Osoba_opiniujaca_tryb_udzielania_zam_ID;
    private Integer Pelnomocnik_rektora_ID;

    public int getPrzedmiot_zamowienia_id() {
        return Przedmiot_zamowienia_id;
    }

    public void setPrzedmiot_zamowienia_id(int Przedmiot_zamowienia_id) {
        this.Przedmiot_zamowienia_id = Przedmiot_zamowienia_id;
    }

    public Integer getWniosek_ID() {
        return Wniosek_ID;
    }

    public void setWniosek_ID(Integer Wniosek_ID) {
        this.Wniosek_ID = Wniosek_ID;
    }

    public Date getData_osoby_dokonujacej_opisu() {
        return Data_osoby_dokonujacej_opisu;
    }

    public void setData_osoby_dokonujacej_opisu(Date Data_osoby_dokonujacej_opisu) {
        this.Data_osoby_dokonujacej_opisu = Data_osoby_dokonujacej_opisu;
    }

    public Integer getOsoba_dokonujaca_opisu_ID() {
        return Osoba_dokonujaca_opisu_ID;
    }

    public void setOsoba_dokonujaca_opisu_ID(Integer Osoba_dokonujaca_opisu_ID) {
        this.Osoba_dokonujaca_opisu_ID = Osoba_dokonujaca_opisu_ID;
    }

    public Integer getOsoba_opiniujaca_tryb_udzielania_zam_ID() {
        return Osoba_opiniujaca_tryb_udzielania_zam_ID;
    }

    public void setOsoba_opiniujaca_tryb_udzielania_zam_ID(Integer Osoba_opiniujaca_tryb_udzielania_zam_ID) {
        this.Osoba_opiniujaca_tryb_udzielania_zam_ID = Osoba_opiniujaca_tryb_udzielania_zam_ID;
    }

    public Integer getPelnomocnik_rektora_ID() {
        return Pelnomocnik_rektora_ID;
    }

    public void setPelnomocnik_rektora_ID(Integer Pelnomocnik_rektora_ID) {
        this.Pelnomocnik_rektora_ID = Pelnomocnik_rektora_ID;
    }
    
    
    
    
}
