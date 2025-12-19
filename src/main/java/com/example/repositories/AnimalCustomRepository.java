package com.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AnimalCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public int countAnimalsByCategory(String category) {
        Query query = entityManager.createNativeQuery("SELECT count_animals_by_category(:cat)");
        query.setParameter("cat", category);
        Number result = (Number) query.getSingleResult();
        return result.intValue();
    }

    @Transactional
    public void uppercaseNamesForCategory(String category) {
        entityManager.createNativeQuery("CALL uppercase_animal_name_for_category(:cat)")
                .setParameter("cat", category)
                .executeUpdate();
    }
}
