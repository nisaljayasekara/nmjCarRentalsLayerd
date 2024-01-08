package lk.nimsara.carRental.dao;

import lk.nimsara.carRental.dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            default:
                return null;
        }
    }


}

