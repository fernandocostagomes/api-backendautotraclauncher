package br.com.autotrac.jatlauncher.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autotrac.jatlauncher.apirest.models.KOHA;
import br.com.autotrac.jatlauncher.apirest.repository.KohaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO KOHA" )
@CrossOrigin( origins = "*" )
public class KohaResource
{

   @Autowired
   KohaRepository kohaRepository;

   @GetMapping( "/koha" )
   @ApiOperation( value = "Retorna a lista com as requisições." )
   public List<KOHA> listKoha()
   {
      return kohaRepository.findAll();
   }

   @GetMapping( "/koha/{id}" )
   @ApiOperation( value = "Retorna um único registro de acordo com o Id informado." )
   public KOHA listKohaId( @PathVariable( value = "id" ) long id )
   {
      return kohaRepository.findByAppNumId( id );
   }
}
