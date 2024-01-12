package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.RepairBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.CustomerDAO;
import lk.nimsara.carRental.dao.custom.RepairDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.RapierDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Repair;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairBOImpl implements RepairBO {

    RepairDAO repairDAO = (RepairDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REPAIR);

    @Override
    public boolean saveRepair(RapierDto dto) throws SQLException {
        return repairDAO.save(new Repair(
               dto.getRapier_id(),
                dto.getRapier_date(),
                dto.getRapier_desc(),
                dto.getRapier_returnDate(),
                dto.getRapier_price(),
                dto.getCar_id()));
    }

    @Override
    public boolean deleteRepair(String Rapier_id) throws SQLException {
        return repairDAO.delete(Rapier_id);
    }

    @Override
    public boolean updateRepair(RapierDto dto) throws SQLException {
        return  repairDAO.update(new Repair(dto.getRapier_id(),
                dto.getRapier_date(),
                dto.getRapier_desc(),
                dto.getRapier_returnDate(),
                dto.getRapier_price(),
                dto.getCar_id()));

    }

    @Override
    public RapierDto searchRepair(String Rapier_id) throws SQLException {
        Repair repair = repairDAO.search(Rapier_id);
        return new RapierDto(repair.getRapier_id(),
                repair.getRapier_date(),
                repair.getRapier_desc(),
                repair.getRapier_returnDate(),
                repair.getRapier_price(),
                repair.getCar_id());
    }

    @Override
    public List<RapierDto> getAllRepair() throws SQLException {

        List<Repair> repairList= repairDAO.getAll();
        List<RapierDto> dtoList = new ArrayList<>();

        for (Repair repair:repairList){
            dtoList.add(new RapierDto(repair.getRapier_id(),
                    repair.getRapier_date(),
                    repair.getRapier_desc(),
                    repair.getRapier_returnDate(),
                    repair.getRapier_price(),
                    repair.getCar_id()));
        }

        return dtoList;
    }
}
