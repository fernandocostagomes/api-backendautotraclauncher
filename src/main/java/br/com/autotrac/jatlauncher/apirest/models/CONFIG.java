package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table( name = "config" )
public class CONFIG implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   private long config_num_id;

   private long config_num_update;

   private String device_txt_id;

   public long getConfig_num_id()
   {
      return config_num_id;
   }

   public void setConfig_num_id( long config_num_id )
   {
      this.config_num_id = config_num_id;
   }

   public long getConfig_num_update()
   {
      return config_num_update;
   }

   public void setConfig_num_update( long config_num_update )
   {
      this.config_num_update = config_num_update;
   }

   public String getDevice_txt_id()
   {
      return device_txt_id;
   }

   public void setDevice_txt_id( String device_txt_id )
   {
      this.device_txt_id = device_txt_id;
   }

}
