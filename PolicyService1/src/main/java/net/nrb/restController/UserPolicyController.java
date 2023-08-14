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
@RequestMapping("user/api/policy_mght")
public class UserPolicyController {

        @Autowired

        private PolicyServiceImpl policyService;

        // build get user by id REST API
        // http://localhost:8083/user/api/view/policy_mght/1
        @GetMapping("/view/{policyID}")
        public ResponseEntity<Policy> getPolicyById(@PathVariable("policyID") int  policyID){
            Policy policy =policyService.getPolicyById(policyID);
            return new ResponseEntity<>(policy, HttpStatus.OK);
        }


}
