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
@Table(name = "billingaddress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billingaddress.findAll", query = "SELECT b FROM Billingaddress b"),
    @NamedQuery(name = "Billingaddress.findByBillingid", query = "SELECT b FROM Billingaddress b WHERE b.billingid = :billingid")})
public class Billingaddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "billingid")
    private Integer billingid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingaddressid")
    private Collection<Customercards> customercardsCollection;
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Addresses addressid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingaddressid")
    private Collection<Customers> customersCollection;

    public Billingaddress() {
    }

    public Billingaddress(Integer billingid) {
        this.billingid = billingid;
    }

    public Integer getBillingid() {
        return billingid;
    }

    public void setBillingid(Integer billingid) {
        this.billingid = billingid;
    }

    @XmlTransient
    public Collection<Customercards> getCustomercardsCollection() {
        return customercardsCollection;
    }

    public void setCustomercardsCollection(Collection<Customercards> customercardsCollection) {
        this.customercardsCollection = customercardsCollection;
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
        hash += (billingid != null ? billingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billingaddress)) {
            return false;
        }
        Billingaddress other = (Billingaddress) object;
        if ((this.billingid == null && other.billingid != null) || (this.billingid != null && !this.billingid.equals(other.billingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Billingaddress[ billingid=" + billingid + " ]";
    }
    
}
