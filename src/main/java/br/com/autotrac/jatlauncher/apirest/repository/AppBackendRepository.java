package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.Appbackend;

public interface AppBackendRepository extends JpaRepository<Appbackend, Long>
{
   Appbackend findByAppNumId( long p_id );

   Appbackend findByAppTxtPackage( String p_package );

   Appbackend findByAppTxtLabel( String p_label );

   Appbackend deleteByAppTxtPackage( String p_package );
}
