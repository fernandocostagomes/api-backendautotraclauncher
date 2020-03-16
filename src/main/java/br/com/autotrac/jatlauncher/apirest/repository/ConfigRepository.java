package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.Config;

public interface ConfigRepository extends JpaRepository<Config, Long>
{

   Config findById( long id );

}
