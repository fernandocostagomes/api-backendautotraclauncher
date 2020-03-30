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

   public long getId()
   {
      return id;
   }

   public void setId( long id )
   {
      this.id = id;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle( String title )
   {
      this.title = title;
   }

   public String getAuthor()
   {
      return author;
   }

   public void setAuthor( String author )
   {
      this.author = author;
   }

   public String getEdition()
   {
      return edition;
   }

   public void setEdition( String edition )
   {
      this.edition = edition;
   }

   public String getSource()
   {
      return source;
   }

   public void setSource( String source )
   {
      this.source = source;
   }

   public String getMaterial_type()
   {
      return material_type;
   }

   public void setMaterial_type( String material_type )
   {
      this.material_type = material_type;
   }

   public String getIcon_material_type()
   {
      return icon_material_type;
   }

   public void setIcon_material_type( String icon_material_type )
   {
      this.icon_material_type = icon_material_type;
   }

   public String getFormat()
   {
      return format;
   }

   public void setFormat( String format )
   {
      this.format = format;
   }

   public String getLiterary_format()
   {
      return literary_format;
   }

   public void setLiterary_format( String literary_format )
   {
      this.literary_format = literary_format;
   }

   public String getOnline_resources()
   {
      return online_resources;
   }

   public void setOnline_resources( String online_resources )
   {
      this.online_resources = online_resources;
   }

   public String getAvailability()
   {
      return availability;
   }

   public void setAvailability( String availability )
   {
      this.availability = availability;
   }

   public String getPublisher()
   {
      return publisher;
   }

   public void setPublisher( String publisher )
   {
      this.publisher = publisher;
   }

   public String getRatings()
   {
      return ratings;
   }

   public void setRatings( String ratings )
   {
      this.ratings = ratings;
   }

   public static long getSerialversionuid()
   {
      return serialVersionUID;
   }
}
