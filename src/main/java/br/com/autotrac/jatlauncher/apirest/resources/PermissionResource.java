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

import br.com.autotrac.jatlauncher.apirest.models.PERMISSION;
import br.com.autotrac.jatlauncher.apirest.repository.PermissionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( value = "/api/v1" )
@Api( value = "API REST OBJETO PERMISSION" )
@CrossOrigin( origins = "*" )
public class PermissionResource
{
   @Autowired
   PermissionRepository permissionRepository;

   @GetMapping( "/permission" )
   @ApiOperation( value = "Retorna a lista de todos os Permissions." )
   public List<PERMISSION> listPermission()
   {
      return permissionRepository.findAll();
   }

   @GetMapping( "/permission/{id}" )
   @ApiOperation( value = "Retorna um único Objeto de um Permission de acordo com o Id informado." )
   public PERMISSION permissionOnly( @PathVariable( value = "id" ) long permission_id )
   {
      return permissionRepository.findByPermissionNumId( permission_id );
   }

   @PutMapping( "/permission" )
   @ApiOperation( value = "Faz uma alteração em um Permission de acordo com o objeto informado." )
   public PERMISSION updateApp( @RequestBody PERMISSION permission )
   {
      return permissionRepository.save( permission );
   }

   @PostMapping( "/permission" )
   @ApiOperation( value = "Grava um Permission." )
   public PERMISSION insertApp( @RequestBody PERMISSION permission )
   {
      return permissionRepository.save( permission );
   }

   @DeleteMapping( "/permission" )
   @ApiOperation( value = "Deleta um Permission de acordo com o objeto informado." )
   public void deletePermission( @RequestBody PERMISSION permission )
   {
      permissionRepository.delete( permission );
   }
}
