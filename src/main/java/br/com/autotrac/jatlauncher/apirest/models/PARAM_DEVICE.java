package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table( name = "param_device" )
public class PARAM_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   private long param_device_num_id;

   private String device_txt_id;

   private String param_device_value;

   private String param_device_old_value;

   public long getParam_device_num_id()
   {
      return param_device_num_id;
   }

   public void setParam_device_num_id( long param_device_num_id )
   {
      this.param_device_num_id = param_device_num_id;
   }

   public String getDevice_txt_id()
   {
      return device_txt_id;
   }

   public void setDevice_txt_id( String device_txt_id )
   {
      this.device_txt_id = device_txt_id;
   }

   public String getParam_device_value()
   {
      return param_device_value;
   }

   public void setParam_device_value( String param_device_value )
   {
      this.param_device_value = param_device_value;
   }

   public String getParam_device_old_value()
   {
      return param_device_old_value;
   }

   public void setParam_device_old_value( String param_device_old_value )
   {
      this.param_device_old_value = param_device_old_value;
   }
}
