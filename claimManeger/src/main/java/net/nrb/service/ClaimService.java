package net.nrb.service;



import net.nrb.model.Claim;

import java.util.List;

public interface ClaimService {
    Claim createClaim(Claim Claim);

    Claim  getClaimById(Integer ClaimID);

    List<Claim> getAllClaim();

    Claim updateClaim(Claim  Claim);

    void deleteClaim(Integer ClaimId);
}

