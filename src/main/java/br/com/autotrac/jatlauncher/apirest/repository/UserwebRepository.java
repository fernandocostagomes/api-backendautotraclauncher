package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.USERWEB;

public interface UserwebRepository extends JpaRepository<USERWEB, Long>
{
   USERWEB findByUserwebNumId( long p_id );

   USERWEB findByUserwebTxtName( String p_userName );
}
