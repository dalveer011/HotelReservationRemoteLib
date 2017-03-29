/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mazhar
 */
@Entity
@Table(name = "customercards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customercards.findAll", query = "SELECT c FROM Customercards c"),
    @NamedQuery(name = "Customercards.findByCardnum", query = "SELECT c FROM Customercards c WHERE c.cardnum = :cardnum"),
    @NamedQuery(name = "Customercards.findByExpirydate", query = "SELECT c FROM Customercards c WHERE c.expirydate = :expirydate")})
public class Customercards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cardnum")
    private Integer cardnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expirydate")
    @Temporal(TemporalType.DATE)
    private Date expirydate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardnum")
    private Collection<Payments> paymentsCollection;
    @JoinColumn(name = "billingaddressid", referencedColumnName = "billingid")
    @ManyToOne(optional = false)
    private Billingaddress billingaddressid;
    @JoinColumn(name = "customerusername", referencedColumnName = "customerusername")
    @ManyToOne(optional = false)
    private Customers customerusername;

    public Customercards() {
    }

    public Customercards(Integer cardnum) {
        this.cardnum = cardnum;
    }

    public Customercards(Integer cardnum, Date expirydate) {
        this.cardnum = cardnum;
        this.expirydate = expirydate;
    }

    public Integer getCardnum() {
        return cardnum;
    }

    public void setCardnum(Integer cardnum) {
        this.cardnum = cardnum;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @XmlTransient
    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    public Billingaddress getBillingaddressid() {
        return billingaddressid;
    }

    public void setBillingaddressid(Billingaddress billingaddressid) {
        this.billingaddressid = billingaddressid;
    }

    public Customers getCustomerusername() {
        return customerusername;
    }

    public void setCustomerusername(Customers customerusername) {
        this.customerusername = customerusername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardnum != null ? cardnum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customercards)) {
            return false;
        }
        Customercards other = (Customercards) object;
        if ((this.cardnum == null && other.cardnum != null) || (this.cardnum != null && !this.cardnum.equals(other.cardnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Customercards[ cardnum=" + cardnum + " ]";
    }
    
}
