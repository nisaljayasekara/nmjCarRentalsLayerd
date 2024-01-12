package lk.nimsara.carRental.bo.custom;



import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.CarDto;

import java.sql.SQLException;
import java.util.List;

public interface CarBO extends SuperBO {
    boolean saveCar( CarDto dto) throws SQLException;

    boolean deleteCar(String Car_id) throws SQLException;

    boolean updateCar( CarDto dto) throws SQLException;

    CarDto searchCar(String Car_id) throws SQLException;

    List<CarDto> getAllCars() throws SQLException;

    boolean updateCarstatus(String carId) throws SQLException;
}
