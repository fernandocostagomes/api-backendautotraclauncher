package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "app" )
public class APP implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long app_num_id;

   private String app_txt_label;

   private String app_txt_package;

   public long getApp_num_id()
   {
      return app_num_id;
   }

   public void setApp_num_id( long app_num_id )
   {
      this.app_num_id = app_num_id;
   }

   public String getApp_txt_label()
   {
      return app_txt_label;
   }

   public void setApp_txt_label( String app_txt_label )
   {
      this.app_txt_label = app_txt_label;
   }

   public String getApp_txt_package()
   {
      return app_txt_package;
   }

   public void setApp_txt_package( String app_txt_package )
   {
      this.app_txt_package = app_txt_package;
   }
}
