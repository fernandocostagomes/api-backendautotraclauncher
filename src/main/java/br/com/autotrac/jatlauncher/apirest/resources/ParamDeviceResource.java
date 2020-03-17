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

import br.com.autotrac.jatlauncher.apirest.models.PARAM_DEVICE;
import br.com.autotrac.jatlauncher.apirest.repository.ParamDeviceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO PARAM_DEVICE" )
@CrossOrigin( origins = "*" )
public class ParamDeviceResource
{

   @Autowired
   ParamDeviceRepository paramDeviceRepository;

   @GetMapping( "/paramdevice" )
   @ApiOperation( value = "Retorna a lista de todos os Parametros de todos os Devices." )
   public List<PARAM_DEVICE> listParamDevice()
   {
      return paramDeviceRepository.findAll();
   }

   @GetMapping( "/paramdevice/{id}" )
   @ApiOperation( value = "Retorna um único Parâmetro de um Device de acordo com o Id informado." )
   public PARAM_DEVICE listParamDeviceOnly( @PathVariable( value = "id" ) long id )
   {
      return paramDeviceRepository.findById( id );
   }

   @PostMapping( "/paramdevice" )
   @ApiOperation( value = "Grava um Parâmetro de um Device." )
   public PARAM_DEVICE insertParamDevice( @RequestBody PARAM_DEVICE param_device )
   {
      return paramDeviceRepository.save( param_device );
   }

   @DeleteMapping( "/paramdevice" )
   @ApiOperation( value = "Deleta um Parâmetro de um Device de acordo com o objeto informado." )
   public void deleteParamDevice( @RequestBody PARAM_DEVICE param_device )
   {
      paramDeviceRepository.delete( param_device );
   }

   @PutMapping( "/paramdevice" )
   @ApiOperation( value = "Faz uma alteração em um Parâmetro de um Device de acordo com o objeto informado." )
   public PARAM_DEVICE updateParamDevice( @RequestBody PARAM_DEVICE param_device )
   {
      return paramDeviceRepository.save( param_device );
   }
}
