package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.KOHA;

public interface KohaRepository extends JpaRepository<KOHA, Long>
{
   KOHA findByAppNumId( long p_id );
}
