package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById() ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n === TEST 2: Seller findById() ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TEST 3: Seller findAll() ===");
        list = sellerDao.findAll();
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n === TEST 4: Seller Insert() ===");
        Seller seller1 = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted!, new id = " + seller1.getId());

        System.out.println("\n=== TEST 5: seller update =====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        }
}