package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.AppoimentDetailBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.AppoimentDAO;
import lk.nimsara.carRental.dao.custom.CarDAO;
import lk.nimsara.carRental.db.DbConnection;
import lk.nimsara.carRental.dto.AppoimentDto;
import lk.nimsara.carRental.entity.Appoiment;

import java.sql.Connection;
import java.sql.SQLException;

public class AppoimentDetailBOImpl implements AppoimentDetailBO {

    CarDAO carDAO =(CarDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CAR);

    AppoimentDAO appoimentDAO = (AppoimentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOIMENT);

    @Override
    public boolean saveAppoiment(AppoimentDto dto, String carId) throws SQLException {
        boolean resalt = false;
        Connection connection=null;
        System.out.println("1");

        try{
            connection= DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isSaved =appoimentDAO.save(new Appoiment(
                    dto.getId(),
                    dto.getDate(),
                    dto.getTime(),
                    dto.getReturndate(),
                    dto.getCustomer_id(),
                    dto.getAppoiment_returnTime(),
                    dto.getCar_id(),
                    dto.getCar_name(),
                    dto.getCar_price(),
                    dto.getPayment()));

            System.out.println("2");
            if(isSaved){
                boolean isUpdated = carDAO.updateCarStatus(carId);
                System.out.println("3");
                if (isUpdated){
                    connection.commit();
                    resalt = true;
                }
            }

        }catch(SQLException e){
            connection.rollback();
        }finally {
            connection.setAutoCommit(true);
        }
        return resalt;
    }
}
