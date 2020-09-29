package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "permission" )
public class PERMISSION implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column( nullable = false )
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long permissionNumId;

   @Column( nullable = false )
   private long permissionNumLevel;

   @Column( nullable = false )
   private String permissionTxtName;

   public long getPermissionNumId()
   {
      return permissionNumId;
   }

   public void setPermissionNumId( long permissionNumId )
   {
      this.permissionNumId = permissionNumId;
   }

   public long getPermissionNumLevel()
   {
      return permissionNumLevel;
   }

   public void setPermissionNumLevel( long permissionNumLevel )
   {
      this.permissionNumLevel = permissionNumLevel;
   }

   public String getPermissionTxtName()
   {
      return permissionTxtName;
   }

   public void setPermissionTxtName( String permissionTxtName )
   {
      this.permissionTxtName = permissionTxtName;
   }
}
