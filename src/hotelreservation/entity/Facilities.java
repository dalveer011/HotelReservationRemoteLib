/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "facilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facilities.findAll", query = "SELECT f FROM Facilities f"),
    @NamedQuery(name = "Facilities.findByFacilityid", query = "SELECT f FROM Facilities f WHERE f.facilityid = :facilityid"),
    @NamedQuery(name = "Facilities.findByFacilitydescription", query = "SELECT f FROM Facilities f WHERE f.facilitydescription = :facilitydescription")})
public class Facilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "facilityid")
    private Integer facilityid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "facilitydescription")
    private String facilitydescription;
    @JoinTable(name = "roomfacilities", joinColumns = {
        @JoinColumn(name = "facilityid", referencedColumnName = "facilityid")}, inverseJoinColumns = {
        @JoinColumn(name = "roomnum", referencedColumnName = "roomnum")})
    @ManyToMany
    private Collection<Rooms> roomsCollection;

    public Facilities() {
    }

    public Facilities(Integer facilityid) {
        this.facilityid = facilityid;
    }

    public Facilities(Integer facilityid, String facilitydescription) {
        this.facilityid = facilityid;
        this.facilitydescription = facilitydescription;
    }

    public Integer getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(Integer facilityid) {
        this.facilityid = facilityid;
    }

    public String getFacilitydescription() {
        return facilitydescription;
    }

    public void setFacilitydescription(String facilitydescription) {
        this.facilitydescription = facilitydescription;
    }

    @XmlTransient
    public Collection<Rooms> getRoomsCollection() {
        return roomsCollection;
    }

    public void setRoomsCollection(Collection<Rooms> roomsCollection) {
        this.roomsCollection = roomsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facilityid != null ? facilityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facilities)) {
            return false;
        }
        Facilities other = (Facilities) object;
        if ((this.facilityid == null && other.facilityid != null) || (this.facilityid != null && !this.facilityid.equals(other.facilityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Facilities[ facilityid=" + facilityid + " ]";
    }
    
}
