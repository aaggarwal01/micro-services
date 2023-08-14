package net.nrb.restController;
import net.nrb.model.Claim;
import net.nrb.service.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("admin/api/claim_mght")
public class AdminClaimController {
        @Autowired
        private ClaimServiceImpl claimService;
        // build get user by id REST API
        // http://localhost:8083/Admin/api/Claim_mght/1
        @GetMapping("/view/{claimID}")
        public ResponseEntity<Claim> getUserClaimById(@PathVariable("claimID") int claimID){
            Claim claim =claimService.getClaimById(claimID);
            return new ResponseEntity<>(claim, HttpStatus.OK);
        }

        // Build Get All Users REST API
        // http://localhost:8083/Admin/api/Claim_mght/getAll
        @GetMapping("/getAll")
        public ResponseEntity<List<Claim>> getAllClaim(){
            List<Claim>claim =claimService.getAllClaim();
            return new ResponseEntity<>(claim, HttpStatus.OK);
        }

        // Build Update User REST API
        @PutMapping("/update/{claimId}")
        // http://localhost:8083/Admin/api/Claim_mght/update/2
        public ResponseEntity<Claim> updateClaim(@PathVariable("claimId") int claimId,
                                                @RequestBody Claim claim){
            claim.setClaimId(claimId);
            Claim updateClaim =claimService.updateClaim(claim);
            return new ResponseEntity<>(updateClaim, HttpStatus.OK);
        }

        // Build Delete User REST API
        // http://localhost:8083/Admin/api/Claim_mght/Delete/2
        @DeleteMapping("/delete/{claimId}")
        public ResponseEntity<String> deleteClaim(@PathVariable("claimId") int claimId){
            claimService.deleteClaim(claimId);
            return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
        }
    }


