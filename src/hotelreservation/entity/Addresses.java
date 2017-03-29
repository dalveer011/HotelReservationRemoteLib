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
@Table(name = "addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a"),
    @NamedQuery(name = "Addresses.findByAddressid", query = "SELECT a FROM Addresses a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Addresses.findByStreet", query = "SELECT a FROM Addresses a WHERE a.street = :street"),
    @NamedQuery(name = "Addresses.findByCity", query = "SELECT a FROM Addresses a WHERE a.city = :city"),
    @NamedQuery(name = "Addresses.findByProvince", query = "SELECT a FROM Addresses a WHERE a.province = :province"),
    @NamedQuery(name = "Addresses.findByPostalcode", query = "SELECT a FROM Addresses a WHERE a.postalcode = :postalcode"),
    @NamedQuery(name = "Addresses.findByCountry", query = "SELECT a FROM Addresses a WHERE a.country = :country")})
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressid")
    private Integer addressid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "postalcode")
    private String postalcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "country")
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressid")
    private Collection<Mailingaddress> mailingaddressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressid")
    private Collection<Billingaddress> billingaddressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressid")
    private Collection<Staffs> staffsCollection;

    public Addresses() {
    }

    public Addresses(Integer addressid) {
        this.addressid = addressid;
    }

    public Addresses(Integer addressid, String street, String city, String province, String postalcode, String country) {
        this.addressid = addressid;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
        this.country = country;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlTransient
    public Collection<Mailingaddress> getMailingaddressCollection() {
        return mailingaddressCollection;
    }

    public void setMailingaddressCollection(Collection<Mailingaddress> mailingaddressCollection) {
        this.mailingaddressCollection = mailingaddressCollection;
    }

    @XmlTransient
    public Collection<Billingaddress> getBillingaddressCollection() {
        return billingaddressCollection;
    }

    public void setBillingaddressCollection(Collection<Billingaddress> billingaddressCollection) {
        this.billingaddressCollection = billingaddressCollection;
    }

    @XmlTransient
    public Collection<Staffs> getStaffsCollection() {
        return staffsCollection;
    }

    public void setStaffsCollection(Collection<Staffs> staffsCollection) {
        this.staffsCollection = staffsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Addresses[ addressid=" + addressid + " ]";
    }
    
}
