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
public interface UserhistoryFacadeLocal {

    void create(Userhistory userhistory);

    void edit(Userhistory userhistory);

    void remove(Userhistory userhistory);

    Userhistory find(Object id);

    List<Userhistory> findAll();

    List<Userhistory> findRange(int[] range);

    int count();
    
}
