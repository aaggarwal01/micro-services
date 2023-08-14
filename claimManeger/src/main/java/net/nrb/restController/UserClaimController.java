package net.nrb.restController;


import net.nrb.model.Claim;
import net.nrb.service.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user/api/claim_mght")
public class UserClaimController {
    @Autowired

    private ClaimServiceImpl claimService;


    // build create User REST API
    // http://localhost:8083/Admin/api/Claim_mght/save
    @PostMapping("/save")
    public ResponseEntity<Claim> createClaim(@Valid @RequestBody Claim claim){
        //create unique tracking number
        String climNumber = String.format("%04d", new Random().nextInt(10000));
        claim.setClimNumber(climNumber);
        Claim savedClaim = claimService.createClaim(claim);
        return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8083/Admin/api/Claim_mght/1
    @GetMapping("/view/{claimID}")
    public ResponseEntity<Claim> getClaimById(@PathVariable("claimID") int  claimID){
        Claim Claim =claimService.getClaimById(claimID);
        return new ResponseEntity<>(Claim, HttpStatus.OK);
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
    @DeleteMapping("/Delete/{claimId}")
    public ResponseEntity<String> deleteClaim(@PathVariable("claimId") int claimId){
        claimService.deleteClaim(claimId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
