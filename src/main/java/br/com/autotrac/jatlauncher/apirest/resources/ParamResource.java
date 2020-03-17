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

import br.com.autotrac.jatlauncher.apirest.models.PARAM;
import br.com.autotrac.jatlauncher.apirest.repository.ParamRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO PARAM" )
@CrossOrigin( origins = "*" )
public class ParamResource
{

   @Autowired
   ParamRepository paramRepository;

   @GetMapping( "/param" )
   @ApiOperation( value = "Retorna a lista de todos os Parâmetros." )
   public List<PARAM> listParam()
   {
      return paramRepository.findAll();
   }

   @GetMapping( "/param/{id}" )
   @ApiOperation( value = "Retorna um único Parâmetro de acordo com o Id informado." )
   public PARAM listParamOnly( @PathVariable( value = "id" ) long id )
   {
      return paramRepository.findById( id );
   }

   @PostMapping( "/param" )
   @ApiOperation( value = "Grava um Parâmetro." )
   public PARAM insertParam( @RequestBody PARAM param )
   {
      return paramRepository.save( param );
   }

   @DeleteMapping( "/param" )
   @ApiOperation( value = "Deleta um Parâmetro de acordo com o objeto informado." )
   public void deleteParam( @RequestBody PARAM param )
   {
      paramRepository.delete( param );
   }

   @PutMapping( "/param" )
   @ApiOperation( value = "Faz uma alteração em um Parâmetro de acordo com o objeto informado." )
   public PARAM updateParam( @RequestBody PARAM param )
   {
      return paramRepository.save( param );
   }
}
