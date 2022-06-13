package org.example.service;

import org.example.dao.DriverDAO;
import org.example.dao.DriverDAOImpl;
import org.example.entity.Driver;

import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static   DriverDAO driverDAO=new DriverDAOImpl();

    public void addNewDriver(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập tên lái xe: ");
        String name=sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address=sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNum=sc.next();
        System.out.println("Nhập trình độ lái xe là 1 trong các lựa chọn dưới đây: ");
        String level = null;
        char[] b=new char[7];
        char a='A';
        for(int i=1;i<=6;i++){
            System.out.println(i+"."+(char)a);
            b[i]=a;
            a+=1;

        }
        int choice;
        do {
            try {
                choice=Integer.parseInt(sc.next());
                if(choice>=1&&choice<=6)
                    break;
                System.out.print("Chỉ nhập từ 1 đến 6 vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }


        }while (true);
        switch (choice){
            case 1:level=Character.toString(b[1]);
                break;
            case 2:level=Character.toString(b[2]);
                break;
            case 3:level=Character.toString(b[3]);
                break;
            case 4:level=Character.toString(b[4]);
                break;
            case 5:level=Character.toString(b[5]);
                break;
            case 6:level=Character.toString(b[6]);
        }
        boolean add= driverDAO.addNew(new Driver(name,address,phoneNum,level));
        if(add)
            System.out.println("Thêm mới thành công!");
        else{
            System.out.println("Thêm mới thất bại");
        }
    }
    public void showAllDriver(){
        List<Driver> drivers=driverDAO.getAll();
        if(drivers==null||drivers.isEmpty())
            System.out.println("Không có lãi xe nào trong csdl!");
        else {
            drivers.forEach(System.out::println);
        }
    }
}
