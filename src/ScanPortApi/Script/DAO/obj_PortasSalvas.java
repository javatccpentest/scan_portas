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
@Table(name = "portas_salvas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "obj_PortasSalvas.findAll", query = "SELECT o FROM obj_PortasSalvas o")
    , @NamedQuery(name = "obj_PortasSalvas.findById", query = "SELECT o FROM obj_PortasSalvas o WHERE o.id = :id")
    , @NamedQuery(name = "obj_PortasSalvas.findByDescricao", query = "SELECT o FROM obj_PortasSalvas o WHERE o.descricao = :descricao")
    , @NamedQuery(name = "obj_PortasSalvas.findByPorta", query = "SELECT o FROM obj_PortasSalvas o WHERE o.porta = :porta")
    , @NamedQuery(name = "obj_PortasSalvas.findByServico", query = "SELECT o FROM obj_PortasSalvas o WHERE o.servico = :servico")
    , @NamedQuery(name = "obj_PortasSalvas.findByIdScanPortas", query = "SELECT o FROM obj_PortasSalvas o WHERE o.idScanPortas = :idScanPortas")})
public class obj_PortasSalvas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "porta")
    private String porta;
    @Column(name = "servico")
    private String servico;
    @Column(name = "id_scan_portas")
    private Integer idScanPortas;

    public obj_PortasSalvas() {
    }

    public obj_PortasSalvas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Integer getIdScanPortas() {
        return idScanPortas;
    }

    public void setIdScanPortas(Integer idScanPortas) {
        this.idScanPortas = idScanPortas;
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
        if (!(object instanceof obj_PortasSalvas)) {
            return false;
        }
        obj_PortasSalvas other = (obj_PortasSalvas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScanPortApi.Script.DAO.obj_PortasSalvas[ id=" + id + " ]";
    }
    
}
