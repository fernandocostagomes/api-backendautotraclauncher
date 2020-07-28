package br.com.autotrac.jatlauncher.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.PARAM_DEVICE;

public interface ParamDeviceRepository extends JpaRepository<PARAM_DEVICE, Long>
{
   PARAM_DEVICE findById( long id );

   PARAM_DEVICE findByParamNumId( long id );

   List<PARAM_DEVICE> findAllByDeviceNumId( long device_num_id );
}
