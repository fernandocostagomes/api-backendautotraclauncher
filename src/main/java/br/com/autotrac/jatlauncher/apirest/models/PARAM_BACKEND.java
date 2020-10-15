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
@Table( name = "param_backend" )
public class PARAM_BACKEND implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column
   @PrimaryKeyJoinColumn
   @GeneratedValue( strategy = GenerationType.AUTO )
   private long paramNumId;

   @Column( nullable = false )
   private long paramNumCod;

   @Column( nullable = false )
   private long paramNumType;

   public long getParamNumId()
   {
      return paramNumId;
   }

   public void setParamNumId( long paramNumId )
   {
      this.paramNumId = paramNumId;
   }

   public long getParamNumCod()
   {
      return paramNumCod;
   }

   public void setParamNumCod( long paramNumCod )
   {
      this.paramNumCod = paramNumCod;
   }

   public long getParamNumType()
   {
      return paramNumType;
   }

   public void setParamNumType( long paramNumType )
   {
      this.paramNumType = paramNumType;
   }
}
