package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table( name = "CONFIG" )
public class CONFIG implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Character mConfigUpdate;

   private long mDeviceId;

   public Character getmConfigUpdate()
   {
      return mConfigUpdate;
   }

   public void setmConfigUpdate( Character mConfigUpdate )
   {
      this.mConfigUpdate = mConfigUpdate;
   }

   public long getmDeviceId()
   {
      return mDeviceId;
   }

   public void setmDeviceId( long mDeviceId )
   {
      this.mDeviceId = mDeviceId;
   }
}
