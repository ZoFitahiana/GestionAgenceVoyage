package com.application.Agence.Model;


import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Reservation {
    private int id_reservation ;
    private int id_client;
    private int id_voyage ;
    private int id_employer;
    private Date date_reservation ;
    private String statut_reservation ;
    private int nombre_participants ;
}