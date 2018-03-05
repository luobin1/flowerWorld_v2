package com.flower.service;

import java.util.List;

import com.flower.entity.Address;

public interface IAddressService {
	
	public List<Address> findByUid(int u_id);
	
	public Address findByAid(int a_id);
	
	public void updateAddress(Address address);
	
	public void addAddress(Address address);
	
	public void deleteByAid(int a_id);
}
