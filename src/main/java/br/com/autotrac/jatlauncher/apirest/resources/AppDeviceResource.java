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
         appbackend.setAppTxtLabel( app.getAppTxtLabel() );
         appbackend.setAppTxtPackage( app.getAppTxtPackage() );
         appbackend = appBackendRepository.save( appbackend );
      }

      // Insere também na tabela por dispositivo.
      APP_DEVICE app_device = new APP_DEVICE();

      // Insere o App na tabela de apps por dispositivo.
      app_device.setAppNumId( appbackend.getAppNumId() );
      app_device.setAppDeviceNumStatus( app.getAppNumStatus() );
      app_device.setAppDeviceNumPermission( app.getAppNumPermission() );
      app_device.setAppDeviceTxtPassword( app.getAppTxtPassword() );
      app_device.setDeviceNumId( app.getDeviceNumId() );
      app_device = appDeviceRepository.save( app_device );

      return app_device;
   }

   @GetMapping( "/appdevice/{numId}" )
   @ApiOperation( value = "Retorna a lista de todos os Apps cadastrados para um dispositivo." )
   public List<APP> listAppDeviceOnly( @PathVariable( value = "numId" ) long numId )
   {
      List<APP> listApp = new ArrayList<APP>();

      List<APP_DEVICE> listAppDevice = new ArrayList<APP_DEVICE>();

      listAppDevice = appDeviceRepository.findAllBydeviceNumId( numId );

      if ( listAppDevice.size() > 0 )
      {
         for ( APP_DEVICE appDevice : listAppDevice )
         {
            APP app = new APP();
            app.setDeviceNumId( numId );
            app.setAppNumId( appDevice.getAppNumId() );
            app.setAppDeviceNumId( appDevice.getAppDeviceNumId() );
            app.setAppNumPermission( appDevice.getAppDeviceNumPermission() );
            app.setAppNumStatus( appDevice.getAppDeviceNumStatus() );
            app.setAppTxtPassword( appDevice.getAppDeviceTxtPassword() );
            APP_BACKEND appBackend = new APP_BACKEND();
            appBackend = appBackendRepository.findByAppNumId( appDevice.getAppNumId() );
            app.setAppTxtLabel( appBackend.getAppTxtLabel() );
            app.setAppTxtPackage( appBackend.getAppTxtPackage() );
            listApp.add( app );
         }
      }
      return listApp;
   }

   @DeleteMapping( "/appdevice/deleteApp/" )
   @ApiOperation( value = "Deleta um App de um dispositivo de acordo com o objeto informado." )
   public void deleteAppDevice( @RequestBody APP_DEVICE app_device )
   {
      appDeviceRepository.delete( app_device );
   }

   @DeleteMapping( "/appdevice/{id}" )
   public void deleteAppDeviceOnlyId( @PathVariable( value = "id" ) long id )
   {
      appDeviceRepository.deleteByAppDeviceNumId( id );
   }

   @PutMapping( "/appdevice" )
   @ApiOperation( value = "Faz uma alteração em um App de um dispositivo de acordo com o objeto informado." )
   public APP_DEVICE updateAppDevice( @RequestBody APP_DEVICE app_device )
   {
      return appDeviceRepository.save( app_device );
   }

}
