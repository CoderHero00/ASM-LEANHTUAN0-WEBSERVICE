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
public interface BclientFacadeLocal {

    void create(Bclient bclient);

    void edit(Bclient bclient);

    void remove(Bclient bclient);

    Bclient find(Object id);

    List<Bclient> findAll();

    List<Bclient> findRange(int[] range);

    int count();
    
}
