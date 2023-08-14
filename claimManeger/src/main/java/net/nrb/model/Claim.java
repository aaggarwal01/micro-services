package net.nrb.model;


import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLAIM")
public class Claim {
        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int claimId;

        @Column(name = "ClimNumber")
        private String climNumber;
        @NotNull
        @JsonProperty("DESCRIPTION")
        @Size(min = 2, message = "DESCRIPTION should have at least 2 Characters")
        @Column(name = "DESCRIPTION")
        private String description;
        @NotNull
        @JsonProperty("STATUS")
        @Size(min = 2, message = "status should have at least 2 Characters")
        @Column(name = "STATUS")
        private String status;
        @JsonProperty("POLICY_ID")
        @Column(name = "POLICY_ID")
        private long policyId;
        @CreationTimestamp
        private LocalDateTime dateCreated;
        @UpdateTimestamp
        private LocalDateTime lastUpdated;


}
