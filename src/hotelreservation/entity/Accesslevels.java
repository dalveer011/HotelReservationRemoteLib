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
@Table(name = "accesslevels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accesslevels.findAll", query = "SELECT a FROM Accesslevels a"),
    @NamedQuery(name = "Accesslevels.findByAccessid", query = "SELECT a FROM Accesslevels a WHERE a.accessid = :accessid"),
    @NamedQuery(name = "Accesslevels.findByAccesslevel", query = "SELECT a FROM Accesslevels a WHERE a.accesslevel = :accesslevel")})
public class Accesslevels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accessid")
    private Integer accessid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "accesslevel")
    private String accesslevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessid")
    private Collection<Admins> adminsCollection;

    public Accesslevels() {
    }

    public Accesslevels(Integer accessid) {
        this.accessid = accessid;
    }

    public Accesslevels(Integer accessid, String accesslevel) {
        this.accessid = accessid;
        this.accesslevel = accesslevel;
    }

    public Integer getAccessid() {
        return accessid;
    }

    public void setAccessid(Integer accessid) {
        this.accessid = accessid;
    }

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    @XmlTransient
    public Collection<Admins> getAdminsCollection() {
        return adminsCollection;
    }

    public void setAdminsCollection(Collection<Admins> adminsCollection) {
        this.adminsCollection = adminsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessid != null ? accessid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesslevels)) {
            return false;
        }
        Accesslevels other = (Accesslevels) object;
        if ((this.accessid == null && other.accessid != null) || (this.accessid != null && !this.accessid.equals(other.accessid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Accesslevels[ accessid=" + accessid + " ]";
    }
    
}
