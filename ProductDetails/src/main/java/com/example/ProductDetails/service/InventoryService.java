//package com.example.ProductDetails.service;
//
//import com.example.ProductDetails.entity.Inventory;
//import com.example.ProductDetails.model.InventoryModel;
//import com.example.ProductDetails.repository.InventoryRepo;
//import com.example.ProductDetails.repository.ProductPriceRepo;
//import com.example.ProductDetails.repository.ProductDetailsRepo;
//import com.example.ProductDetails.repository.ProductSkuRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//
//public class InventoryService
//    {
//        @Autowired
//        private InventoryRepo inventoryRepo;
//        @Autowired
//        private ProductDetailsRepo productDetailsRepo;
//        @Autowired
//        private ProductSkuRepo productSkuRepo;
//        @Autowired
//        private ProductPriceRepo priceRepo;
//
//        public String addStock(InventoryModel inventoryModel)
//        {
//            if (productSkuRepo.findById(inventoryModel.getProductSkuId()).isPresent()) {
//
//
//                Inventory inv = new Inventory();
//                inv.setProductSkuId(inventoryModel.getProductSkuId());
//                inv.setQuantityAvailable(inventoryModel.getQuantityAvailable());
//                inventoryRepo.save(inv);
//                return "Inventory Added";
//            }
//            return "Product Not Available";
//        }
//
//        public String updateStock(InventoryModel inventoryModel)
//        {
//            if(!inventoryRepo.findBySkuId(productSkuId).isEmpty()) {
//
//
//                List<Inventory> invo = inventoryRepo.findByproductSkuId(productSkuId);
//                invo.forEach(i ->
//                {
//                    i.setQuantityAvailable(inventoryModel.getQuantityAvailable());
//                    inventoryRepo.save(i);
//                });
//                return "Product Updated";
//            }
//            return "Product Not Found";
//        }
//    }
