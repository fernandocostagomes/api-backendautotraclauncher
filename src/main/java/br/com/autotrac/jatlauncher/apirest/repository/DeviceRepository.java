package br.com.autotrac.jatlauncher.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>
{
   Device findById( long id );

   Device findByDeviceTxtSerial( String serial );
}
