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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mazhar
 */
@Entity
@Table(name = "staffs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffs.findAll", query = "SELECT s FROM Staffs s"),
    @NamedQuery(name = "Staffs.findByStaffnumber", query = "SELECT s FROM Staffs s WHERE s.staffnumber = :staffnumber"),
    @NamedQuery(name = "Staffs.findByFirstname", query = "SELECT s FROM Staffs s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Staffs.findByLastname", query = "SELECT s FROM Staffs s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Staffs.findByEmail", query = "SELECT s FROM Staffs s WHERE s.email = :email"),
    @NamedQuery(name = "Staffs.findByPhone", query = "SELECT s FROM Staffs s WHERE s.phone = :phone"),
    @NamedQuery(name = "Staffs.findByDesignation", query = "SELECT s FROM Staffs s WHERE s.designation = :designation")})
public class Staffs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staffnumber")
    private Integer staffnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "designation")
    private String designation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffnumber")
    private Collection<Admins> adminsCollection;
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Addresses addressid;

    public Staffs() {
    }

    public Staffs(Integer staffnumber) {
        this.staffnumber = staffnumber;
    }

    public Staffs(Integer staffnumber, String firstname, String lastname, String email, String phone, String designation) {
        this.staffnumber = staffnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }

    public Integer getStaffnumber() {
        return staffnumber;
    }

    public void setStaffnumber(Integer staffnumber) {
        this.staffnumber = staffnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public Collection<Admins> getAdminsCollection() {
        return adminsCollection;
    }

    public void setAdminsCollection(Collection<Admins> adminsCollection) {
        this.adminsCollection = adminsCollection;
    }

    public Addresses getAddressid() {
        return addressid;
    }

    public void setAddressid(Addresses addressid) {
        this.addressid = addressid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffnumber != null ? staffnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staffs)) {
            return false;
        }
        Staffs other = (Staffs) object;
        if ((this.staffnumber == null && other.staffnumber != null) || (this.staffnumber != null && !this.staffnumber.equals(other.staffnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hotelreservation.entity.Staffs[ staffnumber=" + staffnumber + " ]";
    }
    
}
