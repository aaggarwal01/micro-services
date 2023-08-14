package net.nrb.service;


import net.nrb.ExceptionalHandler.ResourceNotFoundException;
import net.nrb.model.Claim;
import net.nrb.repo.ClaimInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {
    @Autowired
    private ClaimInfoRepo claimInfoRepo;
    @Override
    public Claim createClaim(Claim Claim) {

        return claimInfoRepo.save(Claim);
    }

    @Override
    public Claim getClaimById(Integer ClaimID) {
        return claimInfoRepo.findById(ClaimID)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id :" + ClaimID));
    }


    @Override
    public List<Claim> getAllClaim() {
        return claimInfoRepo.findAll();
    }

    @Override
    public Claim updateClaim(Claim claim) {
        Claim existingClaim =claimInfoRepo.findById(claim.getClaimId()).get();
        existingClaim.setDescription(claim.getDescription());
        existingClaim.setStatus(claim.getStatus());
        existingClaim.setPolicyId(claim.getPolicyId());
        existingClaim.setClaimId(claim.getClaimId());
        existingClaim.setClimNumber(claim.getClimNumber());

        Claim updatedClaim = claimInfoRepo.save(existingClaim);
        return updatedClaim;
    }


    @Override
    public void deleteClaim(Integer claimId) {

        claimInfoRepo.deleteById(claimId);
    }

    }





