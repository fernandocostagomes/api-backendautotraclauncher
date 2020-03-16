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
@Table( name = "device" )
public class Device implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column( nullable = false )
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long deviceNumId;

   @Column( nullable = false )
   @PrimaryKeyJoinColumn
   private String deviceTxtSerial;

   @Column( nullable = false )
   private String deviceTxtClient;

   @Column( nullable = false )
   private long deviceNumStatus;

   @Column( nullable = false )
   private String deviceTxtActivationKey;

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }

   public String getDeviceTxtSerial()
   {
      return deviceTxtSerial;
   }

   public void setDeviceTxtSerial( String deviceTxtSerial )
   {
      this.deviceTxtSerial = deviceTxtSerial;
   }

   public String getDeviceTxtClient()
   {
      return deviceTxtClient;
   }

   public void setDeviceTxtClient( String deviceTxtClient )
   {
      this.deviceTxtClient = deviceTxtClient;
   }

   public long getDeviceNumStatus()
   {
      return deviceNumStatus;
   }

   public void setDeviceNumStatus( long deviceNumStatus )
   {
      this.deviceNumStatus = deviceNumStatus;
   }

   public String getDeviceTxtActivationKey()
   {
      return deviceTxtActivationKey;
   }

   public void setDeviceTxtActivationKey( String deviceTxtActivationKey )
   {
      this.deviceTxtActivationKey = deviceTxtActivationKey;
   }
}
