package com.scm.entities;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class User {
    @Id
    private String userId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(unique = true)
    private String password;
    @Column(length = 1000)
    private String about;
    private String profile;
    private String ph;
    private boolean enabled;
    private boolean emailVarified;
    private boolean phVarified;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private  Provider provider  = Provider.SELF;
    private  String providerId;
    @Builder.Default
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Contacts> contatcs = new ArrayList<>();


}
