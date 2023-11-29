package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Compte;

import java.util.List;

@Repository
public interface CompteDao extends JpaRepository<Compte, Integer> {

    @Query("select c from Compte c where c.nomClient = ?1")
    List<Compte> findByNomClient1(String nomClient);

    @Query("select c from Compte c where c.nomClient = :nc")
    List<Compte> findByNomClient2(@Param("nc") String nomClient);

    @Query(nativeQuery = true,value="select * from t_compte c where c.client = :nc")
    List<Compte> findByNomClient3(@Param("nc") String nomClient);

    @Query("select c from Compte c where c.nomClient = ?1 and c.solde >= ?2")
    List<Compte> findByNomClientAndSolde1(String nomClient, float solde);

    @Query("select c from Compte c where c.nomClient = :nc and c.solde >= :solde")
    List<Compte> findByNomClientAndSolde2(@Param("nc") String nomClient, @Param("solde") float solde);

    @Query(nativeQuery = true,value="select * from t_compte c where c.client = ?1 and c.solde >= ?2")
    List<Compte> findByNomClientAndSolde3(String nomClient, float solde);
}