package com.application.Agence.Model;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Voyage {
   private int  id_voyage ;
   private String  destination ;
   private Timestamp  date_depart ;
   private Time duree ;
   private String description ;
   private  float prix ;
   private int places_disponibles ;
}
