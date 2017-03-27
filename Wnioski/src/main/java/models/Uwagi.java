
package models;

import java.beans.Transient;

/**
 *
 * @author Patryk
 */
public class Uwagi {
    
    private int uwaga_id;
    private String tresc;
    private Integer wniosek_id;
    private Integer user_id;
    private String imie;
    private String nazwisko;
    private String rola;
    
    @Transient
    public String getImie() {
        return imie;
    }
    
    @Transient
    public void setImie(String imie) {
        this.imie = imie;
    }
    
    @Transient
    public String getNazwisko() {
        return nazwisko;
    }
    
    @Transient
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    @Transient
    public String getRola() {
        return rola;
    }
    
    @Transient
    public void setRola(String rola) {
        this.rola = rola;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public int getUwaga_id() {
        return uwaga_id;
    }

    public void setUwaga_id(int uwaga_id) {
        this.uwaga_id = uwaga_id;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Integer getWniosek_id() {
        return wniosek_id;
    }

    public void setWniosek_id(Integer wniosek_id) {
        this.wniosek_id = wniosek_id;
    }
}
