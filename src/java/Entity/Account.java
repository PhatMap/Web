/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TranTrungPhat
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAcid", query = "SELECT a FROM Account a WHERE a.acid = :acid"),
    @NamedQuery(name = "Account.findByUser", query = "SELECT a FROM Account a WHERE a.user = :user"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByIssell", query = "SELECT a FROM Account a WHERE a.issell = :issell"),
    @NamedQuery(name = "Account.findByIsadmin", query = "SELECT a FROM Account a WHERE a.isadmin = :isadmin")})
public class Account implements Serializable {

    @Column(name = "issell")
    private boolean issell;
    @Column(name = "isadmin")
    private boolean isadmin;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acid")
    private Integer acid;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;

    public Account() {
    }

    public Account(Integer acid, String user, String password, boolean issell, boolean isadmin) {
        this.acid = acid;
        this.user = user;
        this.password = password;
        this.issell = issell;
        this.isadmin = isadmin;
    }

    
    
    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acid != null ? acid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.acid == null && other.acid != null) || (this.acid != null && !this.acid.equals(other.acid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Account[ acid=" + acid + " ]";
    }

    public boolean getIssell() {
        return issell;
    }

    public void setIssell(boolean issell) {
        this.issell = issell;
    }

    public boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
