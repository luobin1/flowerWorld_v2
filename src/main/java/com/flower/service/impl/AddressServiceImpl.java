package com.flower.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flower.dao.IAddressDao;
import com.flower.entity.Address;
import com.flower.service.IAddressService;


@Service("addressService")
public class AddressServiceImpl implements IAddressService {
	
	@Resource
	private IAddressDao addressDao;

	public List<Address> findByUid(int u_id) {
		return addressDao.findByUid(u_id);
	}

	public Address findByAid(int a_id) {
		return addressDao.findByAid(a_id);
	}

	public void updateAddress(Address address) {
		addressDao.updateAddress(address);

	}

	public void addAddress(Address address) {
		addressDao.addAddress(address);

	}

	public void deleteByAid(int a_id) {
		addressDao.deleteByAid(a_id);

	}

}
