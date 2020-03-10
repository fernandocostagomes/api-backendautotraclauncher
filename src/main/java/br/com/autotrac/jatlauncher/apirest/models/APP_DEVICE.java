package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table( name = "app_device" )
public class APP_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   private long app_num_id;

   private String device_txt_id;

   private String app_device_txt_status;

   private String app_device_txt_permission;

   private String app_device_txt_password;

   public long getApp_num_id()
   {
      return app_num_id;
   }

   public void setApp_num_id( long app_num_id )
   {
      this.app_num_id = app_num_id;
   }

   public String getDevice_num_id()
   {
      return device_txt_id;
   }

   public void setDevice_txt_id( String device_txt_id )
   {
      this.device_txt_id = device_txt_id;
   }

   public String getApp_device_txt_status()
   {
      return app_device_txt_status;
   }

   public void setApp_device_txt_status( String app_device_txt_status )
   {
      this.app_device_txt_status = app_device_txt_status;
   }

   public String getApp_device_txt_permission()
   {
      return app_device_txt_permission;
   }

   public void setApp_device_txt_permission( String app_device_txt_permission )
   {
      this.app_device_txt_permission = app_device_txt_permission;
   }

   public String getApp_device_txt_password()
   {
      return app_device_txt_password;
   }

   public void setApp_device_txt_password( String app_device_txt_password )
   {
      this.app_device_txt_password = app_device_txt_password;
   }
}
