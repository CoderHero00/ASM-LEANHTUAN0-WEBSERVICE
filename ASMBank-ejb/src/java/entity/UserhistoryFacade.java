/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class UserhistoryFacade extends AbstractFacade<Userhistory> implements UserhistoryFacadeLocal {

    @PersistenceContext(unitName = "ASMBank-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserhistoryFacade() {
        super(Userhistory.class);
    }
    
}
