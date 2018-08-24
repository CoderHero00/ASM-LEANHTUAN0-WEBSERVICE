/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "BCLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bclient.findAll", query = "SELECT b FROM Bclient b")
    , @NamedQuery(name = "Bclient.findByBclientid", query = "SELECT b FROM Bclient b WHERE b.bclientid = :bclientid")
    , @NamedQuery(name = "Bclient.findByPinc", query = "SELECT b FROM Bclient b WHERE b.pinc = :pinc")
    , @NamedQuery(name = "Bclient.findByBcmoney", query = "SELECT b FROM Bclient b WHERE b.bcmoney = :bcmoney")
    , @NamedQuery(name = "Bclient.findByBclient", query = "SELECT b FROM Bclient b WHERE b.pinc = :pinc AND b.bclientid = :bclientid")})
public class Bclient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BCLIENTID")
    private String bclientid;
    @Size(max = 11)
    @Column(name = "PINC")
    private String pinc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BCMONEY")
    private Double bcmoney;
    @OneToMany(mappedBy = "uclientid", fetch = FetchType.EAGER)
    private Collection<Userhistory> userhistoryCollection;

    public Bclient() {
    }

    public Bclient(String bclientid) {
        this.bclientid = bclientid;
    }

    public String getBclientid() {
        return bclientid;
    }

    public void setBclientid(String bclientid) {
        this.bclientid = bclientid;
    }

    public String getPinc() {
        return pinc;
    }

    public void setPinc(String pinc) {
        this.pinc = pinc;
    }

    public Double getBcmoney() {
        return bcmoney;
    }

    public void setBcmoney(Double bcmoney) {
        this.bcmoney = bcmoney;
    }

    @XmlTransient
    public Collection<Userhistory> getUserhistoryCollection() {
        return userhistoryCollection;
    }

    public void setUserhistoryCollection(Collection<Userhistory> userhistoryCollection) {
        this.userhistoryCollection = userhistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bclientid != null ? bclientid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bclient)) {
            return false;
        }
        Bclient other = (Bclient) object;
        if ((this.bclientid == null && other.bclientid != null) || (this.bclientid != null && !this.bclientid.equals(other.bclientid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bclient[ bclientid=" + bclientid + " ]";
    }
    
}
