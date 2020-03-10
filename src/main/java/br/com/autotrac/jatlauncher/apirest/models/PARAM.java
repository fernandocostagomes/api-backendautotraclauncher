package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table( name = "param" )
public class PARAM implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   private long param_num_id;

   private long param_num_cod;

   public long getParam_num_id()
   {
      return param_num_id;
   }

   public void setParam_num_id( long param_num_id )
   {
      this.param_num_id = param_num_id;
   }

   public long getParam_num_cod()
   {
      return param_num_cod;
   }

   public void setParam_num_cod( long param_num_cod )
   {
      this.param_num_cod = param_num_cod;
   }
}
