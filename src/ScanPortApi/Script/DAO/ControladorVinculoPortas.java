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
public class ControladorVinculoPortas implements Serializable {

    public ControladorVinculoPortas(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(obj_VinculoPortas obj_VinculoPortas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj_VinculoPortas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(obj_VinculoPortas obj_VinculoPortas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            obj_VinculoPortas = em.merge(obj_VinculoPortas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = obj_VinculoPortas.getId();
                if (findobj_VinculoPortas(id) == null) {
                    throw new NonexistentEntityException("The obj_VinculoPortas with id " + id + " no longer exists.");
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
            obj_VinculoPortas obj_VinculoPortas;
            try {
                obj_VinculoPortas = em.getReference(obj_VinculoPortas.class, id);
                obj_VinculoPortas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The obj_VinculoPortas with id " + id + " no longer exists.", enfe);
            }
            em.remove(obj_VinculoPortas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public obj_VinculoPortas findobj_VinculoPortas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(obj_VinculoPortas.class, id);
        } finally {
            em.close();
        }
    }

    
}
