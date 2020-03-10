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

import br.com.autotrac.jatlauncher.apirest.models.APP_DEVICE;
import br.com.autotrac.jatlauncher.apirest.repository.AppDeviceRepository;
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

   @GetMapping( "/app_device_all" )
   @ApiOperation( value = "Retorna a lista de todos os Apps cadastrados para todos os dispositivos." )
   public List<APP_DEVICE> listAppDevice()
   {
      return appDeviceRepository.findAll();
   }

   @PostMapping( "/app_device_insert" )
   @ApiOperation( value = "Grava um App para um dispositivo." )
   public APP_DEVICE insertAppDevice( @RequestBody APP_DEVICE app_device )
   {
      return appDeviceRepository.save( app_device );
   }

   @DeleteMapping( "/app_device_delete" )
   @ApiOperation( value = "Deleta um App de um dispositivo de acordo com o objeto informado." )
   public void deleteAppDevice( @RequestBody APP_DEVICE app_device )
   {
      appDeviceRepository.delete( app_device );
   }

   @PutMapping( "/app_device_update" )
   @ApiOperation( value = "Faz uma alteração em um App de um dispositivo de acordo com o objeto informado." )
   public APP_DEVICE updateAppDevice( @RequestBody APP_DEVICE app_device )
   {
      return appDeviceRepository.save( app_device );
   }
}