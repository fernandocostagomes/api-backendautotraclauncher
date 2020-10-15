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
@Table( name = "app_device" )
public class APP_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long appDeviceNumId;

   @Column( nullable = false )
   private long appNumId;

   @Column( nullable = false )
   private long deviceNumId;

   @Column( nullable = false )
   private long appDeviceNumStatus;

   @Column( nullable = false )
   private long appDeviceNumPermission;

   @Column( nullable = false )
   private String appDeviceTxtPassword;

   public long getAppDeviceNumId()
   {
      return appDeviceNumId;
   }

   public void setAppDeviceNumId( long appDeviceNumId )
   {
      this.appDeviceNumId = appDeviceNumId;
   }

   public long getAppNumId()
   {
      return appNumId;
   }

   public void setAppNumId( long appNumId )
   {
      this.appNumId = appNumId;
   }

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }

   public long getAppDeviceNumStatus()
   {
      return appDeviceNumStatus;
   }

   public void setAppDeviceNumStatus( long appDeviceNumStatus )
   {
      this.appDeviceNumStatus = appDeviceNumStatus;
   }

   public long getAppDeviceNumPermission()
   {
      return appDeviceNumPermission;
   }

   public void setAppDeviceNumPermission( long appDeviceNumPermission )
   {
      this.appDeviceNumPermission = appDeviceNumPermission;
   }

   public String getAppDeviceTxtPassword()
   {
      return appDeviceTxtPassword;
   }

   public void setAppDeviceTxtPassword( String appDeviceTxtPassword )
   {
      this.appDeviceTxtPassword = appDeviceTxtPassword;
   }
}
