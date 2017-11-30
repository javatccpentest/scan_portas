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
@Table(name = "service_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "obj_ServiceData.findAll", query = "SELECT o FROM obj_ServiceData o")
    , @NamedQuery(name = "obj_ServiceData.findByServico", query = "SELECT o FROM obj_ServiceData o WHERE o.servico = :servico")
    , @NamedQuery(name = "obj_ServiceData.findByPorta", query = "SELECT o FROM obj_ServiceData o WHERE o.porta = :porta")
    , @NamedQuery(name = "obj_ServiceData.findByDescricao", query = "SELECT o FROM obj_ServiceData o WHERE o.descricao = :descricao")
    , @NamedQuery(name = "obj_ServiceData.findByRisco", query = "SELECT o FROM obj_ServiceData o WHERE o.risco = :risco")
    , @NamedQuery(name = "obj_ServiceData.findById", query = "SELECT o FROM obj_ServiceData o WHERE o.id = :id")})
public class obj_ServiceData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Servico")
    private String servico;
    @Column(name = "Porta")
    private Integer porta;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "Risco")
    private String risco;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public obj_ServiceData() {
    }

    public obj_ServiceData(Integer id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof obj_ServiceData)) {
            return false;
        }
        obj_ServiceData other = (obj_ServiceData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScanPortApi.Script.DAO.obj_ServiceData[ id=" + id + " ]";
    }
    
}
