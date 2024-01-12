package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.bo.custom.CarBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.CarDAO;
import lk.nimsara.carRental.dao.custom.CustomerDAO;
import lk.nimsara.carRental.dao.custom.impl.CarDAOImpl;
import lk.nimsara.carRental.dto.CarDto;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.entity.Car;
import lk.nimsara.carRental.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarBOImpl implements CarBO {

    CarDAO carDAO = (CarDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CAR);

    @Override
    public boolean saveCar(CarDto dto) throws SQLException {
        return carDAO.save(new Car(
                dto.getId(),
                dto.getName(),
                dto.getAvailability(),
                dto.getPrice()));
    }

    @Override
    public boolean deleteCar(String Car_id) throws SQLException {
        return carDAO.delete(Car_id);
    }

    @Override
    public boolean updateCar(CarDto dto) throws SQLException {
        return  carDAO.update(new Car(
                dto.getId(),
                dto.getName(),
                dto.getAvailability(),
                dto.getPrice()));

    }

    @Override
    public CarDto searchCar(String Car_id) throws SQLException {
        Car car = carDAO.search(Car_id);
        return new CarDto(car.getId(),
                car.getName(),
                car.getAvailability(),
                car.getPrice());
    }

    @Override
    public List<CarDto> getAllCars() throws SQLException {
        List<Car> carList= carDAO.getAll();
        List<CarDto> dtoList = new ArrayList<>();

        for (Car car:carList){
            dtoList.add(new CarDto(car.getId(),
                    car.getName(),
                    car.getAvailability(),
                    car.getPrice()));
        }

        return dtoList;
    }

    @Override
    public boolean updateCarstatus(String carId) throws SQLException {
       return carDAO.updateCarStatus(carId);
    }

}
