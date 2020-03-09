package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "device" )
public class DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   private String device_txt_id;

   private String device_txt_client;

   public String getDevice_txt_id()
   {
      return device_txt_id;
   }

   public void setDevice_txt_id( String device_txt_id )
   {
      this.device_txt_id = device_txt_id;
   }

   public String getDevice_txt_client()
   {
      return device_txt_client;
   }

   public void setDevice_txt_client( String device_txt_client )
   {
      this.device_txt_client = device_txt_client;
   }
}
