package br.com.autotrac.jatlauncher.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autotrac.jatlauncher.apirest.models.DEVICE;

public interface DeviceRepository extends JpaRepository<DEVICE, Long>
{
   DEVICE findById( long id );

   DEVICE findByDeviceTxtSerial( String serial );

   List<DEVICE> findAllByClientNumId( long clientId );
}
