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
@Table( name = "param_device" )
public class PARAM_DEVICE implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long paramDeviceNumId;

   @Column
   private String paramDeviceValue;

   @Column
   private String paramDeviceOldValue;

   @Column
   private long deviceNumId;

   public long getParamDeviceNumId()
   {
      return paramDeviceNumId;
   }

   public void setParamDeviceNumId( long paramDeviceNumId )
   {
      this.paramDeviceNumId = paramDeviceNumId;
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

   public long getDeviceNumId()
   {
      return deviceNumId;
   }

   public void setDeviceNumId( long deviceNumId )
   {
      this.deviceNumId = deviceNumId;
   }
}
