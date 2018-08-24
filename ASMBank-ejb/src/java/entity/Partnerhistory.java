/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "PARTNERHISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partnerhistory.findAll", query = "SELECT p FROM Partnerhistory p")
    , @NamedQuery(name = "Partnerhistory.findByTransid", query = "SELECT p FROM Partnerhistory p WHERE p.transid = :transid")
    , @NamedQuery(name = "Partnerhistory.findByTransname", query = "SELECT p FROM Partnerhistory p WHERE p.transname = :transname")
    , @NamedQuery(name = "Partnerhistory.findByTransmoney", query = "SELECT p FROM Partnerhistory p WHERE p.transmoney = :transmoney")
    , @NamedQuery(name = "Partnerhistory.findByTransfee", query = "SELECT p FROM Partnerhistory p WHERE p.transfee = :transfee")
    , @NamedQuery(name = "Partnerhistory.findByTdate", query = "SELECT p FROM Partnerhistory p WHERE p.tdate = :tdate")})
public class Partnerhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANSID")
    private Integer transid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TRANSNAME")
    private String transname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TRANSMONEY")
    private Double transmoney;
    @Column(name = "TRANSFEE")
    private Double transfee;
    @Column(name = "TDATE")
    @Temporal(TemporalType.DATE)
    private Date tdate;
    @JoinColumn(name = "TPARTNERID", referencedColumnName = "PARTNERID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Partner tpartnerid;

    public Partnerhistory() {
    }

    public Partnerhistory(Integer transid) {
        this.transid = transid;
    }

    public Partnerhistory(Integer transid, String transname) {
        this.transid = transid;
        this.transname = transname;
    }

    public Partnerhistory( String transname, Double transmoney, Double transfee, Date tdate, Partner tpartnerid) {
        this.transname = transname;
        this.transmoney = transmoney;
        this.transfee = transfee;
        this.tdate = tdate;
        this.tpartnerid = tpartnerid;
    }
    
    
    public Integer getTransid() {
        return transid;
    }

    public void setTransid(Integer transid) {
        this.transid = transid;
    }

    public String getTransname() {
        return transname;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public Double getTransmoney() {
        return transmoney;
    }

    public void setTransmoney(Double transmoney) {
        this.transmoney = transmoney;
    }

    public Double getTransfee() {
        return transfee;
    }

    public void setTransfee(Double transfee) {
        this.transfee = transfee;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public Partner getTpartnerid() {
        return tpartnerid;
    }

    public void setTpartnerid(Partner tpartnerid) {
        this.tpartnerid = tpartnerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transid != null ? transid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partnerhistory)) {
            return false;
        }
        Partnerhistory other = (Partnerhistory) object;
        if ((this.transid == null && other.transid != null) || (this.transid != null && !this.transid.equals(other.transid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Partnerhistory[ transid=" + transid + " ]";
    }
    
}
