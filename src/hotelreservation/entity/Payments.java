/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mazhar
 */
@Entity
@Table(name = "payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p"),
    @NamedQuery(name = "Payments.findByPaymentid", query = "SELECT p FROM Payments p WHERE p.paymentid = :paymentid"),
    @NamedQuery(name = "Payments.findByAmountpaid", query = "SELECT p FROM Payments p WHERE p.amountpaid = :amountpaid")})
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentid")
    private Integer paymentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amountpaid")
    private double amountpaid;
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    @ManyToOne(optional = false)
    private Bookings bookingid;
    @JoinColumn(name = "cardnum", referencedColumnName = "cardnum")
    @ManyToOne(optional = false)
    private Customercards cardnum;
    @JoinColumn(name = "paymenttypeid", referencedColumnName = "paymentid")
    @ManyToOne(optional = false)
    private Paymenttypes paymenttypeid;

    public Payments() {
    }

    public Payments(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Payments(Integer paymentid, double amountpaid) {
        this.paymentid = paymentid;
        this.amountpaid = amountpaid;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public Bookings getBookingid() {
        return bookingid;
    }

    public void setBookingid(Bookings bookingid) {
        this.bookingid = bookingid;
    }

    public Customercards getCardnum() {
        return cardnum;
    }

    public void setCardnum(Customercards cardnum) {
        this.cardnum = cardnum;
    }

    public Paymenttypes getPaymenttypeid() {
        return paymenttypeid;
    }

    public void setPaymenttypeid(Paymenttypes paymenttypeid) {
        this.paymenttypeid = paymenttypeid;
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
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Payments[ paymentid=" + paymentid + " ]";
    }
    
}
