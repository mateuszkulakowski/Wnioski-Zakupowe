/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stany.wniosku;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mateusz
 */
public class MaszynaStanow {
    
    private Map<String,String> role;
    
    
    private void initRole()
    {
        role = new HashMap<String, String>(); // mapa z rolami i stanami które mogą obsługiwać
        role.put("Admin", null); 
        role.put("Kwestor", Stan.przekazanyKwestorowi);
        role.put("Kierownik_dzialu_nauk", Stan.przekazanyDzialowiNauk);
        role.put("Kierownik_KBRIPM", Stan.przekazanyKBRPIM);
        role.put("Szef_pionu", Stan.przekazanyDoZatwierdzeniaSzefowiPionu);
        role.put("Dziekan", null);
        role.put("Prodziekan", null);
        role.put("Pracownik_DZP", Stan.przekazanyDoDZP);
        role.put("Pelnomocnik_rektora", Stan.przekazanyDoZatwierdzaniaPełnomocnikowiRektora);
        role.put("Rektor", Stan.przekazanyDoZatwierdzaniaPełnomocnikowiRektora);
        role.put("Wnioskodawca", null);
    }
    
    
    public static String getNextState(String akt_state, String event)
    {
        String next_state = "";
        
        if(akt_state == null) // jak nie ma ustawionego aktualnego stanu wybieramy jeden z pierwszych stanów w zależności od kliknietego przycisku
        {
            if(event.equals(Event.przekażDziałNauk))
            {
                next_state = Stan.przekazanyDzialowiNauk;
            }
            else if(event.equals(Event.przekażKBRPIM))
            {
                next_state = Stan.przekazanyKBRPIM;            
            }
            else if(event.equals(Event.przekażKwestorowi))
            {
                next_state = Stan.przekazanyKwestorowi;
            }
            else next_state = akt_state;// jak nie pasuje nie zmieniamy stanu
        }
        else
        {
            if(event == null) // jak event jest pusty więc chcemy zamienić stan na kolejny
            {
                if(akt_state.equals(Stan.przekazanyKBRPIM))
                {
                    next_state = Stan.przekazanyKwestorowi;
                }
                else if(akt_state.equals(Stan.przekazanyDzialowiNauk))
                {
                    next_state = Stan.przekazanyDoZatwierdzeniaSzefowiPionu;
                }
                else if(akt_state.equals(Stan.przekazanyKwestorowi))
                {
                    next_state = Stan.przekazanyDoZatwierdzeniaSzefowiPionu;
                }
                else if(akt_state.equals(Stan.przekazanyDoZatwierdzeniaSzefowiPionu))
                {
                    next_state = Stan.przekazanyDoDZP;
                }
                else if(akt_state.equals(Stan.przekazanyDoDZP))
                {
                    next_state = Stan.przekazanyDoZatwierdzaniaPełnomocnikowiRektora;
                }
                else if(akt_state.equals(Stan.przekazanyDoZatwierdzaniaPełnomocnikowiRektora))
                {
                    next_state = Stan.zaakceptowanyPełnomocnikRektora;
                }
                else next_state = akt_state; // jak nie pasuje nie zmieniamy stanu
                
            }
            else //gdy event jest ustawiony na odrzucenie wniosku
            {
                if(event.equals(Event.odrzuć))
                {
                    next_state = Stan.odrzucony;
                }
                else next_state = akt_state;// jak nie pasuje nie zmieniamy stanu
            }
        }
        
        return next_state;
    }
    
    
    
    public String getStanFromRole(String rola)
    {
        if(role == null)initRole();
        
        
        String stan = role.getOrDefault(rola,null); // zwracamy stan który może obsłużyć dany użytkownik
        
        
        
        
        return stan;
    }
}
