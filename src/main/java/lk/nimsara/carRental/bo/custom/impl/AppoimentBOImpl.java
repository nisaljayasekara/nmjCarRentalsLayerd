package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.AppoimentBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.AppoimentDAO;
import lk.nimsara.carRental.dao.custom.CustomerDAO;
import lk.nimsara.carRental.dto.AppoimentDto;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.entity.Appoiment;
import lk.nimsara.carRental.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppoimentBOImpl implements AppoimentBO {

    AppoimentDAO appoimentDAO = (AppoimentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOIMENT);

    @Override
    public boolean saveAppoiment(AppoimentDto dto) throws SQLException {
        return appoimentDAO.save(new Appoiment(
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
    }

    @Override
    public boolean deleteAppoiment(String Appoiment_id) throws SQLException {
        return appoimentDAO.delete(Appoiment_id);
    }

    @Override
    public boolean updateAppoiment(AppoimentDto dto) throws SQLException {
        return  appoimentDAO.update(new Appoiment(
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
    }

    @Override
    public AppoimentDto searchAppoiment(String Appoiment_id) throws SQLException {
        Appoiment appoiment = appoimentDAO.search(Appoiment_id);
        return new AppoimentDto(appoiment.getId(),
                appoiment.getDate(),
                appoiment.getTime(),
                appoiment.getReturndate(),
                appoiment.getCustomer_id(),
                appoiment.getAppoiment_returnTime(),
                appoiment.getCar_id(),
                appoiment.getCar_name(),
                appoiment.getCar_price(),
                appoiment.getPayment());
    }

    @Override
    public List<AppoimentDto> getAllAppoiment() throws SQLException {

        List<Appoiment> appoimentList= appoimentDAO.getAll();
        List<AppoimentDto> dtoList = new ArrayList<>();

        for (Appoiment appoiment:appoimentList){
            dtoList.add(new AppoimentDto(appoiment.getId(),
                    appoiment.getDate(),
                    appoiment.getTime(),
                    appoiment.getReturndate(),
                    appoiment.getCustomer_id(),
                    appoiment.getAppoiment_returnTime(),
                    appoiment.getCar_id(),
                    appoiment.getCar_name(),
                    appoiment.getCar_price(),
                    appoiment.getPayment()));
        }

        return dtoList;
    }

}
