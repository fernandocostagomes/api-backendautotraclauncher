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
@RequestMapping( value = "/api" )
public class DeviceResource
{
   @Autowired
   DeviceRepository deviceRepository;

   @GetMapping( "/deviceall" )
   public List<DEVICE> listDevice()
   {
      return deviceRepository.findAll();
   }

   @GetMapping( "/deviceonly/{id}" )
   public DEVICE listDeviceOnly( @PathVariable( value = "id" ) long id )
   {
      return deviceRepository.findById( id );
   }

   @PostMapping( "/deviceinsert" )
   public DEVICE insertDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }

   @DeleteMapping( "/devicedelete" )
   public void deleteDevice( @RequestBody DEVICE device )
   {
      deviceRepository.delete( device );
   }

   @PutMapping( "/deviceupdate" )
   public DEVICE updateDevice( @RequestBody DEVICE device )
   {
      return deviceRepository.save( device );
   }
}
