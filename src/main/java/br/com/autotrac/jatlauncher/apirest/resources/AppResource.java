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

import br.com.autotrac.jatlauncher.apirest.models.APP;
import br.com.autotrac.jatlauncher.apirest.repository.AppRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO APP" )
@CrossOrigin( origins = "*" )
public class AppResource
{

   @Autowired
   AppRepository appRepository;

   @GetMapping( "/appall" )
   @ApiOperation( value = "Retorna a lista de todos os Apps." )
   public List<APP> listApp()
   {
      return appRepository.findAll();
   }

   @GetMapping( "/app_only/{id}" )
   @ApiOperation( value = "Retorna um único App de acordo com o Id informado." )
   public APP listAppOnly( @PathVariable( value = "id" ) long id )
   {
      return appRepository.findById( id );
   }

   @PostMapping( "/app_insert" )
   @ApiOperation( value = "Grava um App." )
   public APP insertApp( @RequestBody APP app )
   {
      return appRepository.save( app );
   }

   @DeleteMapping( "/app_delete" )
   @ApiOperation( value = "Deleta um App de acordo com o objeto informado." )
   public void deleteApp( @RequestBody APP app )
   {
      appRepository.delete( app );
   }

   @PutMapping( "/app_update" )
   @ApiOperation( value = "Faz uma alteração em um App de acordo com o objeto informado." )
   public APP updateApp( @RequestBody APP app )
   {
      return appRepository.save( app );
   }
}
