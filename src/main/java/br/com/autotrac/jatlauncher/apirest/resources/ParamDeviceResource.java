package br.com.autotrac.jatlauncher.apirest.resources;

import java.util.ArrayList;
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
import br.com.autotrac.jatlauncher.apirest.models.PARAM_BACKEND;
import br.com.autotrac.jatlauncher.apirest.models.PARAM_DEVICE;
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;
import br.com.autotrac.jatlauncher.apirest.repository.ParamBackendRepository;
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

   @Autowired
   ParamBackendRepository paramBackendRepository;

   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/paramdevice" )
   @ApiOperation( value = "Retorna a lista de todos os Parametros de todos os Devices." )
   public List<PARAM_DEVICE> listParamDevice()
   {
      return paramDeviceRepository.findAll();
   }

   @GetMapping( "/paramdevice/{id}" )
   @ApiOperation( value = "Retorna uma lista com todos os parâmetros de um Device de acordo com o Id informado." )
   public List<PARAM> listParamDeviceOnly( @PathVariable( value = "id" ) long device_num_id )
   {
      List<PARAM> listParam = new ArrayList<PARAM>();
      List<PARAM_DEVICE> listParamDevice = new ArrayList<PARAM_DEVICE>();

      listParamDevice = paramDeviceRepository.findAllByDeviceNumId( device_num_id );

      for ( PARAM_DEVICE item_param : listParamDevice )
      {
         PARAM param = new PARAM();
         param.setDeviceNumId( item_param.getDeviceNumId() );
         param.setParamNumId( item_param.getParamNumId() );
         param.setParamDeviceNumId( item_param.getParamDeviceNumId() );
         param.setParamDeviceValue( item_param.getParamDeviceValue() );
         param.setParamDeviceOldValue( item_param.getParamDeviceOldValue() );
         long codParam = paramBackendRepository.findById( item_param.getParamNumId() ).getParamNumCod();
         long typeParam = paramBackendRepository.findById( item_param.getParamNumId() ).getParamNumType();
         param.setParamNumCod( codParam );
         param.setParamNumType( typeParam );
         listParam.add( param );
      }
      return listParam;
   }

   @PostMapping( "/paramdevice" )
   @ApiOperation( value = "Grava um Param para um dispositivo." )
   public PARAM_DEVICE insertParamDevice( @RequestBody PARAM parameter )
   {
      // Cod do parametro
      long codParam = parameter.getParamNumCod();

      // Pesquisando o parametro na tabela generica de parametros.
      PARAM_BACKEND param_backend = new PARAM_BACKEND();
      param_backend = paramBackendRepository.findByParamNumCod( codParam );

      // Não existe na tabela generica de parametros, então insere primeiro na tabela generica e resgata o id.
      if ( param_backend == null )
      {
         // Insere o Param na tabela geral de Param e resgata o id gerado para o mesmo.
         param_backend = new PARAM_BACKEND();
         param_backend.setParamNumId( 0 );
         param_backend.setParamNumCod( parameter.getParamNumCod() );
         param_backend.setParamNumType( parameter.getParamNumType() );
         param_backend = paramBackendRepository.save( param_backend );
      }

      // Insere o App na tabela de apps por dispositivo.
      PARAM_DEVICE param_device = new PARAM_DEVICE();
      param_device.setDeviceNumId( parameter.getDeviceNumId() );
      param_device.setParamDeviceValue( parameter.getParamDeviceValue() );
      param_device.setParamDeviceOldValue( parameter.getParamDeviceOldValue() );
      param_device.setParamNumId( param_backend.getParamNumId() );
      param_device = paramDeviceRepository.save( param_device );

      return param_device;
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
