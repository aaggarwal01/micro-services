package net.nrb.repo;



import net.nrb.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimInfoRepo extends JpaRepository<Claim,Integer> {
}
