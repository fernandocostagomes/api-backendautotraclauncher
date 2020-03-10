package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.APP_DEVICE;

public interface AppDeviceRepository extends JpaRepository<APP_DEVICE, Long>
{
   APP_DEVICE findById( long id );
}
