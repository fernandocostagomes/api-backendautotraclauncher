package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

public class App implements Serializable
{
   private static final long serialVersionUID = 1L;

   private String appTxtPackage;
   private String appTxtLabel;
   private long appNumStatus;
   private long appTxtPermission;
   private String appTxtPassword;
   private String deviceTxtSerial;

   public String getAppTxtPackage()
   {
      return appTxtPackage;
   }

   public void setAppTxtPackage( String appTxtPackage )
   {
      this.appTxtPackage = appTxtPackage;
   }

   public String getAppTxtLabel()
   {
      return appTxtLabel;
   }

   public void setAppTxtLabel( String appTxtLabel )
   {
      this.appTxtLabel = appTxtLabel;
   }

   public long getAppNumStatus()
   {
      return appNumStatus;
   }

   public void setAppNumStatus( long appNumStatus )
   {
      this.appNumStatus = appNumStatus;
   }

   public long getAppTxtPermission()
   {
      return appTxtPermission;
   }

   public void setAppTxtPermission( long appTxtPermission )
   {
      this.appTxtPermission = appTxtPermission;
   }

   public String getAppTxtPassword()
   {
      return appTxtPassword;
   }

   public void setAppTxtPassword( String appTxtPassword )
   {
      this.appTxtPassword = appTxtPassword;
   }

   public String getDeviceTxtSerial()
   {
      return deviceTxtSerial;
   }

   public void setDeviceTxtSerial( String deviceTxtSerial )
   {
      this.deviceTxtSerial = deviceTxtSerial;
   }
}
