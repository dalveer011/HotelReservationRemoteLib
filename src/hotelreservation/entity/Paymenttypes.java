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
 * @author mazhar
 */
@Entity
@Table(name = "paymenttypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymenttypes.findAll", query = "SELECT p FROM Paymenttypes p"),
    @NamedQuery(name = "Paymenttypes.findByPaymentid", query = "SELECT p FROM Paymenttypes p WHERE p.paymentid = :paymentid"),
    @NamedQuery(name = "Paymenttypes.findByPaymenttype", query = "SELECT p FROM Paymenttypes p WHERE p.paymenttype = :paymenttype")})
public class Paymenttypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentid")
    private Integer paymentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "paymenttype")
    private String paymenttype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymenttypeid")
    private Collection<Payments> paymentsCollection;

    public Paymenttypes() {
    }

    public Paymenttypes(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Paymenttypes(Integer paymentid, String paymenttype) {
        this.paymentid = paymentid;
        this.paymenttype = paymenttype;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    @XmlTransient
    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentid != null ? paymentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymenttypes)) {
            return false;
        }
        Paymenttypes other = (Paymenttypes) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Paymenttypes[ paymentid=" + paymentid + " ]";
    }
    
}
