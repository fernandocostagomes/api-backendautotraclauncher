package br.com.autotrac.jatlauncher.apirest.models;

public class PARAM
{
   private long deviceNumId;
   private String paramDeviceValue;
   private String paramDeviceOldValue;
   private long paramNumCod;

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }

   public String getParamDeviceValue()
   {
      return paramDeviceValue;
   }

   public void setParamDeviceValue( String paramDeviceValue )
   {
      this.paramDeviceValue = paramDeviceValue;
   }

   public String getParamDeviceOldValue()
   {
      return paramDeviceOldValue;
   }

   public void setParamDeviceOldValue( String paramDeviceOldValue )
   {
      this.paramDeviceOldValue = paramDeviceOldValue;
   }

   public long getParamNumCod()
   {
      return paramNumCod;
   }

   public void setParamNumCod( long paramNumCod )
   {
      this.paramNumCod = paramNumCod;
   }
}
