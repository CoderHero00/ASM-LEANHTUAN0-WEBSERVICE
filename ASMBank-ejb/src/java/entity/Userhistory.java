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
@Table(name = "USERHISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userhistory.findAll", query = "SELECT u FROM Userhistory u")
    , @NamedQuery(name = "Userhistory.findByUserid", query = "SELECT u FROM Userhistory u WHERE u.userid = :userid")
    , @NamedQuery(name = "Userhistory.findByUsername", query = "SELECT u FROM Userhistory u WHERE u.username = :username")
    , @NamedQuery(name = "Userhistory.findByUsermoney", query = "SELECT u FROM Userhistory u WHERE u.usermoney = :usermoney")
    , @NamedQuery(name = "Userhistory.findByUserfee", query = "SELECT u FROM Userhistory u WHERE u.userfee = :userfee")
    , @NamedQuery(name = "Userhistory.findByUdate", query = "SELECT u FROM Userhistory u WHERE u.udate = :udate")})
public class Userhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "USERNAME")
    private String username;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "USERMONEY")
    private Double usermoney;
    @Column(name = "USERFEE")
    private Double userfee;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @JoinColumn(name = "UCLIENTID", referencedColumnName = "BCLIENTID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bclient uclientid;

    public Userhistory() {
    }

    public Userhistory(Integer userid) {
        this.userid = userid;
    }

    public Userhistory(Integer userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public Userhistory( String username, Double usermoney, Double userfee, Date udate, Bclient uclientid) {
        this.username = username;
        this.usermoney = usermoney;
        this.userfee = userfee;
        this.udate = udate;
        this.uclientid = uclientid;
    }
    
    

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(Double usermoney) {
        this.usermoney = usermoney;
    }

    public Double getUserfee() {
        return userfee;
    }

    public void setUserfee(Double userfee) {
        this.userfee = userfee;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public Bclient getUclientid() {
        return uclientid;
    }

    public void setUclientid(Bclient uclientid) {
        this.uclientid = uclientid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userhistory)) {
            return false;
        }
        Userhistory other = (Userhistory) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Userhistory[ userid=" + userid + " ]";
    }
    
}
