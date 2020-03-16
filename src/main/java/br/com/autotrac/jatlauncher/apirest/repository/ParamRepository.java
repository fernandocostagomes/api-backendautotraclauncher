package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.Param;

public interface ParamRepository extends JpaRepository<Param, Long>
{
   Param findById( long id );
}
