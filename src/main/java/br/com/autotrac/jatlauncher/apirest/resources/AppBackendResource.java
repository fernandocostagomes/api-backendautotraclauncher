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

import br.com.autotrac.jatlauncher.apirest.models.APP_BACKEND;
import br.com.autotrac.jatlauncher.apirest.repository.AppBackendRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO APP" )
@CrossOrigin( origins = "*" )
public class AppBackendResource
{

   @Autowired
   AppBackendRepository appBackendRepository;

   @GetMapping( "/appserver" )
   @ApiOperation( value = "Retorna a lista de todos os Apps." )
   public List<APP_BACKEND> listApp()
   {
      return appBackendRepository.findAll();
   }

   @GetMapping( "/appserver/{id}" )
   @ApiOperation( value = "Retorna um único App de acordo com o Id informado." )
   public APP_BACKEND listAppOnlyId( @PathVariable( value = "id" ) long id )
   {
      return appBackendRepository.findByAppNumId( id );
   }

   @GetMapping( "/appserver_pkg/{pkg_name}" )
   @ApiOperation( value = "Retorna um único App de acordo com o nome do pacote informado." )
   public APP_BACKEND AppOnlyPackage( String pkg_name )
   {
      return appBackendRepository.findByAppTxtPackage( pkg_name );
   }

   @PostMapping( "/appserver" )
   @ApiOperation( value = "Grava um App." )
   public APP_BACKEND insertApp( @RequestBody APP_BACKEND app_backend )
   {
      return appBackendRepository.save( app_backend );
   }

   @DeleteMapping( "/appserver" )
   @ApiOperation( value = "Deleta um App de acordo com o objeto informado." )
   public void deleteApp( @RequestBody APP_BACKEND app )
   {
      appBackendRepository.delete( app );
   }

   @PutMapping( "/appserver" )
   @ApiOperation( value = "Faz uma alteração em um App de acordo com o objeto informado." )
   public APP_BACKEND updateApp( @RequestBody APP_BACKEND app )
   {
      return appBackendRepository.save( app );
   }
}
