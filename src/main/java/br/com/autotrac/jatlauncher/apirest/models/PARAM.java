package br.com.autotrac.jatlauncher.apirest.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table( name = "PARAM" )
public class PARAM implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   private long mParamId;

   private long mParamName;

   public long getmParamId()
   {
      return mParamId;
   }

   public void setmParamId( long mParamId )
   {
      this.mParamId = mParamId;
   }

   public long getmParamName()
   {
      return mParamName;
   }

   public void setmParamName( long mParamName )
   {
      this.mParamName = mParamName;
   }
}
