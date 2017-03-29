/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mazhar
 */
@Entity
@Table(name = "mailingaddress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mailingaddress.findAll", query = "SELECT m FROM Mailingaddress m"),
    @NamedQuery(name = "Mailingaddress.findByMailingid", query = "SELECT m FROM Mailingaddress m WHERE m.mailingid = :mailingid")})
public class Mailingaddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mailingid")
    private Integer mailingid;
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Addresses addressid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailingaddressid")
    private Collection<Customers> customersCollection;

    public Mailingaddress() {
    }

    public Mailingaddress(Integer mailingid) {
        this.mailingid = mailingid;
    }

    public Integer getMailingid() {
        return mailingid;
    }

    public void setMailingid(Integer mailingid) {
        this.mailingid = mailingid;
    }

    public Addresses getAddressid() {
        return addressid;
    }

    public void setAddressid(Addresses addressid) {
        this.addressid = addressid;
    }

    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailingid != null ? mailingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mailingaddress)) {
            return false;
        }
        Mailingaddress other = (Mailingaddress) object;
        if ((this.mailingid == null && other.mailingid != null) || (this.mailingid != null && !this.mailingid.equals(other.mailingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Mailingaddress[ mailingid=" + mailingid + " ]";
    }
    
}
