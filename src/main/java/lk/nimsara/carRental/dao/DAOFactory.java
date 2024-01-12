package lk.nimsara.carRental.dao;

import lk.nimsara.carRental.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,CAR, SALARY, STOCK, REPAIR, SUPPLIER, ATTENDANCE,APPOIMENT,USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case CAR:
                return new CarDAOImpl();
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case STOCK:
                return new StockDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case REPAIR:
                return new RepairDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case APPOIMENT:
                return new AppoimentDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }

}

