package net.nrb.repo;

import net.nrb.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyInfoRepo extends JpaRepository<Policy,Integer> {
}
