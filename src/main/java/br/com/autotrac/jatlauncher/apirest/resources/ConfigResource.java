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

import br.com.autotrac.jatlauncher.apirest.models.Config;
import br.com.autotrac.jatlauncher.apirest.repository.ConfigRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO CONFIG" )
@CrossOrigin( origins = "*" )
public class ConfigResource
{

   @Autowired
   ConfigRepository configRepository;

   @GetMapping( "/config" )
   @ApiOperation( value = "Retorna a lista de todas as configurações." )
   public List<Config> listConfig()
   {
      return configRepository.findAll();
   }

   @GetMapping( "/config/{id}" )
   @ApiOperation( value = "Retorna uma único Configuração de acordo com o Id informado." )
   public Config listConfigOnly( @PathVariable( value = "id" ) long id )
   {
      return configRepository.findById( id );
   }

   @PostMapping( "/config" )
   @ApiOperation( value = "Grava uma Configuração." )
   public Config insertConfig( @RequestBody Config config )
   {
      return configRepository.save( config );
   }

   @DeleteMapping( "/config" )
   @ApiOperation( value = "Deleta uma Configuração de acordo com o objeto informado." )
   public void deleteConfig( @RequestBody Config config )
   {
      configRepository.delete( config );
   }

   @PutMapping( "/config" )
   @ApiOperation( value = "Faz uma alteração em uma Config de acordo com o objeto informado." )
   public Config updateConfig( @RequestBody Config config )
   {
      return configRepository.save( config );
   }
}
