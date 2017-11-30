/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.Script.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author whoami
 */
@Entity
@Table(name = "scan_portas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "obj_ScanPortas.findAll", query = "SELECT o FROM obj_ScanPortas o")
    , @NamedQuery(name = "obj_ScanPortas.findById", query = "SELECT o FROM obj_ScanPortas o WHERE o.id = :id")
    , @NamedQuery(name = "obj_ScanPortas.findByIp", query = "SELECT o FROM obj_ScanPortas o WHERE o.ip = :ip")
    , @NamedQuery(name = "obj_ScanPortas.findBySite", query = "SELECT o FROM obj_ScanPortas o WHERE o.site = :site")
    , @NamedQuery(name = "obj_ScanPortas.findByWhois", query = "SELECT o FROM obj_ScanPortas o WHERE o.whois = :whois")})
public class obj_ScanPortas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "site")
    private String site;
    @Column(name = "whois")
    private String whois;

    public obj_ScanPortas() {
    }

    public obj_ScanPortas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getWhois() {
        return whois;
    }

    public void setWhois(String whois) {
        this.whois = whois;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof obj_ScanPortas)) {
            return false;
        }
        obj_ScanPortas other = (obj_ScanPortas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScanPortApi.Script.DAO.obj_ScanPortas[ id=" + id + " ]";
    }
    
}
