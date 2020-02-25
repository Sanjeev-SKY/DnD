package com.cg.drinkanddelight.service;

import java.time.LocalDate;

import com.cg.drinkanddelight.dao.DAO;
import com.cg.drinkanddelight.dao.ProductDAO;
import com.cg.drinkanddelight.dao.ProductDAOImpl;
import com.cg.drinkanddelight.model.ProductStock;

public class ProductService implements ProductDAO{
	ProductDAO pd=new ProductDAOImpl();
	public String exitDateCheck(String id, LocalDate date) {
		
		 ProductStock ps=DAO.findById(id);
		 //System.out.println(ps.toString());
		 if(ps!=null) {
			 ps.setExitDate(date);
			 //System.out.println("................");
			 if(pd.exitDateCheck(ps)) {
				 ps.setExitDate(date);
				 return "Exit Date Set";
			 }
		 }
		 return "Exit Date not Set";
	}
	
	public String updateProductStock(String orderId, LocalDate manufacturingDate, LocalDate expiryDate, String qualityAnalysis) {
		
		ProductStock ps=new ProductStock();
		ps.setOrderId(orderId);
		ps.setManufacturingDate(manufacturingDate);
		ps.setExpiryDate(expiryDate);
		ps.setQualityCheck(qualityAnalysis);
		return pd.updateProductStock(ps);
		
		}

	@Override
	public String trackProductOrder(ProductStock productStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean processDateCheck(ProductStock productStock) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateExitDateinStock(ProductStock productStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProductStock(ProductStock productStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesProductOrderIdExistinStock(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doesProductOrderIdExist(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exitDateCheck(ProductStock productStock) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
