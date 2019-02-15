package com.amljdhv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amljdhv.shop.Shop;
import com.amljdhv.shop.ShopRepository;

@Service("shopService")
public class ShopServiceImpl implements ShopService{

	
	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public void createShop(Shop shop) {
		shopRepository.save(shop);
	}

	@Override
	public void update(Shop shop) {
		shopRepository.save(shop);
	}

}
