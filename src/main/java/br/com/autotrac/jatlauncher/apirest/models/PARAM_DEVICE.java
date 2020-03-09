package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table( name = "PARAM_DEVICE" )
public class PARAM_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   private Character mDeviceId;

   private long mParamId;

   private Character mParamDeviceValue;

   private Character mParamDeviceOldValue;

   public Character getmDeviceId()
   {
      return mDeviceId;
   }

   public void setmDeviceId( Character mDeviceId )
   {
      this.mDeviceId = mDeviceId;
   }

   public long getmParamId()
   {
      return mParamId;
   }

   public void setmParamId( long mParamId )
   {
      this.mParamId = mParamId;
   }

   public Character getmParamDeviceValue()
   {
      return mParamDeviceValue;
   }

   public void setmParamDeviceValue( Character mParamDeviceValue )
   {
      this.mParamDeviceValue = mParamDeviceValue;
   }

   public Character getmParamDeviceOldValue()
   {
      return mParamDeviceOldValue;
   }

   public void setmParamDeviceOldValue( Character mParamDeviceOldValue )
   {
      this.mParamDeviceOldValue = mParamDeviceOldValue;
   }

}
