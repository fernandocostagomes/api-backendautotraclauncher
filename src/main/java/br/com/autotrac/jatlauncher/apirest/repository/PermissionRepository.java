package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.PERMISSION;

public interface PermissionRepository extends JpaRepository<PERMISSION, Long>
{
   PERMISSION findByPermissionNumId( long p_id );
}
