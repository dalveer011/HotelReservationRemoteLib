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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "bookings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookings.findAll", query = "SELECT b FROM Bookings b"),
    @NamedQuery(name = "Bookings.findByBookingid", query = "SELECT b FROM Bookings b WHERE b.bookingid = :bookingid"),
    @NamedQuery(name = "Bookings.findByStartdate", query = "SELECT b FROM Bookings b WHERE b.startdate = :startdate"),
    @NamedQuery(name = "Bookings.findByEnddate", query = "SELECT b FROM Bookings b WHERE b.enddate = :enddate"),
    @NamedQuery(name = "Bookings.findByTotalamount", query = "SELECT b FROM Bookings b WHERE b.totalamount = :totalamount")})
public class Bookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookingid")
    private Integer bookingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalamount")
    private double totalamount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingid")
    private Collection<Payments> paymentsCollection;
    @JoinColumn(name = "customerusername", referencedColumnName = "customerusername")
    @ManyToOne(optional = false)
    private Customers customerusername;
    @JoinColumn(name = "roomnum", referencedColumnName = "roomnum")
    @ManyToOne(optional = false)
    private Rooms roomnum;

    public Bookings() {
    }

    public Bookings(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Bookings(Integer bookingid, Date startdate, Date enddate, double totalamount) {
        this.bookingid = bookingid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.totalamount = totalamount;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    @XmlTransient
    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    public Customers getCustomerusername() {
        return customerusername;
    }

    public void setCustomerusername(Customers customerusername) {
        this.customerusername = customerusername;
    }

    public Rooms getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Rooms roomnum) {
        this.roomnum = roomnum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookings)) {
            return false;
        }
        Bookings other = (Bookings) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Bookings[ bookingid=" + bookingid + " ]";
    }
    
}
