package com.application.Agence.Model;
import lombok.*;


@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
@ToString
public class Client {
    private int  id_client ;
    private String nom ;
    private String prenom ;
    private String adresse ;
    private String telephone ;
    private  String email ;

}

