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
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO DEVICE" )
@CrossOrigin( origins = "*" )
public class DeviceResource
{
   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/device" )
   public List<DEVICE> listDevice()
   {
      return deviceRepository.findAll();
   }

   @GetMapping( "/device/client/{clientId}" )
   public List<DEVICE> listDeviceClient( @PathVariable( value = "clientId" ) long clientId )
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

   @DeleteMapping( "/device" )
   public void deleteDevice( @RequestBody DEVICE device )
   {
      deviceRepository.delete( device );
   }

   @DeleteMapping( "/device/{id}" )
   public void deleteDeviceOnlyId( @PathVariable( value = "id" ) long id )
   {
      deviceRepository.deleteById( id );
   }

   @PutMapping( "/device" )
   public DEVICE updateDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }
}
