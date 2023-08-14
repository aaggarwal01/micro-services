package net.nrb.service;

import net.nrb.model.Policy;

import java.util.List;

public interface PolicyService {
    Policy createPolicy(Policy policy);

    Policy  getPolicyById(Integer policyID);

    List<Policy> getAllPolicy();

    Policy updatePolicy(Policy  policy);

    void deletePolicy(Integer policyId);
}

