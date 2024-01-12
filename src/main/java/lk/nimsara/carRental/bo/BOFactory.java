package lk.nimsara.carRental.bo;

import lk.nimsara.carRental.bo.custom.impl.*;
import lk.nimsara.carRental.dao.custom.impl.AttendanceDAOImpl;

public class BOFactory {


    private static BOFactory bOFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (bOFactory==null)?bOFactory=new BOFactory():bOFactory;
    }

    public enum BOTypes{
        CUSTOMER,EMPLOYEE,CAR,ATTENDANCE,SALARY,STOCK,REPAIR,SUPPLIER,APPOIMENT,APPOIMENT_DETAIL,USER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch(boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case CAR:
                return new CarBOImpl();
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case STOCK:
                return new StockBOImpl();
            case REPAIR:
                return new RepairBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case APPOIMENT:
                return new AppoimentBOImpl();
            case APPOIMENT_DETAIL:
                return new AppoimentDetailBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }


}
