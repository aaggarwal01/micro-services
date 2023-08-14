package net.nrb.service;

import net.nrb.model.Policy;



import net.nrb.repo.PolicyInfoRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {
    //@Autowired
    //private APIClient apiClient;

    @Autowired
    private PolicyInfoRepo policyInfoRepo;
    @Override
    public Policy createPolicy(Policy policy) {

        return policyInfoRepo.save(policy);
    }

    @Override
    public Policy getPolicyById(Integer policyID) {

        Optional<Policy> optionalPolicy =policyInfoRepo.findById(policyID);
        return optionalPolicy.get();
    }

    @Override
    public List<Policy> getAllPolicy() {

        return policyInfoRepo.findAll();
    }

    @Override
    public Policy updatePolicy(Policy policy) {
        Policy existingPolicy =policyInfoRepo.findById(policy.getPolicyID()).get();
        existingPolicy.setPolicyNumber(policy.getPolicyNumber());
        existingPolicy.setPolicyHolderName(policy.getPolicyHolderName());
        existingPolicy.setPremiumAmount(policy.getPremiumAmount());
        existingPolicy.setStartDate(policy.getStartDate());
        existingPolicy.setEndDate(policy.getEndDate());

        Policy updatedPolicy = policyInfoRepo.save(existingPolicy);
        return updatedPolicy;
    }


    @Override
    public void deletePolicy(Integer policyId) {

        policyInfoRepo.deleteById(policyId);
    }


    /*public List<User> getAllUser() {

        return apiClient.getAllUser();
    }*/
    }





