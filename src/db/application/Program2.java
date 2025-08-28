package db.application;

import model.dao.DepartmentDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("=== TEST 2: findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list){
            System.out.println(dep);
        }

        System.out.println("=== TEST 3: insert ===");

        System.out.println("=== TEST 4: update ===");

        System.out.println("=== TEST 5: delete ===");


    }

}
