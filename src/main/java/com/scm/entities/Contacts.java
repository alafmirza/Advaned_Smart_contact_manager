package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Contacts {
    @Id
    private String id;
    private String name;
    private String email;
    private String ph;
    private String address;
    private String picture;
    private String Discription;
    private String favorite;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    User user;


@Builder.Default
@OneToMany(mappedBy = "contacts",cascade = CascadeType.ALL)
private List<Sociallinks> socialLinks = new ArrayList<>();
    
}
