/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.connection.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public abstract class ConnectionFactory {
    
    private static SessionFactory sf;
    
    
    public static SessionFactory getSessionFactory()
    {
        if(sf==null)
        {
            Configuration c = new Configuration();
            c.configure("hibernate/configuration/hibernate.cfg.xml");
        
            sf = c.buildSessionFactory();
            
        }
        
        return sf;
    }
    
}
