package net.nrb.restController;

import net.nrb.model.Policy;
import net.nrb.service.PolicyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin/api/policy_mght")
public class AdminPolicyController {


    @Autowired

    private PolicyServiceImpl policyService;


    // build create User REST API
    // http://localhost:8083/Admin/api/policy_mght/save
    @PostMapping("/save")
    public ResponseEntity<Policy> createPolicy(@Valid @RequestBody Policy policy){
        Policy savedPolicy = policyService.createPolicy(policy);
        return new ResponseEntity<>(savedPolicy, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8083/Admin/api/policy_mght/1
    @GetMapping("/{policyID}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable("policyID") int  policyID){
        Policy policy =policyService.getPolicyById(policyID);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8083/Admin/api/policy_mght/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Policy>> getAllPolicy(){
        List<Policy>policy =policyService.getAllPolicy();
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/update/{policyID}")
    // http://localhost:8083/Admin/api/policy_mght/update/2
    public ResponseEntity<Policy> updatePolicy(@PathVariable("policyID") int policyID,
                                           @RequestBody Policy policy){
        policy.setPolicyID(policyID);
        Policy updatePolicy =policyService.updatePolicy(policy);
        return new ResponseEntity<>(updatePolicy, HttpStatus.OK);
    }

    // Build Delete User REST API
    // http://localhost:8083/Admin/api/policy_mght/Delete/2
    @DeleteMapping("/delete/{policyID}")
    public ResponseEntity<String> deletePolicy(@PathVariable("policyID") int policyID){
        policyService.deletePolicy(policyID);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }


}
