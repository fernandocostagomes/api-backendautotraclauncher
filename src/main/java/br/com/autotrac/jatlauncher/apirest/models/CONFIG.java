package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Embeddable
@Table( name = "config" )
public class CONFIG implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long configNumId;

   @Column( nullable = false )
   private long configNumUpdate;

   @Column( nullable = false )
   private long deviceNumId;

   public long getConfigNumId()
   {
      return configNumId;
   }

   public void setConfigNumId( long configNumId )
   {
      this.configNumId = configNumId;
   }

   public long getConfigNumUpdate()
   {
      return configNumUpdate;
   }

   public void setConfigNumUpdate( long configNumUpdate )
   {
      this.configNumUpdate = configNumUpdate;
   }

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }
}
