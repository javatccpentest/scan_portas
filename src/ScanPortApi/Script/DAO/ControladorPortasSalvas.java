/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.Script.DAO;

import ScanPortApi.Script.DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author whoami
 */
public class ControladorPortasSalvas implements Serializable {

    public ControladorPortasSalvas(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(obj_PortasSalvas obj_PortasSalvas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj_PortasSalvas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(obj_PortasSalvas obj_PortasSalvas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            obj_PortasSalvas = em.merge(obj_PortasSalvas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = obj_PortasSalvas.getId();
                if (findobj_PortasSalvas(id) == null) {
                    throw new NonexistentEntityException("The obj_PortasSalvas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            obj_PortasSalvas obj_PortasSalvas;
            try {
                obj_PortasSalvas = em.getReference(obj_PortasSalvas.class, id);
                obj_PortasSalvas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The obj_PortasSalvas with id " + id + " no longer exists.", enfe);
            }
            em.remove(obj_PortasSalvas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public obj_PortasSalvas findobj_PortasSalvas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(obj_PortasSalvas.class, id);
        } finally {
            em.close();
        }
    }

    
}
