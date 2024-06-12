package com.example.site_vitrine.repository;

import com.example.site_vitrine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /** 
     * TODO: Mettre à jour en optionel et mettre à jour le service
     * 
     * Tojours retourner des Optional dans le cas où le retour est unique. 
     * Dans le cas où la valeur donnée ne correspond à aucune entrée, l'optional empty permettra d'anticiper d'éventuels NullPointerException.
     * 
     * Optional<T> findByXYZ(String xyz);
     * */
    User findByEmail(String email);

}
