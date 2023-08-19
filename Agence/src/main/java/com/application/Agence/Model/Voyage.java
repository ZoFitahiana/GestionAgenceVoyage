package com.application.Agence.Model;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Voyage {
   private int  id_voyage ;
   private String  destination ;
   private Date date_depart ;
   private int duree ;
   private String description ;
   private  float prix ;
   private int places_disponibles ;
}
