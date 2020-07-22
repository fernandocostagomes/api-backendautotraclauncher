package br.com.autotrac.jatlauncher.apirest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   @GetMapping( "/koha_find/{string}" )
   @ApiOperation( value = "Retorna a lista de todos os registros com o termo buscado." )
   public List<KOHA> listKohaString( @PathVariable( value = "string" ) String string )
   {
      List<KOHA> listKoha = new ArrayList<KOHA>();
      List<KOHA> listKohaBackEnd = kohaRepository.findAll();
      for ( KOHA koha : listKohaBackEnd )
      {
         String title = koha.getTitle().toLowerCase();
         String author = koha.getAuthor().toLowerCase();
         String format = koha.getLiterary_format().toLowerCase();
         if ( title.contains( string ) || author.contains( string ) || format.contains( string ) )
            listKoha.add( koha );
      }

      return listKoha;
   }

   @GetMapping( "/koha_find/{string}" )
   @ApiOperation( value = "Retorna a lista de todos os registros com o termo buscado." )
   public List<KOHA> listKohaString( @PathVariable( value = "string" ) String string )
   {
      List<KOHA> listKoha = new ArrayList<KOHA>();
      List<KOHA> listKohaBackEnd = kohaRepository.findAll();
      for ( KOHA koha : listKohaBackEnd )
      {
         String title = koha.getTitle().toLowerCase();
         String author = koha.getAuthor().toLowerCase();
         String format = koha.getLiterary_format().toLowerCase();
         if ( title.contains( string ) || author.contains( string ) || format.contains( string ) )
            listKoha.add( koha );
      }

      return listKoha;
   }

   @GetMapping( "/koha/{id}" )
   @ApiOperation( value = "Retorna um único registro de acordo com o Id informado." )
   public KOHA listKohaId( @PathVariable( value = "id" ) long id )
   {
      return kohaRepository.findById( id );
   }

   @PostMapping( "/koha" )
   public KOHA insertKoha( @RequestBody KOHA koha )
   {
      return kohaRepository.save( koha );
   }
}
