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
@Table( name = "app_backend" )
public class APP_BACKEND implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long appNumId;

   @Column( nullable = false )
   private String appTxtLabel;

   @Column( nullable = false )
   private String appTxtPackage;

   public long getAppNumId()
   {
      return appNumId;
   }

   public void setAppNumId( long appNumId )
   {
      this.appNumId = appNumId;
   }

   public String getAppTxtLabel()
   {
      return appTxtLabel;
   }

   public void setAppTxtLabel( String appTxtLabel )
   {
      this.appTxtLabel = appTxtLabel;
   }

   public String getAppTxtPackage()
   {
      return appTxtPackage;
   }

   public void setAppTxtPackage( String appTxtPackage )
   {
      this.appTxtPackage = appTxtPackage;
   }
}
