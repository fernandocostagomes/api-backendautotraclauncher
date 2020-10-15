package br.com.autotrac.jatlauncher.apirest.models;

/**
 * Classe que representa o objeto App.
 * 
 * @author fernando.gomes
 *
 */
public class APP
{

   private long deviceNumId;
   private long appNumId;
   private long appDeviceNumId;
   private String appTxtPackage;
   private String appTxtLabel;
   private long appNumStatus;
   private long appDeviceNumPermission;
   private String appTxtPassword;

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }

   public long getAppNumId()
   {
      return appNumId;
   }

   public void setAppNumId( long appNumId )
   {
      this.appNumId = appNumId;
   }

   public long getAppDeviceNumId()
   {
      return appDeviceNumId;
   }

   public void setAppDeviceNumId( long appDeviceNumId )
   {
      this.appDeviceNumId = appDeviceNumId;
   }

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

   public long getAppNumPermission()
   {
      return appDeviceNumPermission;
   }

   public void setAppNumPermission( long appTxtPermission )
   {
      this.appDeviceNumPermission = appTxtPermission;
   }

   public String getAppTxtPassword()
   {
      return appTxtPassword;
   }

   public void setAppTxtPassword( String appTxtPassword )
   {
      this.appTxtPassword = appTxtPassword;
   }
}
