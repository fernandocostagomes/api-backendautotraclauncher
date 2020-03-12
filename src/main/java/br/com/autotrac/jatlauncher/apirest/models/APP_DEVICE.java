package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Embeddable
@Table( name = "app_device" )
public class APP_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long appDeviceNumId;

   @Column
   private long appNumId;

   @Column
   private long deviceNumId;

   private String appDeviceTxtPackage;

   private String appDeviceTxtLabel;

   @Column
   private long appDeviceNumStatus;

   @Column
   private long appDeviceNumPermission;

   @Column
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

   public String getAppDeviceTxtPackage()
   {
      return appDeviceTxtPackage;
   }

   public void setAppDeviceTxtPackage( String appDeviceTxtPackage )
   {
      this.appDeviceTxtPackage = appDeviceTxtPackage;
   }

   public String getAppDeviceTxtLabel()
   {
      return appDeviceTxtLabel;
   }

   public void setAppDeviceTxtLabel( String appDeviceTxtLabel )
   {
      this.appDeviceTxtLabel = appDeviceTxtLabel;
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
