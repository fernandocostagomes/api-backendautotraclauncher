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
import br.com.autotrac.jatlauncher.apirest.repository.AppDeviceRepository;
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;
import br.com.autotrac.jatlauncher.apirest.repository.ParamDeviceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO DEVICE" )
@CrossOrigin( origins = "*" )
public class DeviceResource
{
   @Autowired
   DeviceRepository deviceRepository;

   @Autowired
   AppDeviceRepository appDeviceRepository;

   @Autowired
   ParamDeviceRepository paramDeviceRepository;

   @GetMapping( "/device" )
   public List<DEVICE> listDevice()
   {
      return deviceRepository.findAll();
   }

   @GetMapping( "/device_cli/{id}" )
   @ApiOperation( value = "Retorna os dispositivos de um único client de acordo com o Id informado." )
   public List<DEVICE> listDeviceClient( @PathVariable( value = "id" ) long clientId )
   {
      return deviceRepository.findAllByClientNumId( clientId );
   }

   @GetMapping( "/device/{serial}" )
   public DEVICE getDeviceOnly( @PathVariable( value = "serial" ) String serial )
   {
      return deviceRepository.findByDeviceTxtSerial( serial );
   }

   @PostMapping( "/device" )
   public DEVICE insertDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }

   @DeleteMapping( "/device/{id}" )
   public void deleteDeviceOnlyId( @PathVariable( value = "id" ) long id )
   {
      // Apagando os apps.
      appDeviceRepository.deleteAllByDeviceNumId( id );
      // Apagando os parametros.
      paramDeviceRepository.deleteAllByDeviceNumId( id );
      // Apagando o dispositivo
      deviceRepository.deleteById( id );
   }

   @PutMapping( "/device" )
   public DEVICE updateDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }
}
