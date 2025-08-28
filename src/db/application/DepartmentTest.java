package db.application;

import model.dao.DepartmentDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2: findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        System.out.println("\n=== TEST 3: insert ===");
        department = new Department(null, "Soccer");
        departmentDao.insert(department);
        System.out.println("Inserted! New id = " + department.getId());

        System.out.println("\n=== TEST 4: update ===");
        department = departmentDao.findById(5);
        department.setName("Automobiles");
        departmentDao.update(department);
        System.out.println("Update complete!");

        System.out.println("\n=== TEST 5: delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
