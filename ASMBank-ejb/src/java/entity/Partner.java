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
@Table(name = "PARTNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p")
    , @NamedQuery(name = "Partner.findByPartnerid", query = "SELECT p FROM Partner p WHERE p.partnerid = :partnerid")
    , @NamedQuery(name = "Partner.findByPartnerpassword", query = "SELECT p FROM Partner p WHERE p.partnerpassword = :partnerpassword")
    , @NamedQuery(name = "Partner.findByPmoney", query = "SELECT p FROM Partner p WHERE p.pmoney = :pmoney")
    , @NamedQuery(name = "Partner.findByPartneruid", query = "SELECT p FROM Partner p WHERE p.partneruid = :partneruid")
    , @NamedQuery(name = "Partner.findByAccount", query = "SELECT p FROM Partner p WHERE p.partnerid = :partnerid AND p.partnerpassword = :partnerpassword")})
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PARTNERID")
    private String partnerid;
    @Size(max = 100)
    @Column(name = "PARTNERPASSWORD")
    private String partnerpassword;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PMONEY")
    private Double pmoney;
    @Size(max = 100)
    @Column(name = "PARTNERUID")
    private String partneruid;
    @OneToMany(mappedBy = "tpartnerid", fetch = FetchType.EAGER)
    private Collection<Partnerhistory> partnerhistoryCollection;

    public Partner() {
    }

    public Partner(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnerpassword() {
        return partnerpassword;
    }

    public void setPartnerpassword(String partnerpassword) {
        this.partnerpassword = partnerpassword;
    }

    public Double getPmoney() {
        return pmoney;
    }

    public void setPmoney(Double pmoney) {
        this.pmoney = pmoney;
    }

    public String getPartneruid() {
        return partneruid;
    }

    public void setPartneruid(String partneruid) {
        this.partneruid = partneruid;
    }

    @XmlTransient
    public Collection<Partnerhistory> getPartnerhistoryCollection() {
        return partnerhistoryCollection;
    }

    public void setPartnerhistoryCollection(Collection<Partnerhistory> partnerhistoryCollection) {
        this.partnerhistoryCollection = partnerhistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partnerid != null ? partnerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.partnerid == null && other.partnerid != null) || (this.partnerid != null && !this.partnerid.equals(other.partnerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Partner[ partnerid=" + partnerid + " ]";
    }
    
}
