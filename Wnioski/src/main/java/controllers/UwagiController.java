
package controllers;

import hibernate.connection.factory.ConnectionFactory;
import java.io.Serializable;
import java.util.List;
import models.Users;
import models.Uwagi;
import models.Wniosek;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patryk
 */
public class UwagiController implements Serializable {
    
    private Uwagi uwaga = new Uwagi();
    private Wniosek wn = new Wniosek();
    private List<Uwagi> uwagi;

    public List<Uwagi> getUwagi() {
        return uwagi;
    }

    public void setUwagi(List<Uwagi> uwagi) {
        this.uwagi = uwagi;
    }

    public Wniosek getWn() {
        return wn;
    }

    public void setWn(Wniosek wn) {
        this.wn = wn;
    }
    
    public UwagiController(){
    }

    public Uwagi getUwaga() {
        return uwaga;
    }

    public void setUwaga(Uwagi uwaga) {
        this.uwaga = uwaga;
    }
    
    public List<Uwagi> UwagiDoWniosku(int wniosek_id)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        String query = "FROM Uwagi WHERE wniosek_id=" + wniosek_id;
	uwagi = session.createQuery(query).list();
        int user_id;
        List<Users> user;
        for(Uwagi u : uwagi)
        {
            user_id = u.getUser_id();
            String query2 = "FROM Users WHERE user_id=" + user_id;
            user = session.createQuery(query2).list();
            if(user != null)
            {
                u.setImie(user.get(0).getImie());
                u.setNazwisko(user.get(0).getNazwisko());
                u.setRola(user.get(0).getRola());
            }
        }
        session.close();
        return uwagi;
    }
    
    public void Delete(Uwagi u)
    {
        Session session = ConnectionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(u);
        tx.commit();
        session.close();
    }
}
