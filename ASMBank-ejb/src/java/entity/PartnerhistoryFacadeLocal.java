/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo
 */
@Local
public interface PartnerhistoryFacadeLocal {

    void create(Partnerhistory partnerhistory);

    void edit(Partnerhistory partnerhistory);

    void remove(Partnerhistory partnerhistory);

    Partnerhistory find(Object id);

    List<Partnerhistory> findAll();

    List<Partnerhistory> findRange(int[] range);

    int count();
    
}
