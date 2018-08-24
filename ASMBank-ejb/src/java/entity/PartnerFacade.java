/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lenovo
 */
@Stateless
public class PartnerFacade extends AbstractFacade<Partner> implements PartnerFacadeLocal {

    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

    @PersistenceContext(unitName = "ASMBank-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartnerFacade() {
        super(Partner.class);
    }

    @Override
    public Partner CheckPartner(String id, String Password) {
        Query query = em.createNamedQuery("Partner.findByAccount");
        query.setParameter("partnerid", id);
        query.setParameter("partnerpassword", Password);
        try{
           return  (Partner)query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean Payemnt(double money, String code, String pin, String ClientID, int payer, String TranName){
        Query query = em.createNamedQuery("Partner.findByPartneruid");
        query.setParameter("partneruid", code);
        Partner selectedPa = (Partner)query.getSingleResult();
        String id=selectedPa.getPartnerid();
        String Password=selectedPa.getPartnerpassword();
        if(CheckPartner(id,Password) != null && CheckClient(ClientID, pin) != null ){
            double TransactionFee = fee(money);
            double moneyPaid = moneypaid(money, TransactionFee,payer);
            Date date = new Date();
            if(payer == 1){
                Partner partner = em.find(Partner.class, id);
                Bclient Client = em.find(Bclient.class, ClientID);
                Partnerhistory paHis = new Partnerhistory(TranName,money,TransactionFee,date,partner);
                Userhistory UHis = new Userhistory(TranName,(0 - money),0.0,date,Client);
                em.persist(paHis);
                em.persist(UHis);
                partner.setPmoney(partner.getPmoney() + moneyPaid);
                Client.setBcmoney(Client.getBcmoney() - money);
                return true;
            }else if(payer == 0){
                Partner partner = em.find(Partner.class, id);
                Bclient Client = em.find(Bclient.class, ClientID);
                Partnerhistory paHis = new Partnerhistory(TranName,money,0.0,date,partner);
                Userhistory UHis = new Userhistory(TranName,(0 - money),TransactionFee,date,Client);
                em.persist(paHis);
                em.persist(UHis);
                partner.setPmoney(partner.getPmoney() + money);
                Client.setBcmoney(Client.getBcmoney() - moneyPaid);
                return true;
            }
        }
        return false;
    }

    @Override
    public double fee(double money) {
        if(money <= 100){
            return 10;
        }else if(money <= 500 && money > 100){
            return money*0.02;
        }else if(money <= 1000 && money > 500){
            return money*0.015;
        }else if(money <= 5000 && money > 1000){
            return money*0.01;
        }else{
            return money*0.005;
        }
    }

    @Override
    public double moneypaid(double money, double fee, int type) {
        if(type == 1){
            return money - fee;
        }else{
            return money + fee;
        }
    }
    
    @Override
    public Bclient CheckClient(String id, String pin) {
        Query query = em.createNamedQuery("Bclient.findByBclient");
        query.setParameter("bclientid", id);
        query.setParameter("pinc", pin);
        
        try{
           return (Bclient)query.getSingleResult();
        }catch(Exception e){
            System.out.print(e);
            return null;
        }
    }

    @Override
    public String returnCode(String id, String password) {
        Partner part = new Partner();
        part = CheckPartner(id,password);
        return part.getPartneruid();
    }

    @Override
    public List<String> PartnerHistory(String id, String password, Date StartD, Date EndD) {
        List<String> HistoryList = new ArrayList();
        if(CheckPartner(id, password) != null){
            Partner part = new Partner();
            part = CheckPartner(id,password);
            List<Partnerhistory> partnerList = new ArrayList(part.getPartnerhistoryCollection());
            for(Partnerhistory x : partnerList){
                if(x.getTdate().getTime() >= StartD.getTime() && x.getTdate().getTime() <= EndD.getTime()){
                    HistoryList.add(x.getTransid()+" "+x.getTransname()+ " "+x.getTransmoney()+" "+x.getTransfee()+" "+ sdfDate.format(x.getTdate()).toString());
                }
            }
        }
        return HistoryList;
    }

    @Override
    public List<String> UserHistory(String pin, String id, Date StartD, Date EndD) {
        List<String> HistoryList = new ArrayList();
        if(CheckClient(id, pin) != null){
            Bclient clie = CheckClient(id,pin);
            List<Userhistory> userList = new ArrayList(clie.getUserhistoryCollection());
            for(Userhistory x : userList){
                if(x.getUdate().getTime() >= StartD.getTime() && x.getUdate().getTime() <= EndD.getTime()){
                    HistoryList.add(x.getUserid()+" "+x.getUsername()+ " "+x.getUsermoney()+" "+x.getUserfee()+" "+ sdfDate.format(x.getUdate()).toString());
                }
            }
        }
        return HistoryList;
    }
}
