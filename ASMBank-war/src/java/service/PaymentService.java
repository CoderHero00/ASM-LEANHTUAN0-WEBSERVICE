/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.PartnerFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lenovo
 */
@WebService(serviceName = "PaymentService")
public class PaymentService {

    @EJB
    private PartnerFacadeLocal partnerFacade;

    
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "payment")
    public boolean payment(@WebParam(name = "Money") double money, @WebParam(name = "Code") String code, @WebParam(name = "PIN") String pin, @WebParam(name = "ClientID") String CID,@WebParam(name = "payer") int payer, @WebParam(name = "TranName") String TranName) {
        return partnerFacade.Payemnt(money, code, pin, CID, payer, TranName);
    }
    
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "id") String id, @WebParam(name = "password") String password) {
        return partnerFacade.returnCode(id, password);
    }
    
    @WebMethod(operationName = "PHistory")
    public List<String> PHistory(@WebParam(name = "id") String id, @WebParam(name = "password") String password,@WebParam(name = "SDate") Date Sdate,@WebParam(name = "EDate") Date Edate) {
        return partnerFacade.PartnerHistory(id, password, Sdate, Edate);
    }
    
    @WebMethod(operationName = "UHistory")
    public List<String> UHistory(@WebParam(name = "pin") String pin, @WebParam(name = "id") String id ,@WebParam(name = "SDate") Date Sdate,@WebParam(name = "EDate") Date Edate) {
        return partnerFacade.UserHistory(pin, id, Sdate, Edate);
    }
}
