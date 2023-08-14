package net.nrb.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POLICY_INFO")
public class Policy {
        @Id
        @Column(name = "PID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int policyID;
        @NotEmpty
        @Size(min = 6, message = "policy number should Unique")
        @JsonProperty("policyNumber")
        @Column(name = "policyNumber")
        private String policyNumber;
        @NotEmpty
        @JsonProperty("policyHolderName")
        @Size(min = 2, message = "Name should have at least 2 Characters")
        @Column(name = "PHName")
        private String policyHolderName;


        @JsonProperty("Premium")
        @Column(name = "premiumAmount")
        @DecimalMin(value = "2", message = "Amount should be greater than or equal to 2")
        @DecimalMax(value = "1000000", message = "Amount should be less than or equal to 1000000")
        private Double premiumAmount;
        @NotNull
        @Size(min = 8, message = "date format should be ")
        @JsonProperty("startDate")
        @Column(name ="startDate")
        private String startDate;
        @NotNull
        @Size(min = 8, message = "date format should be ")
        @JsonProperty("endDate")
        @Column(name ="endDate")
        private String endDate;


}
