package tn.iit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Compte;

import java.util.List;
import java.util.Optional;

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

    public Optional<Compte> findById(Integer rib) {
        Compte compte = entityManager.find(Compte.class, rib);
        return Optional.ofNullable(compte);
    }

    @Transactional
    public void deleteById(Integer rib) {
        Compte compte = entityManager.find(Compte.class, rib);
        if (compte != null) {
            entityManager.remove(compte);
        }
    }
}
