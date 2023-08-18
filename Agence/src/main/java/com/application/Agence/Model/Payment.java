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

public class Payment {
    private int  id_payment ;
    private int id_reservation ;
    private float montant ;
    private Date date_paiement ;
    private String methode_paiement ;


}
