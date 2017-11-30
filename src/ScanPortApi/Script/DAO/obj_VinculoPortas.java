/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.Script.DAO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author whoami
 */
@Entity
@Table(name = "vinculo_portas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "obj_VinculoPortas.findAll", query = "SELECT o FROM obj_VinculoPortas o")
    , @NamedQuery(name = "obj_VinculoPortas.findById", query = "SELECT o FROM obj_VinculoPortas o WHERE o.id = :id")
    , @NamedQuery(name = "obj_VinculoPortas.findByDtFim", query = "SELECT o FROM obj_VinculoPortas o WHERE o.dtFim = :dtFim")
    , @NamedQuery(name = "obj_VinculoPortas.findByDtIni", query = "SELECT o FROM obj_VinculoPortas o WHERE o.dtIni = :dtIni")
    , @NamedQuery(name = "obj_VinculoPortas.findByIdSub", query = "SELECT o FROM obj_VinculoPortas o WHERE o.idSub = :idSub")
    , @NamedQuery(name = "obj_VinculoPortas.findByIdUser", query = "SELECT o FROM obj_VinculoPortas o WHERE o.idUser = :idUser")
    , @NamedQuery(name = "obj_VinculoPortas.findByIdTeste", query = "SELECT o FROM obj_VinculoPortas o WHERE o.idTeste = :idTeste")})
public class obj_VinculoPortas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dt_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtFim;
    @Column(name = "dt_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtIni;
    @Column(name = "id_sub")
    private Integer idSub;
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "id_teste")
    private Integer idTeste;

    public obj_VinculoPortas() {
    }

    public obj_VinculoPortas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public Date getDtIni() {
        return dtIni;
    }

    public void setDtIni(Date dtIni) {
        this.dtIni = dtIni;
    }

    public Integer getIdSub() {
        return idSub;
    }

    public void setIdSub(Integer idSub) {
        this.idSub = idSub;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(Integer idTeste) {
        this.idTeste = idTeste;
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
        if (!(object instanceof obj_VinculoPortas)) {
            return false;
        }
        obj_VinculoPortas other = (obj_VinculoPortas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScanPortApi.Script.DAO.obj_VinculoPortas[ id=" + id + " ]";
    }
    
}
