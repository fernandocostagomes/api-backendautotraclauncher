package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.CONFIG;

public interface ConfigRepository extends JpaRepository<CONFIG, Long>
{
   CONFIG findById( long id );
}
