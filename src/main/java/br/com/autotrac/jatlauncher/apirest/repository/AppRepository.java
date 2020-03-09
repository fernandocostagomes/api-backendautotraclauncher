package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.APP;

public interface AppRepository extends JpaRepository<APP, Long>
{

   APP findById( long id );

}
