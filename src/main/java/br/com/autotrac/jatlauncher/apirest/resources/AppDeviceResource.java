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

import br.com.autotrac.jatlauncher.apirest.models.APP;
import br.com.autotrac.jatlauncher.apirest.models.APP_BACKEND;
import br.com.autotrac.jatlauncher.apirest.models.APP_DEVICE;
import br.com.autotrac.jatlauncher.apirest.models.DEVICE;
import br.com.autotrac.jatlauncher.apirest.repository.AppBackendRepository;
import br.com.autotrac.jatlauncher.apirest.repository.AppDeviceRepository;
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO APP_DEVICE" )
@CrossOrigin( origins = "*" )
public class AppDeviceResource
{

   @Autowired
   AppDeviceRepository appDeviceRepository;

   @Autowired
   AppBackendRepository appBackendRepository;

   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/appdevice/listapppkg/{listPkg}" )
   @ApiOperation( value = "Retorna a lista dos apps solicitados e informa." )
   public List<APP_DEVICE> listAppDeviceAll( @PathVariable( value = "listPkg" ) List<String> listStringAllPkg )
   {
      List<APP_DEVICE> list = new ArrayList<APP_DEVICE>();

      for ( String string : listStringAllPkg )
      {
         APP_DEVICE app_DEVICE = appDeviceRepository.findByAppDeviceTxtPackage( string );
         if ( app_DEVICE == null )
         {
            APP_DEVICE app_DEVICE2 = new APP_DEVICE();
            app_DEVICE2.setAppDeviceTxtPackage( string );
            list.add( app_DEVICE2 );
         }
         else
            if ( app_DEVICE.getAppDeviceTxtPackage().equals( string ) )
            {
               list.add( app_DEVICE );
            }
      }
      return list;
   }

   @GetMapping( "/appdevice" )
   @ApiOperation( value = "Retorna a lista de todos os Apps cadastrados para todos os dispositivos." )
   public List<APP_DEVICE> listAppDeviceAll()
   {
      return appDeviceRepository.findAll();
   }

   @PostMapping( "/appdevice" )
   @ApiOperation( value = "Grava um App para um dispositivo." )
   public APP_DEVICE insertAppDevice( @RequestBody APP app )
   {
      // Serial do device que esta envolvido na insercao do app.
      DEVICE device = new DEVICE();
      device = deviceRepository.findByDeviceTxtSerial( app.getDeviceTxtSerial() );

      // Nome do app a ser inserido.
      String appReceived = app.getAppTxtPackage();

      // Pesquisando o app na tabela generica de apps.
      APP_BACKEND appbackend = new APP_BACKEND();
      appbackend = appBackendRepository.findByAppTxtPackage( appReceived );

      // Não existe na tabela generica de apps, então insere primeiro na tabela generica e resgata o id.
      if ( appbackend == null )
      {
         // Insere o App na tabela geral de Apps e resgata o id gerado para o mesmo.
         appbackend = new APP_BACKEND();
         appbackend.setAppNumId( 0 );
         appbackend.setAppTxtPackage( app.getAppTxtPackage() );
         appbackend.setAppTxtLabel( app.getAppTxtLabel() );
         appbackend = appBackendRepository.save( appbackend );
      }

      // Existe na tabela generica de apps.
      // Verificar se já não existe na tabela de app por dispositivo.
      APP_DEVICE app_device = new APP_DEVICE();
      app_device = appDeviceRepository.findByAppDeviceTxtPackage( app.getAppTxtPackage() );
      if ( app_device == null )
      {
         // Insere o App na tabela de apps por dispositivo.
         app_device = new APP_DEVICE();
         app_device.setAppNumId( appbackend.getAppNumId() );
         app_device.setAppDeviceTxtLabel( app.getAppTxtLabel() );
         app_device.setAppDeviceTxtPackage( app.getAppTxtPackage() );
         app_device.setAppDeviceNumStatus( app.getAppNumStatus() );
         app_device.setAppDeviceNumPermission( app.getAppTxtPermission() );
         app_device.setAppDeviceTxtPassword( app.getAppTxtPassword() );
         app_device.setDeviceNumId( device.getDeviceNumId() );
         app_device = appDeviceRepository.save( app_device );
      }
      else
      {
         // Já existe, retorna o app convertido para app device.
         app_device = appDeviceRepository.findByAppDeviceTxtPackage( app.getAppTxtPackage() );
      }
      return app_device;
   }

   @GetMapping( "/appdevice/{numId}" )
   @ApiOperation( value = "Retorna a lista de todos os Apps cadastrados para um dispositivo." )
   public List<APP_DEVICE> listAppDeviceOnly( @PathVariable( value = "numId" ) long numId )
   {
      return appDeviceRepository.findAllBydeviceNumId( numId );
   }

   @DeleteMapping( "/appdevice/deleteApp/" )
   @ApiOperation( value = "Deleta um App de um dispositivo de acordo com o objeto informado." )
   public void deleteAppDevice( @RequestBody APP_DEVICE app_device )
   {
      appDeviceRepository.delete( app_device );
   }

   @DeleteMapping( "/appdevice/deleteAppDeviceNumId/{id}" )
   @ApiOperation( value = "Deleta todos os apps de um dispositivo de acordo com o id informado." )
   public void deleteAppDeviceNumid( @PathVariable( value = "id" ) long deviceNumid )
   {
      appDeviceRepository.deleteAllByDeviceNumId( deviceNumid );
   }

   @PutMapping( "/appdevice" )
   @ApiOperation( value = "Faz uma alteração em um App de um dispositivo de acordo com o objeto informado." )
   public APP_DEVICE updateAppDevice( @RequestBody APP_DEVICE app_device )
   {
      return appDeviceRepository.save( app_device );
   }

   public boolean appOnlyPackage( String appDeviceTxtPackage )
   {
      boolean result = false;
      APP_DEVICE app_DEVICE = new APP_DEVICE();
      try
      {
         app_DEVICE = appDeviceRepository.findByAppDeviceTxtPackage( appDeviceTxtPackage );
         if ( app_DEVICE.getAppDeviceTxtPackage().equals( appDeviceTxtPackage ) )
            result = true;
      }
      catch ( Exception p_e )
      {
         p_e.printStackTrace();
      }

      return result;
   }
}
