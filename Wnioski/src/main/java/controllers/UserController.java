/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hibernate.connection.factory.ConnectionFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;



public class UserController implements Serializable{
    
    private Users user = new Users();
    private String rola;
    private String haslo2;
    private List<Users> uzytkownicy;
    private Boolean czyAdmin = false;

    public Boolean getCzyAdmin() {
        return czyAdmin;
    }

    public void setCzyAdmin(Boolean czyAdmin) {
        this.czyAdmin = czyAdmin;
    }

    public List<Users> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(List<Users> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public String getHaslo2() {
        return haslo2;
    }

    public void setHaslo2(String haslo2) {
        this.haslo2 = haslo2;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public UserController() {
    }
    
    public void addUser(){
        Session session = ConnectionFactory.getSessionFactory().openSession();
        List<Users> usersList = session.createQuery("from Users").list();
        Boolean czyIstnieje = false;
        for(Users u : usersList)
        {
            if(user.getEmail().equals(u.getEmail()))
            {
                czyIstnieje = true;
                break;
            }
            if(user.getLogin().equals(u.getLogin()))
            {
                czyIstnieje = true;
                break;
            }
        }
        Transaction tx = session.beginTransaction();
        FacesMessage msg;
        if(czyIstnieje)
        {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Podany użytkownik już istnieje!", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else{
            if(!user.getHaslo().equals(haslo2)){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Podane hasła się różnią!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else if(user.getRola() == null){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Rola nie została wybrana!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else if(user.getEmail() == null){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nie podano adresu Email!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else if(user.getLogin() == null){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nie podano loginu!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else if(user.getHaslo() == null){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nie podano hasła!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else if(user.getImie() == null){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nie podano imienia!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else if(user.getNazwisko() == null){
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nie podano nazwiska!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            else{

                session.save(user);
                session.flush();
                tx.commit();
                user = new Users();
                SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Użytkownik został dodany!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        session.close();
    }
    
    public String getUserRole()
    {
        String user_login = getUserName();
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", user_login));
        List<Users> result = cr.list();
        
        return result.get(0).getRola();
    }
    
    
    public String uprawnieniaAdmin()
    {
        String user_login = getUserName();
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.ilike("login", user_login));
        List<Users> result = cr.list();
        String query = "FROM Users WHERE user_id=" + result.get(0).getUser_id();
	List<Users> user = session.createQuery(query).list();
        if(user.get(0).getRola().equals("Admin")){
            session.close();
            czyAdmin = true;
            return "uzytkownicy";
        }
        else
        {
            czyAdmin = false;
            session.close();
            return "brakUprawnien";
        }
    }
    
    public List<Users> listaUzytkownikow()
    {
        if(czyAdmin)
        {
            Session session = ConnectionFactory.getSessionFactory().openSession();
            uzytkownicy = session.createQuery("FROM Users").list();
            session.close();
            return uzytkownicy;
        }
        else
        {
            List<Users> pusta = null;
            return pusta;
        }
    }
    
    public String Edit(Users u)
    {
        this.user = u;
        return "edytujUzytkownika";
    }
    
    public String Edit()
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
        user = new Users();
        return "uzytkownicy";
    }
    
    public void Delete(Users u)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(u);
        tx.commit();
        session.close();
    }
    
    public static String getUserName()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if(principal instanceof UserDetails)
        {
            return ((UserDetails) principal).getUsername();
        }
        
        return principal.toString();
    }
    
    
    
    public void Logout() throws IOException
    {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if(auth != null)
        {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            response.sendRedirect("index.xhtml");
        }
    }
    
}
