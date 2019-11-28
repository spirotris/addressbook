package se.lernia.addressbook.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lernia.addressbook.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}
