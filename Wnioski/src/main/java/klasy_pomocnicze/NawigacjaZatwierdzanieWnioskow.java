/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasy_pomocnicze;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mateusz
 */
public class NawigacjaZatwierdzanieWnioskow {
    
    private Map<String,String> RolaStrona;
    
    public NawigacjaZatwierdzanieWnioskow()
    {
        RolaStrona = new HashMap<String, String>(); // mapa z rolami i stronami do których trzeba przekierować użytkownika
        RolaStrona.put("Admin", "zobaczWniosek"); //strona zobaczWniosek gdzie można tylko podejrzeć wniosek
        RolaStrona.put("Kwestor", "zobaczWniosekKwestor");
        RolaStrona.put("Kierownik_dzialu_nauk", "zobaczWniosekDzialNauk");
        RolaStrona.put("Kierownik_KBRIPM", "zobaczWniosekKBRIPM");
        RolaStrona.put("Szef_pionu", "zobaczWniosekSzefPionu");
        RolaStrona.put("Dziekan", "zobaczWniosek");
        RolaStrona.put("Prodziekan", "zobaczWniosek");
        RolaStrona.put("Pracownik_DZP", "zobaczWniosekDZP");
        RolaStrona.put("Pelnomocnik_rektora", "zobaczWniosekPelnomocnikRektora");
        RolaStrona.put("Rektor", "zobaczWniosek");
        RolaStrona.put("Wnioskodawca", "zobaczWniosek");
    }
    
    
    public String getNawigacjaFromRole(String rola)
    {
        return RolaStrona.getOrDefault(rola, "zobaczWniosek");
        
    }
    
}
