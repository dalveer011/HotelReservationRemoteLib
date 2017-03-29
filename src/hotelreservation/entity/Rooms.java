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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "rooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findByRoomnum", query = "SELECT r FROM Rooms r WHERE r.roomnum = :roomnum"),
    @NamedQuery(name = "Rooms.findByRoomtype", query = "SELECT r FROM Rooms r WHERE r.roomtype = :roomtype"),
    @NamedQuery(name = "Rooms.findByArea", query = "SELECT r FROM Rooms r WHERE r.area = :area"),
    @NamedQuery(name = "Rooms.findByFloor", query = "SELECT r FROM Rooms r WHERE r.floor = :floor"),
    @NamedQuery(name = "Rooms.findByRoomrate", query = "SELECT r FROM Rooms r WHERE r.roomrate = :roomrate")})
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "roomnum")
    private Integer roomnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "roomtype")
    private String roomtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private int area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "floor")
    private int floor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roomrate")
    private double roomrate;
    @ManyToMany(mappedBy = "roomsCollection")
    private Collection<Facilities> facilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomnum")
    private Collection<Bookings> bookingsCollection;

    public Rooms() {
    }

    public Rooms(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public Rooms(Integer roomnum, String roomtype, int area, int floor, double roomrate) {
        this.roomnum = roomnum;
        this.roomtype = roomtype;
        this.area = area;
        this.floor = floor;
        this.roomrate = roomrate;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getRoomrate() {
        return roomrate;
    }

    public void setRoomrate(double roomrate) {
        this.roomrate = roomrate;
    }

    @XmlTransient
    public Collection<Facilities> getFacilitiesCollection() {
        return facilitiesCollection;
    }

    public void setFacilitiesCollection(Collection<Facilities> facilitiesCollection) {
        this.facilitiesCollection = facilitiesCollection;
    }

    @XmlTransient
    public Collection<Bookings> getBookingsCollection() {
        return bookingsCollection;
    }

    public void setBookingsCollection(Collection<Bookings> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomnum != null ? roomnum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomnum == null && other.roomnum != null) || (this.roomnum != null && !this.roomnum.equals(other.roomnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Rooms[ roomnum=" + roomnum + " ]";
    }
    
}
