package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.Paramdevice;

public interface ParamDeviceRepository extends JpaRepository<Paramdevice, Long>
{
   Paramdevice findById( long id );
}
