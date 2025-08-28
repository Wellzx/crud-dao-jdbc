package db.application;

import model.dao.DepartmentDao;
import model.dao.impl.DaoFactory;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById ===");

        System.out.println("=== TEST 2: findAll ===");

        System.out.println("=== TEST 3: insert ===");

        System.out.println("=== TEST 4: update ===");

        System.out.println("=== TEST 5: delete ===");


    }

}
