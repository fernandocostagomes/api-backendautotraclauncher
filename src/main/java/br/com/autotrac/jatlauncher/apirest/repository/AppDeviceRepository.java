package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.Appdevice;

public interface AppDeviceRepository extends JpaRepository<Appdevice, Long>
{
   Appdevice findById( long id );
}
