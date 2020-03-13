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

import br.com.autotrac.jatlauncher.apirest.models.DEVICE;
import br.com.autotrac.jatlauncher.apirest.repository.DeviceRepository;

@RestController
@RequestMapping( value = "/api/v1" )
public class DeviceResource
{
   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/device_all" )
   public List<DEVICE> listDevice()
   {
      return deviceRepository.findAll();
   }

   @GetMapping( "/device_only/{id}" )
   public DEVICE listDeviceOnly( @PathVariable( value = "id" ) long id )
   {
      return deviceRepository.findById( id );
   }

   @GetMapping( "/device_only/{serial}" )
   public DEVICE listDeviceOnly( @PathVariable( value = "id" ) String serial )
   {
      return deviceRepository.findByDeviceTxtSerial( serial );
   }

   @PostMapping( "/device_insert" )
   public DEVICE insertDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }

   @DeleteMapping( "/device_delete" )
   public void deleteDevice( @RequestBody DEVICE device )
   {
      deviceRepository.delete( device );
   }

   @DeleteMapping( "/device_delete_only/{id}" )
   public void deleteDeviceOnlyId( @PathVariable( value = "id" ) long id )
   {
      deviceRepository.deleteById( id );
   }

   @PutMapping( "/device_update" )
   public DEVICE updateDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }
}
