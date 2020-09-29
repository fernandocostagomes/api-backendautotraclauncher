package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.CLIENT;

public interface ClientRepository extends JpaRepository<CLIENT, Long>
{
   CLIENT findByClientNumId( long p_id );
}
