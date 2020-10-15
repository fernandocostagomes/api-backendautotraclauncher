package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.APP_BACKEND;

public interface AppBackendRepository extends JpaRepository<APP_BACKEND, Long>
{
   APP_BACKEND findByAppNumId( long p_id );

   APP_BACKEND findByAppTxtPackage( String p_pkg );
}
