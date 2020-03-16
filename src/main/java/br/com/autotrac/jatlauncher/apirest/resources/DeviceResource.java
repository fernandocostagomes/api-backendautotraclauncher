package br.com.autotrac.jatlauncher.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autotrac.jatlauncher.apirest.models.Device;
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;

@RestController
@RequestMapping( value = "/api/v1" )
public class DeviceResource
{
   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/device" )
   public List<Device> listDevice()
   {
      return deviceRepository.findAll();
   }

   @GetMapping( "/device/{id}" )
   public Device listDeviceOnly( @PathVariable( value = "id" ) long id )
   {
      return deviceRepository.findById( id );
   }

   @GetMapping( "/device/{serial}" )
   public Device listDeviceOnly( @PathVariable( value = "id" ) String serial )
   {
      return deviceRepository.findByDeviceTxtSerial( serial );
   }

   @PostMapping( "/device" )
   public Device insertDevice( @RequestBody Device device )
   {
      return deviceRepository.save( device );
   }

   @DeleteMapping( "/device" )
   public void deleteDevice( @RequestBody Device device )
   {
      deviceRepository.delete( device );
   }

   @DeleteMapping( "/device/{id}" )
   public void deleteDeviceOnlyId( @PathVariable( value = "id" ) long id )
   {
      deviceRepository.deleteById( id );
   }

   @PutMapping( "/device" )
   public Device updateDevice( @RequestBody Device device )
   {
      return deviceRepository.save( device );
   }
}
