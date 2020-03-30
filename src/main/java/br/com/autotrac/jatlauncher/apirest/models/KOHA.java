package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "koha" )
public class KOHA implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long id;

   @Column( nullable = false )
   private String title;

   @Column( nullable = false )
   private String author;

   @Column( nullable = false )
   private String edition;

   @Column( nullable = false )
   private String source;

   @Column( nullable = false )
   private String material_type;

   @Column( nullable = false )
   private String icon_material_type;

   @Column( nullable = false )
   private String format;

   @Column( nullable = false )
   private String literary_format;

   @Column( nullable = false )
   private String online_resources;

   @Column( nullable = false )
   private String availability;

   @Column( nullable = false )
   private String publisher;

   @Column( nullable = false )
   private String ratings;

}
