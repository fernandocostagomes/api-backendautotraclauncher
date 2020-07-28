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

import br.com.autotrac.jatlauncher.apirest.models.DEVICE;
import br.com.autotrac.jatlauncher.apirest.models.PARAM;
import br.com.autotrac.jatlauncher.apirest.models.PARAM_DEVICE;
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;
import br.com.autotrac.jatlauncher.apirest.repository.ParamDeviceRepository;
import br.com.autotrac.jatlauncher.apirest.repository.ParamRepository;
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
   ParamRepository paramRepository;

   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/paramdevice" )
   @ApiOperation( value = "Retorna a lista de todos os Parametros de todos os Devices." )
   public List<PARAM_DEVICE> listParamDevice()
   {
      return paramDeviceRepository.findAll();
   }

   @GetMapping( "/paramdevice/{id}" )
   @ApiOperation( value = "Retorna um único Parâmetro de um Device de acordo com o Id informado." )
   public List<PARAM_DEVICE> listParamDeviceOnly( @PathVariable( value = "id" ) long device_num_id )
   {
      return paramDeviceRepository.findAllByDeviceNumId( device_num_id );
   }

   @PostMapping( "/paramdevice" )
   @ApiOperation( value = "Grava um Param para um dispositivo." )
   public PARAM_DEVICE insertParamDevice( @RequestBody PARAM_DEVICE param_device )
   {
      // Serial do device que esta envolvido na insercao do app.
      DEVICE device = new DEVICE();
      device = deviceRepository.findById( param_device.getDeviceNumId() );

      // Numero do parametro a ser inserido.
      long appReceived = param_device.getDeviceNumId();

      // Pesquisando o parametro na tabela generica de parametros.
      PARAM param = new PARAM();
      param = paramRepository.findById( appReceived );

      // Não existe na tabela generica de parametros, então insere primeiro na tabela generica e resgata o id.
      if ( param == null )
      {
         // Insere o Param na tabela geral de Param e resgata o id gerado para o mesmo.
         param = new PARAM();
         param.setParamNumId( 0 );
         param.setParamNumCod( param_device.getParamDeviceNumId() );
         param.setParamNumType( 1 );
         param = paramRepository.save( param );
      }

      // Verificar se já não existe na tabela de param por dispositivo.
      PARAM_DEVICE param_device1 = new PARAM_DEVICE();
      if ( !paramOnlyCod( param_device.getParamNumCod() ) )
      {
         // Insere o App na tabela de apps por dispositivo.
         param_device1.setParamNumCod( param.getParamNumCod() );
         param_device1.setParamDeviceValue( param_device.getParamDeviceValue() );
         param_device1.setParamDeviceOldValue( param_device.getParamDeviceOldValue() );
         param_device1 = paramDeviceRepository.save( param_device1 );
      }
      else
      {
         param_device1 = paramDeviceRepository.findById( param_device.getParamDeviceNumId() );

      }
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

   public boolean paramOnlyCod( long paramDeviceCod )
   {
      boolean result = false;
      PARAM_DEVICE param_DEVICE = new PARAM_DEVICE();
      try
      {
         param_DEVICE = paramDeviceRepository.findByParamNumCod( paramDeviceCod );
         if ( param_DEVICE.getParamNumCod() == param_DEVICE.getParamNumCod() )
            result = true;
      }
      catch ( Exception p_e )
      {
         p_e.printStackTrace();
      }

      return result;
   }
}
