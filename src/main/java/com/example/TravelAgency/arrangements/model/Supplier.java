package com.example.TravelAgency.arrangements.model;

import com.example.TravelAgency.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Jedan supplier = jedan user nalog
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private User account;

    @Column(nullable = false)
    private String companyName;

    // capability npr: HOTEL, AIRLINE, BUS, GUIDE...
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "supplier_capability", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "capability")
    private Set<String> capabilities = new HashSet<>();

    // get/set
    public Long getId() { return id; }
    public User getAccount() { return account; }
    public void setAccount(User account) { this.account = account; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public Set<String> getCapabilities() { return capabilities; }
    public void setCapabilities(Set<String> capabilities) { this.capabilities = capabilities; }
}
