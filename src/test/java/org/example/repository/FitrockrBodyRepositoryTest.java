package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.domain.entity.FitrockrBodyId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FitrockrBodyRepositoryTest {

    @Autowired
    private FitrockrBodyRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Transactional
    void update() {
        LocalDateTime startDateTime = LocalDateTime.of(2023, 6, 2, 9, 6, 0);
        String userId = "646b38efdeb81f4756cfc87a";
        var selectOptional = repository.findById(new FitrockrBodyId(userId, startDateTime)); // 영속
        var selectData = selectOptional.get();
        selectData.setActiveCalories(333);
        //repository.saveAndFlush(selectData);
        //entityManager.flush();
        repository.save(selectData);
    }
}
