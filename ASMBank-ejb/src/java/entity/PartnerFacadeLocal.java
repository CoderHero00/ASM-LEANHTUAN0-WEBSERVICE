/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface PartnerFacadeLocal {

    void create(Partner partner);

    void edit(Partner partner);

    void remove(Partner partner);

    Partner find(Object id);
    
    double fee(double money);
    
    double moneypaid(double money, double fee, int type);

    boolean Payemnt(double money, String code, String pin, String ClientID, int payer, String TranName);
    
    Partner CheckPartner(String id, String Password);
    
    String returnCode(String id, String password);
    
    Bclient CheckClient (String id, String pin);
    
    List<String>PartnerHistory(String id, String password, Date StartD, Date EndD);
    
    List<String>UserHistory(String pin, String id,Date StartD, Date EndD);
    
    List<Partner> findAll();

    List<Partner> findRange(int[] range);

    int count();
    
}
