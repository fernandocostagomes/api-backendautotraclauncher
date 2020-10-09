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

import br.com.autotrac.jatlauncher.apirest.models.DEVICE;
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
      List<PARAM_DEVICE> listParamDevice = new ArrayList<PARAM_DEVICE>();
      listParamDevice = paramDeviceRepository.findAllByDeviceNumId( device_num_id );
      List<PARAM> listParam = new ArrayList<PARAM>();
      for ( PARAM_DEVICE item_param : listParamDevice )
      {
         PARAM param = new PARAM();
         param.setDeviceNumId( item_param.getDeviceNumId() );
         param.setParamDeviceValue( item_param.getParamDeviceValue() );
         param.setParamDeviceOldValue( item_param.getParamDeviceOldValue() );
         long codParam = paramBackendRepository.findById( item_param.getParamNumId() ).getParamNumCod();
         param.setParamNumCod( codParam );
         listParam.add( param );
      }
      return listParam;
   }

   @PostMapping( "/paramdevice" )
   @ApiOperation( value = "Grava um Param para um dispositivo." )
   public PARAM_DEVICE insertParamDevice( @RequestBody PARAM parameter )
   {
      // Id do device que esta envolvido na insercao do app.
      DEVICE device = new DEVICE();
      device = deviceRepository.findById( parameter.getDeviceNumId() );
      long idDevice = device.getDeviceNumId();

      // Obtendo o codigo do parametro a ser inserido, pesquisando pelo codigo do param.
      long receivedAppCod = parameter.getParamNumCod();

      // Pesquisando o parametro na tabela generica de parametros.
      PARAM_BACKEND param_backend = new PARAM_BACKEND();
      param_backend = paramBackendRepository.findByParamNumCod( receivedAppCod );

      // Não existe na tabela generica de parametros, então insere primeiro na tabela generica e resgata o id.
      if ( param_backend == null )
      {
         // Insere o Param na tabela geral de Param e resgata o id gerado para o mesmo.
         param_backend = new PARAM_BACKEND();
         param_backend.setParamNumId( 0 );
         param_backend.setParamNumCod( parameter.getParamNumCod() );
         param_backend.setParamNumType( 1 );
         param_backend = paramBackendRepository.save( param_backend );
      }

      // Resgata o id do app da tabela generica.
      long idAppGen = paramBackendRepository.findByParamNumCod( parameter.getParamNumCod() ).getParamNumId();

      // Verificar se já não existe na tabela de param por dispositivo.
      PARAM_DEVICE param_device1 = new PARAM_DEVICE();
      param_device1 = paramDeviceRepository.findByParamNumId( idAppGen );

      // Insere o App na tabela de apps por dispositivo.
      param_device1 = new PARAM_DEVICE();
      param_device1.setDeviceNumId( parameter.getDeviceNumId() );
      param_device1.setParamDeviceValue( parameter.getParamDeviceValue() );
      param_device1.setParamDeviceOldValue( parameter.getParamDeviceOldValue() );
      param_device1.setParamNumId( idAppGen );
      param_device1 = paramDeviceRepository.save( param_device1 );

      return param_device1;
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
