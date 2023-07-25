package org.example.repository;

import org.example.domain.entity.FitrockrBody;
import org.example.domain.entity.FitrockrBodyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitrockrBodyRepository extends JpaRepository<FitrockrBody, FitrockrBodyId> {
}
