package org.example.service;

import org.example.dao.*;
import org.example.entity.Division;
import org.example.entity.DivisionDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisionService {
    public DivisionDAO divisionDAO=new DivisionDAOImpl();
    public DivisionDetailDAO divisionDetailDAO=new DivisionDetailDAOImpl();
    public DriverDAO driverDAO=new DriverDAOImpl();
    public RouteDAO routeDAO=new RouteDAOImpl();

    public void addNewDivision(){
        if(driverDAO.getAll().isEmpty()||routeDAO.getAll().isEmpty()){
            System.out.println("Chưa có dữ liệu lái xe hoặc tuyến");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int driverID;
        System.out.print("Nhập mã lái xe: ");
        do {
            try {
                driverID = Integer.parseInt(sc.next());
                if (driverDAO.getOneById(driverID) != null)
                    break;
                System.out.print("Mã lái xe không tồn tại vui lòng nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã lái xe phải là số nguyên dương vui lòng nhập lại: ");
            }
        } while (true);
        int n;
        System.out.print("Nhập số lượng tuyến muốn thêm: ");
        do {
            try {
                n = Integer.parseInt(sc.next());
                if (n > 0)
                    break;
                System.out.print("Số lượng tuyến phải là số nguyên dương: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã lái xe phải là số nguyên dương vui lòng nhập lại: ");
            }
        } while (true);
        Division d=new Division();
        List<DivisionDetail> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            System.out.print("Nhập mã tuyến thứ "+(i+1)+" muốn thêm: ");
            int routeID;
            do {
                try {
                    routeID = Integer.parseInt(sc.next());
                    if (routeDAO.getOneById(routeID)!=null&&checkSameID(list,routeID))
                        break;
                    System.out.print("Mã tuyến không tồn tại hoặc bị trùng vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Mã tuyến phải là số nguyên dương vui lòng nhập lại: ");
                }
            } while (true);
            System.out.print("Nhập số lượt: ");
            int numTurn;
            do {
                try {
                    numTurn = Integer.parseInt(sc.next());
                    if (numTurn>0&&numTurn<=15)
                        break;
                    System.out.print("Số lượt không vượt quá 15 vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Số lượt là số nguyên dương vui lòng nhập lại: ");
                }

            } while (true);
            list.add(new DivisionDetail(d,routeDAO.getOneById(routeID),numTurn));

        }
        d.setDivisionDetails(list);
        d.setDriver(driverDAO.getOneById(driverID));
        boolean add=divisionDAO.addNew(d);
        if(add)
            System.out.println("Thêm mới thành công!");
        else
            System.out.println("Thêm mới thất bại!");
    }
    private  boolean checkSameID(List<DivisionDetail> list, int id){
        for(DivisionDetail i:list) {
            if (i.getRoute().getId()==id)
                return false;
        }
        return true;

    }
    public void showAllDivision(){
        List<Division> divisions=divisionDAO.getAll();
        for(Division i:divisions) {
            System.out.println("Lái xe "+ i.getDriver().getName()+"có DS các tuyến là:");
            for(DivisionDetail j:i.getDivisionDetails())
                System.out.println(j);

        }
    }
    public void sortByNameDriver(){
        List<Division> divisions=divisionDAO.orderByNameDriver();
        for(Division i:divisions) {
            System.out.println("Lái xe "+ i.getDriver().getName()+" có DS các tuyến là:");
            for(DivisionDetail j:i.getDivisionDetails())
                System.out.println(j);

        }
    }
}
