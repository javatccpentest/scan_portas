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
public class ControladorScanPortas implements Serializable {

    public ControladorScanPortas(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(obj_ScanPortas obj_ScanPortas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj_ScanPortas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(obj_ScanPortas obj_ScanPortas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            obj_ScanPortas = em.merge(obj_ScanPortas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = obj_ScanPortas.getId();
                if (findobj_ScanPortas(id) == null) {
                    throw new NonexistentEntityException("The obj_ScanPortas with id " + id + " no longer exists.");
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
            obj_ScanPortas obj_ScanPortas;
            try {
                obj_ScanPortas = em.getReference(obj_ScanPortas.class, id);
                obj_ScanPortas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The obj_ScanPortas with id " + id + " no longer exists.", enfe);
            }
            em.remove(obj_ScanPortas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public obj_ScanPortas findobj_ScanPortas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(obj_ScanPortas.class, id);
        } finally {
            em.close();
        }
    }

    
}
