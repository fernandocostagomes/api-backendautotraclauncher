package br.com.autotrac.jatlauncher.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autotrac.jatlauncher.apirest.models.App;
import br.com.autotrac.jatlauncher.apirest.models.Appbackend;
import br.com.autotrac.jatlauncher.apirest.models.Appdevice;
import br.com.autotrac.jatlauncher.apirest.models.Device;
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
   public List<Appdevice> listAppDeviceAll()
   {
      return appDeviceRepository.findAll();
   }

   @PostMapping( "/appdevice" )
   @ApiOperation( value = "Grava um App para um dispositivo." )
   public Appdevice insertAppDevice( @RequestBody App app )
   {
      Device device = new Device();
      device = deviceRepository.findByDeviceTxtSerial( app.getDeviceTxtSerial() );

      Appbackend appbackend = new Appbackend();
      appbackend = appBackendRepository.findByAppTxtPackage( app.getAppTxtPackage() );
      // Verifica se ja tem o app cadastrado na tabela de apps generico.
      // Não existe.
      // if ( !app.getAppTxtPackage().equals( appbackend.getAppTxtPackage() ) || appbackend == null )
      if ( appbackend == null )
      {
         // Insere o App na tabela geral de Apps e resgata o id gerado para o mesmo.
         appbackend = new Appbackend();
         appbackend.setAppNumId( 0 );
         appbackend.setAppTxtPackage( app.getAppTxtPackage() );
         appbackend.setAppTxtLabel( app.getAppTxtLabel() );

         appbackend = appBackendRepository.save( appbackend );
      }
      // Existe
      // Insere o App na tabela de apps por dispositivo.
      Appdevice app_device = new Appdevice();
      app_device.setAppNumId( appbackend.getAppNumId() );
      app_device.setAppDeviceTxtLabel( app.getAppTxtLabel() );
      app_device.setAppDeviceTxtPackage( app.getAppTxtPackage() );
      app_device.setAppDeviceNumStatus( app.getAppNumStatus() );
      app_device.setAppDeviceNumPermission( app.getAppTxtPermission() );
      app_device.setAppDeviceTxtPassword( app.getAppTxtPassword() );
      app_device.setDeviceNumId( device.getDeviceNumId() );

      return appDeviceRepository.save( app_device );
   }

   @DeleteMapping( "/appdevice" )
   @ApiOperation( value = "Deleta um App de um dispositivo de acordo com o objeto informado." )
   public void deleteAppDevice( @RequestBody Appdevice app_device )
   {
      appDeviceRepository.delete( app_device );
   }

   @PutMapping( "/appdevice" )
   @ApiOperation( value = "Faz uma alteração em um App de um dispositivo de acordo com o objeto informado." )
   public Appdevice updateAppDevice( @RequestBody Appdevice app_device )
   {
      return appDeviceRepository.save( app_device );
   }
}
