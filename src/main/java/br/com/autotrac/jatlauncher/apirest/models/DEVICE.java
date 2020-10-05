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
public class DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column( nullable = false )
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long deviceNumId;

   @Column( nullable = false )
   private String deviceTxtName;

   @Column( nullable = false )
   @PrimaryKeyJoinColumn
   private String deviceTxtSerial;

   @Column( nullable = false )
   private long clientNumId;

   @Column( nullable = false )
   private long deviceNumStatus;

   @Column( nullable = false )
   private String deviceTxtActivationKey;

   @Column( nullable = false )
   private long deviceNumUpdateFlag;

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }

   public String getDeviceTxtName()
   {
      return deviceTxtName;
   }

   public void setDeviceTxtName( String deviceTxtName )
   {
      this.deviceTxtName = deviceTxtName;
   }

   public String getDeviceTxtSerial()
   {
      return deviceTxtSerial;
   }

   public void setDeviceTxtSerial( String deviceTxtSerial )
   {
      this.deviceTxtSerial = deviceTxtSerial;
   }

   public long getClientNumId()
   {
      return clientNumId;
   }

   public void setClientNumId( long clientNumId )
   {
      this.clientNumId = clientNumId;
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

   public long getDeviceNumUpdateFlag()
   {
      return deviceNumUpdateFlag;
   }

   public void setDeviceNumUpdateFlag( long deviceNumUpdateFlag )
   {
      this.deviceNumUpdateFlag = deviceNumUpdateFlag;
   }
}
