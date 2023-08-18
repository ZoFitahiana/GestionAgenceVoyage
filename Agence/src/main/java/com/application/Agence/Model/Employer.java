package com.application.Agence.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode

public class Employer {
    private int  id_employer ;
    private String nom ;
    private String prenom ;
    private String  poste ;
    private String adresse ;
    private  String telephone ;
    private Date date_embauche;
}
