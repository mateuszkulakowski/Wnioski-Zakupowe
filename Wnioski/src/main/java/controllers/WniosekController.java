/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hibernate.connection.factory.ConnectionFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import klasy_pomocnicze.NawigacjaZatwierdzanieWnioskow;
import models.Przedmiot_zamowienia;
import models.Przedmiot_zamowienia_item;
import models.Users;
import models.Uwagi;
import models.Wniosek;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.hibernate.criterion.Restrictions;
import static org.hibernate.internal.CoreLogging.logger;
import static org.hibernate.internal.CoreLogging.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import stany.wniosku.Event;
import stany.wniosku.MaszynaStanow;
import stany.wniosku.Stan;


/**
 *
 * @author Mateusz
 */


public class WniosekController implements Serializable/*,WniosekStateChangeListener*/{
    
    private long serialVersionUID = 1L;
    private Wniosek wniosek = new Wniosek();
    private Wniosek wniosekView = new Wniosek();
    private Przedmiot_zamowienia przedmiot_zamowienia = new Przedmiot_zamowienia();
    private List<Wniosek> wnioski;
    private Uwagi uwaga = new Uwagi();
    private List<Uwagi> uwagi;
    private List<Przedmiot_zamowienia_item> listaPrzedmiotowZamowienia;
    
    
    public Przedmiot_zamowienia getPrzedmiot_zamowienia()
    {
        return przedmiot_zamowienia;
    }
    
    public void setPrzedmiot_zamowienia(Przedmiot_zamowienia pz)
    {
        this.przedmiot_zamowienia = pz;
    }
    
    
    public List<Przedmiot_zamowienia_item> getListaPrzedmiotowZamowienia()
    {
        return listaPrzedmiotowZamowienia;
    }
    
    public void setListaPrzedmiotowZamowienia(List<Przedmiot_zamowienia_item> lista)
    {
        this.listaPrzedmiotowZamowienia = lista;
    }

    public List<Uwagi> getUwagi() {
        return uwagi;
    }

    public void setUwagi(List<Uwagi> uwagi) {
        this.uwagi = uwagi;
    }

    public Uwagi getUwaga() {
        return uwaga;
    }

    public void setUwaga(Uwagi uwaga) {
        this.uwaga = uwaga;
    }
    
    public Wniosek getWniosekView() {
        return wniosekView;
    }

    public void setWniosekView(Wniosek wniosekView) {
        this.wniosekView = wniosekView;
    }

    public List<Wniosek> getWnioski() {
        return wnioski;
    }

    public void setWnioski(List<Wniosek> wnioski) {
        this.wnioski = wnioski;
    }
    
    
    public WniosekController() {
    }
 
    

    public Wniosek getWniosek() {
        return wniosek;
    }

    public void setWniosek(Wniosek wniosek) {
        this.wniosek = wniosek;
    }
    

    
    public void Dodaj(int opcja) throws FileNotFoundException
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                         .getExternalContext().getRequest();
        
        Session session = ConnectionFactory.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        
        String login_zalogowanego = UserController.getUserName();
        
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", login_zalogowanego));
        List<Users> result = cr.list();
        
        //ustawianie id osoby składającej wniosek
        wniosek.setOsoba_wnioskodawcaID(result.get(0).getUser_id());
        
        //ustawienie akt daty
        wniosek.setData_wnioskodawcy(new Date());
        
        //ustawianie osoby szacującej jako wnioskodawcę
        wniosek.setOsoba_szacujacaID(result.get(0).getUser_id());
        wniosek.setData_osoby_szacujacej(new Date());
        
        
        //ustawianie stanu na wypełniony
        switch (opcja) {
            case 1:
                wniosek.setStan(MaszynaStanow.getNextState(null, Event.przekażDziałNauk));
                break;
            case 2:
                wniosek.setStan(MaszynaStanow.getNextState(null, Event.przekażKBRPIM));
                break;
            case 3:
                wniosek.setStan(MaszynaStanow.getNextState(null, Event.przekażKwestorowi));
                break;
        }
        
        session.save(wniosek);
        
        
        //przypisywanie przedmiotów zamówienia z tabelki
        
        Przedmiot_zamowienia przedmiotZamowienia = new Przedmiot_zamowienia();
        przedmiotZamowienia.setWniosek_ID(wniosek.getWniosek_ID());
        przedmiotZamowienia.setData_osoby_dokonujacej_opisu(new Date());
        przedmiotZamowienia.setOsoba_dokonujaca_opisu_ID(result.get(0).getUser_id());
        
        session.save(przedmiotZamowienia);
        
        String ilosc = request.getParameter("iloscPrzedmiotowZamowienia");
        int iloscPozcjiWTabeli = Integer.valueOf(ilosc);
        
        for(int i=1; i<=iloscPozcjiWTabeli; i++)
        {
            Przedmiot_zamowienia_item pzi = new Przedmiot_zamowienia_item();
            pzi.setNazwa_opis_przedmiotu_zam(request.getParameter("nazwa"+i));
            pzi.setJednostka_miary(request.getParameter("jednostka"+i));
            pzi.setIlosc(Integer.parseInt(request.getParameter("ilosc"+i)));
            pzi.setKwota_przeznaczona_na_real(Double.parseDouble(request.getParameter("kwota"+i)));
            pzi.setPozycja_w_planie_zam_jedn(Integer.parseInt(request.getParameter("pozycja"+i)));
            pzi.setPrzedmiot_zamowienia_ID(przedmiotZamowienia.getPrzedmiot_zamowienia_id());
            
            session.save(pzi);
            
        }
        
        //System.out.println(wniosek.getWniosek_ID());
        
        
        session.flush();
        tx.commit();
        session.close();
        
        
        
        wniosek = new Wniosek();
    }
    
    public List<Wniosek> mojeWnioski()
    {
        
        Session session = ConnectionFactory.getSessionFactory().openSession();
        String login_zalogowanego = UserController.getUserName();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", login_zalogowanego));
        List<Users> result = cr.list();
        String query = "FROM Wniosek WHERE Osoba_wnioskodawcaID=" + result.get(0).getUser_id() + 
                "OR Kierownik_dzialu_naukID=" + result.get(0).getUser_id() + 
                "OR Kierownik_BRPM_BWM_ID=" + result.get(0).getUser_id() +
                "OR Kwestor_ID="+ result.get(0).getUser_id() +
                "OR Szef_pionuID="+ result.get(0).getUser_id() +
                "OR Osoba_przyjmujaca_wniosek_ID="+ result.get(0).getUser_id() +
                "OR Kierownik_dzialu_zam_pub_ID="+ result.get(0).getUser_id() +
                "OR Pelnomocnik_rektora_ID="+ result.get(0).getUser_id();
        
        
	wnioski = session.createQuery(query).list();
        session.close();
        
        return wnioski;
        
    }
    
    public String zobacz(Wniosek w)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        
        String login_zalogowanego = UserController.getUserName();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", login_zalogowanego));
        List<Users> result = cr.list();
        
        String query1 = "FROM Przedmiot_zamowienia WHERE Wniosek_ID="+w.getWniosek_ID();
        String query = "FROM Przedmiot_zamowienia_item WHERE Przedmiot_zamowienia_ID IN (SELECT Przedmiot_zamowienia_id FROM Przedmiot_zamowienia WHERE Wniosek_ID="+w.getWniosek_ID()+")";
	listaPrzedmiotowZamowienia = session.createQuery(query).list();
        przedmiot_zamowienia = (Przedmiot_zamowienia)session.createQuery(query1).list().get(0);
        
        NawigacjaZatwierdzanieWnioskow nawigacja = new NawigacjaZatwierdzanieWnioskow();
        
        session.close();
        this.wniosekView = w;
        return nawigacja.getNawigacjaFromRole(result.get(0).getRola());
    }
    
    public String wnioskiDoAkceptacji()
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        
        String login_zalogowanego = UserController.getUserName();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", login_zalogowanego));
        List<Users> result = cr.list();
        
        
        MaszynaStanow ms = new MaszynaStanow();
        String stan = ms.getStanFromRole(result.get(0).getRola());
        System.out.println(stan);
        if(stan !=null) wnioski = session.createQuery("FROM Wniosek WHERE Stan='"+stan+"'").list(); //jak stan===null to znaczy że to jest jakiś wnioskodawca czy jakas osoba ktora nie moze akceptowac wnioskow
        else
        {
            wnioski = null;
            return "brakWnioskowDoAkceptacji";
        }
        
        session.close();
        
        if(wnioski.isEmpty()) return "brakWnioskowDoAkceptacji";
        return "wnioskiDoAkceptacji";
    }
    
    public List<Uwagi> uwagiDoWniosku()
    {
        UwagiController u = new UwagiController();
        return u.UwagiDoWniosku(wniosekView.getWniosek_ID());
    }
    
    public String Podglad(Wniosek w)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        
        String query1 = "FROM Przedmiot_zamowienia WHERE Wniosek_ID="+w.getWniosek_ID();
        String query = "FROM Przedmiot_zamowienia_item WHERE Przedmiot_zamowienia_ID IN (SELECT Przedmiot_zamowienia_id FROM Przedmiot_zamowienia WHERE Wniosek_ID="+w.getWniosek_ID()+")";
	listaPrzedmiotowZamowienia = session.createQuery(query).list();
        przedmiot_zamowienia = (Przedmiot_zamowienia)session.createQuery(query1).list().get(0);
        session.close();
        
        this.wniosekView = w;
        return "podgladWniosku";
    }
    
    public void delete(Wniosek w)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(w);
        tx.commit();
        session.close();
    }
    
    public String edit(Wniosek w)
    {
        this.wniosekView = w;
        return "edytujWniosek";
    }
    
    public String edit()
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(wniosekView);
        tx.commit();
        session.close();
        wniosek = new Wniosek();
        return "mojeWnioski";
    }
    
    public String Zatwierdz(String from)
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                         .getExternalContext().getRequest();
        
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String login_zalogowanego = UserController.getUserName();
        
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", login_zalogowanego));
        List<Users> result = cr.list();
        
        if(from.equals("zobaczWniosekKwestor"))
        {
            wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), null));
            wniosekView.setKontrasygnata_data(new Date());
            wniosekView.setKwestor_ID(result.get(0).getUser_id());
        }
        else if(from.equals("zobaczWniosekDzialNauk"))
        {
            wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), null));
            wniosekView.setPotwierdzenie_pokrycia_fin_ze_srodkow_data(new Date());
            wniosekView.setKierownik_dzialu_naukID(result.get(0).getUser_id());
            
        }
        else if(from.equals("zobaczWniosekKBRIPM"))
        {
            wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), null));
            wniosekView.setPotwierdzenie_zgodnosci_budzet_data(new Date());
            wniosekView.setKierownik_BRPM_BWM_ID(result.get(0).getUser_id());
            
        }
        else if(from.equals("zobaczWniosekSzefPionu"))
        {
            wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), null));
            wniosekView.setSzef_pionuID(result.get(0).getUser_id());
            
        }
        else if(from.equals("zobaczWniosekDZP"))
        {
            wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), null));
            wniosekView.setData_zlozenia_w_dziale_zam_pub(new Date());
            wniosekView.setOsoba_przyjmujaca_wniosek_ID(result.get(0).getUser_id());
            
            przedmiot_zamowienia.setOsoba_opiniujaca_tryb_udzielania_zam_ID(result.get(0).getUser_id());
            session.update(przedmiot_zamowienia);
            
            int i=1;
            for(Przedmiot_zamowienia_item pzi : listaPrzedmiotowZamowienia)
            {
                pzi.setOpinia_dot_trybu_udzielania_zam(request.getParameter("opinia"+i));
                session.update(pzi);
                i++;
            }
            
            
        }
        else if(from.equals("zobaczWniosekPelnomocnikRektora"))
        {
            wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), null));
            wniosekView.setPelnomocnik_rektora_ID(result.get(0).getUser_id());
            przedmiot_zamowienia.setPelnomocnik_rektora_ID(result.get(0).getUser_id());
            session.update(przedmiot_zamowienia);
            
        }
        
        session.update(wniosekView);
        session.flush();
        tx.commit();
        session.close();
        
        return "wnioskiDoAkceptacji";
        
//        if(!uwaga.getTresc().equals(""))
//        {
//            Session session = ConnectionFactory.getSessionFactory().openSession();
//            Transaction tx = session.beginTransaction();
//            uwaga.setWniosek_id(wniosekView.getWniosek_ID());
//            String login_zalogowanego = UserController.getUserName();
//            Criteria cr = session.createCriteria(Users.class);
//            cr.add(Restrictions.ilike("login", login_zalogowanego));
//            List<Users> result = cr.list();
//            uwaga.setUser_id(result.get(0).getUser_id());
//            session.save(uwaga);
//            tx.commit();
//            session.close();
//        }
//        uwaga = new Uwagi();
        
    }
    
    public String Odrzuc(String from)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        wniosekView.setStan(MaszynaStanow.getNextState(wniosekView.getStan(), Event.odrzuć));
        
        session.update(wniosekView);
        session.flush();
        tx.commit();
        session.close();
        
        
        
        
//        if(!uwaga.getTresc().equals(""))
//        {
//            Session session = ConnectionFactory.getSessionFactory().openSession();
//            Transaction tx = session.beginTransaction();
//            uwaga.setWniosek_id(wniosekView.getWniosek_ID());
//            String login_zalogowanego = UserController.getUserName();
//            Criteria cr = session.createCriteria(Users.class);
//            cr.add(Restrictions.ilike("login", login_zalogowanego));
//            List<Users> result = cr.list();
//            uwaga.setUser_id(result.get(0).getUser_id());
//            session.save(uwaga);
//            tx.commit();
//            session.close();
//        }
//        uwaga = new Uwagi();
//        return "wnioskiDoAkceptacji";


        return "wnioskiDoAkceptacji";
    }
    
    
    public String getImieNazwiskoByUserID(int id)
    {
        String imieNazwisko = "";
        Session session = ConnectionFactory.getSessionFactory().openSession();
        
        String query = "FROM Users WHERE user_id=" + id;
        try
        {
            Users user = (Users)session.createQuery(query).list().get(0);
            imieNazwisko = user.getImie() + " "+ user.getNazwisko();
        }
        catch(Exception e)
        {
            
        }
        
        
        return imieNazwisko;
        
    }

    
}
