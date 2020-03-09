package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table
public class APP_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   private long mAppId;

   private long mDeviceId;

   private Character mAppDeviceStatus;

   private Character mAppDevicePermission;

   private Character mAppDevicePassword;

   public long getmAppId()
   {
      return mAppId;
   }

   public void setmAppId( long mAppId )
   {
      this.mAppId = mAppId;
   }

   public long getmDeviceId()
   {
      return mDeviceId;
   }

   public void setmDeviceId( long mDeviceId )
   {
      this.mDeviceId = mDeviceId;
   }

   public Character getmAppDeviceStatus()
   {
      return mAppDeviceStatus;
   }

   public void setmAppDeviceStatus( Character mAppDeviceStatus )
   {
      this.mAppDeviceStatus = mAppDeviceStatus;
   }

   public Character getmAppDevicePermission()
   {
      return mAppDevicePermission;
   }

   public void setmAppDevicePermission( Character mAppDevicePermission )
   {
      this.mAppDevicePermission = mAppDevicePermission;
   }

   public Character getmAppDevicePassword()
   {
      return mAppDevicePassword;
   }

   public void setmAppDevicePassword( Character mAppDevicePassword )
   {
      this.mAppDevicePassword = mAppDevicePassword;
   }
}
