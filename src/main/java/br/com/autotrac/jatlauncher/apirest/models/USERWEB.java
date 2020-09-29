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
@Table( name = "userweb" )
public class USERWEB implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column( nullable = false )
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long userwebNumId;

   @Column( nullable = false )
   private String userwebTxtName;

   @Column( nullable = false )
   private String userwebTxtPassword;

   @Column( nullable = false )
   private String userwebTxtEmail;

   @Column( nullable = false )
   private long permissionNumId;

   @Column( nullable = false )
   private long clientNumId;

   public long getUserwebNumId()
   {
      return userwebNumId;
   }

   public void setUserwebNumId( long userwebNumId )
   {
      this.userwebNumId = userwebNumId;
   }

   public String getUserwebTxtName()
   {
      return userwebTxtName;
   }

   public void setUserwebTxtName( String userwebTxtName )
   {
      this.userwebTxtName = userwebTxtName;
   }

   public String getUserwebTxtPassword()
   {
      return userwebTxtPassword;
   }

   public void setUserwebTxtPassword( String userwebTxtPassword )
   {
      this.userwebTxtPassword = userwebTxtPassword;
   }

   public String getUserwebTxtEmail()
   {
      return userwebTxtEmail;
   }

   public void setUserwebTxtEmail( String userwebTxtEmail )
   {
      this.userwebTxtEmail = userwebTxtEmail;
   }

   public long getPermissionNumId()
   {
      return permissionNumId;
   }

   public void setPermissionNumId( long permissionNumId )
   {
      this.permissionNumId = permissionNumId;
   }

   public long getClientNumId()
   {
      return clientNumId;
   }

   public void setClientNumId( long clientNumId )
   {
      this.clientNumId = clientNumId;
   }
}
