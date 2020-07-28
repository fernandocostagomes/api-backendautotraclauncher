package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.PARAM_BACKEND;

public interface ParamBackendRepository extends JpaRepository<PARAM_BACKEND, Long>
{
   PARAM_BACKEND findById( long id );

   PARAM_BACKEND findByParamNumCod( long paramNumCod );
}
