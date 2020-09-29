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

import br.com.autotrac.jatlauncher.apirest.models.CLIENT;
import br.com.autotrac.jatlauncher.apirest.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO CLIENT" )
@CrossOrigin( origins = "*" )
public class ClientResource
{
   @Autowired
   ClientRepository clientRepository;

   @GetMapping( "/client" )
   @ApiOperation( value = "Retorna a lista de todos os Clients." )
   public List<CLIENT> listClient()
   {
      return clientRepository.findAll();
   }

   @GetMapping( "/client/{id}" )
   @ApiOperation( value = "Retorna um único Objeto de um Client de acordo com o Id informado." )
   public CLIENT clientOnly( @PathVariable( value = "id" ) long client_id )
   {
      return clientRepository.findByClientNumId( client_id );
   }

   @PutMapping( "/client" )
   @ApiOperation( value = "Faz uma alteração em um Client de acordo com o objeto informado." )
   public CLIENT updateApp( @RequestBody CLIENT client )
   {
      return clientRepository.save( client );
   }

   @PostMapping( "/client" )
   @ApiOperation( value = "Grava um Client." )
   public CLIENT insertApp( @RequestBody CLIENT client )
   {
      return clientRepository.save( client );
   }

   @DeleteMapping( "/client" )
   @ApiOperation( value = "Deleta um Client de acordo com o objeto informado." )
   public void deleteClient( @RequestBody CLIENT client )
   {
      clientRepository.delete( client );
   }
}
