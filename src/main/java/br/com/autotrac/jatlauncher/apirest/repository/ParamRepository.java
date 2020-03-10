package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.PARAM;

public interface ParamRepository extends JpaRepository<PARAM, Long>
{
   PARAM findById( long id );
}
