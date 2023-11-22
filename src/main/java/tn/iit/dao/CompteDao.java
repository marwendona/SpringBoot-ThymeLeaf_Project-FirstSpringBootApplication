package tn.iit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Compte;

import java.util.List;

@Repository
public class CompteDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Compte compte) {
        entityManager.persist(compte);
    }

    @Transactional
    public void delete(Compte compte) {
        entityManager.remove(compte);
    }

    @Transactional
    public void update(Compte compte) {
        entityManager.merge(compte);
    }

    public List<Compte> findAll() {
        return entityManager.createQuery("select c from Compte c", Compte.class).getResultList();
    }
}
