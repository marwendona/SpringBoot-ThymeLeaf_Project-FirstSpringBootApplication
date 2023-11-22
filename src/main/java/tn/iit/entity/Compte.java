package tn.iit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter()
@Setter
@NoArgsConstructor /* Obligatoire selon la spec JEE */
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity /* Objet à mapper avec la BD */
@Table(name = "t_compte")
public class Compte implements Serializable /* Obligatoire selon la spec JEE */ {
    private static final long serialVersionUID = 1L;

    @Include
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rib;
    private float solde;
    @Column(name = "client", length = 50)
    private String nomClient;

    public Compte(float solde, String nomClient) {
        super();
        this.solde = solde;
        this.nomClient = nomClient;
    }
    /*
     * @Transient //pas de colonne dans la table private String formattedSolde;
     *
     * /* public String getFormattedSolde() {
     *
     * return String.format("%.03f", solde); }
     */

}
