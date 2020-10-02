package br.com.autotrac.jatlauncher.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autotrac.jatlauncher.apirest.models.USERWEB;
import br.com.autotrac.jatlauncher.apirest.repository.UserwebRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO USER" )
@CrossOrigin( origins = "*" )
public class UserwebResource
{
   @Autowired
   UserwebRepository userwebRepository;

   @GetMapping( "/user" )
   @ApiOperation( value = "Retorna a lista de todos os Users." )
   public List<USERWEB> listUser()
   {
      return userwebRepository.findAll();
   }

   @GetMapping( "/user/{id}" )
   @ApiOperation( value = "Retorna um único Objeto de um User de acordo com o Id informado." )
   public USERWEB userOnly( @PathVariable( value = "id" ) long user_id )
   {
      return userwebRepository.findByUserwebNumId( user_id );
   }

   @PutMapping( "/user" )
   @ApiOperation( value = "Faz uma alteração em um User de acordo com o objeto informado." )
   public USERWEB updateApp( @RequestBody USERWEB user )
   {
      return userwebRepository.save( user );
   }

   @PostMapping( "/user" )
   @ApiOperation( value = "Grava um User." )
   public USERWEB insertApp( @RequestBody USERWEB user )
   {
      return userwebRepository.save( user );
   }

   @DeleteMapping( "/user" )
   @ApiOperation( value = "Deleta um User de acordo com o objeto informado." )
   public void deleteUser( @RequestBody USERWEB user )
   {
      userwebRepository.delete( user );
   }

   @PostMapping( "/user/requestUser" )
   @ApiOperation( value = "Retorna um usuário de acordo com o objeto requisitado." )
   public USERWEB userFromObject( @RequestBody USERWEB user )
   {
      USERWEB returnUser = new USERWEB();
      try
      {
         String requestUser = user.getUserwebTxtName();
         USERWEB userweb = userwebRepository.findByUserwebTxtName( requestUser );
         if ( userweb != null )
         {
            if ( user.getUserwebTxtPassword().equals( userweb.getUserwebTxtPassword() ) )
            {
               returnUser = userweb;
            }
            else
            {
               returnUser = user;
            }
         }
         else
         {
            returnUser = user;
         }
      }
      catch ( Exception p_e )
      {
         p_e.printStackTrace();
      }
      return returnUser;
   }
}
