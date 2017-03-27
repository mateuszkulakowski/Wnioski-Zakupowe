
package controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import stany.wniosku.Stan;

/**
 *
 * @author Patryk
 */
public class RolaController implements Serializable{
    
    private String rola;  
    private Map<String,String> role;
    
    
    @PostConstruct
    public void init() {
        role = new HashMap<String, String>();
        role.put("Admin", "Admin");
        role.put("Kwestor", "Kwestor");
        role.put("Kierownik działu nauk", "Kierownik_dzialu_nauk");
        role.put("Kierownik KBRIPM", "Kierownik_KBRIPM");
        role.put("Szef pionu", "Szef_pionu");
        role.put("Dziekan", "Dziekan");
        role.put("Prodziekan", "Prodziekan");
        role.put("Pracownik DZP", "Pracownik_DZP");
        role.put("Pełnomocnik rektora", "Pelnomocnik_rektora");
        role.put("Rektor", "Rektor");
        role.put("Wnioskodawca", "Wnioskodawca");
    }
    
    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public Map<String, String> getRole() {
        return role;
    }

    public void setRole(Map<String, String> role) {
        this.role = role;
    }
}
