package br.com.autotrac.jatlauncher.apirest.models;

public class PARAM
{
   private long paramNumId;
   private long deviceNumId;
   private long paramDeviceNumId;
   private String paramDeviceValue;
   private String paramDeviceOldValue;
   private long paramNumCod;
   private long paramNumType;

   public long getParamNumType()
   {
      return paramNumType;
   }

   public void setParamNumType( long paramNumType )
   {
      this.paramNumType = paramNumType;
   }

   public long getParamNumCod()
   {
      return paramNumCod;
   }

   public void setParamNumCod( long paramNumCod )
   {
      this.paramNumCod = paramNumCod;
   }

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

   public long getParamNumId()
   {
      return paramNumId;
   }

   public void setParamNumId( long paramNumId )
   {
      this.paramNumId = paramNumId;
   }

   public long getParamDeviceNumId()
   {
      return paramDeviceNumId;
   }

   public void setParamDeviceNumId( long paramDeviceNumId )
   {
      this.paramDeviceNumId = paramDeviceNumId;
   }

}
