package org.example.service;

import org.example.dao.RouteDAO;
import org.example.dao.RouteDAOImpl;
import org.example.entity.Route;

import java.util.List;
import java.util.Scanner;

public class RouteService {
    public RouteDAO routeDAO=new RouteDAOImpl();
    public void addNewRoute(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập khoảng cách: ");
        int distance;
        do{
            try {
                distance=Integer.parseInt(sc.next());
                if(distance>0)
                    break;
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }

        }while (true);
        int stopPoint;
        System.out.print("Nhập số điểm dừng: ");
        do{
            try {
                stopPoint=Integer.parseInt(sc.next());
                if(stopPoint>0)
                    break;
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }

        }while (true);
       boolean add= routeDAO.addNew(new Route(distance,stopPoint));
        if(add)
            System.out.println("Thêm mới thành công!");
        else{
            System.out.println("Thêm mới thất bại");
        }
    }

    public void showAllRoute(){
        List<Route> routes=routeDAO.getAll();
        if(routes==null||routes.isEmpty())
            System.out.println("Không có tuyến nào trong csdl!");
        else {
            routes.forEach(System.out::println);
        }
    }
}
