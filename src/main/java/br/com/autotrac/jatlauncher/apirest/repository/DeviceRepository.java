package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.DEVICE;

public interface DeviceRepository extends JpaRepository<DEVICE, Long>
{

   DEVICE findById( long id );

}
