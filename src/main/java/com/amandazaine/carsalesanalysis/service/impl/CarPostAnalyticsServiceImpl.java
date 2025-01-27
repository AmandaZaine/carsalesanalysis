package com.amandazaine.carsalesanalysis.service.impl;

import com.amandazaine.carsalesanalysis.dto.CarPostDTO;
import com.amandazaine.carsalesanalysis.entity.BrandAnalyticsEntity;
import com.amandazaine.carsalesanalysis.entity.CarModelAnalyticsEntity;
import com.amandazaine.carsalesanalysis.entity.CarModelPriceEntity;
import com.amandazaine.carsalesanalysis.repository.BrandAnalyticsRepository;
import com.amandazaine.carsalesanalysis.repository.CarModelAnalyticsRepository;
import com.amandazaine.carsalesanalysis.repository.CarModelPriceRepository;
import com.amandazaine.carsalesanalysis.service.CarPostAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarPostAnalyticsServiceImpl implements CarPostAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarModelPriceRepository carModelPriceRepository;

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());
    }

    private void saveCarModelPriceAnalytics(String model, Double price) {
        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();
        carModelPriceEntity.setModel(model);
        carModelPriceEntity.setPrice(price);

        carModelPriceRepository.save(carModelPriceEntity);

    }

    private void saveCarModelAnalytics(String model) {
        CarModelAnalyticsEntity newModel = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository
                .findByModel(model)
                .ifPresentOrElse(
                        modelRegistered -> {
                            modelRegistered.setQtddPosts(modelRegistered.getQtddPosts() + 1);
                            carModelAnalyticsRepository.save(modelRegistered);
                        },
                        () -> {
                            newModel.setModel(model);
                            newModel.setQtddPosts(1L);
                            carModelAnalyticsRepository.save(newModel);
                        }
                );
    }

    private void saveBrandAnalytics(String brand) {
        BrandAnalyticsEntity newBrand = new BrandAnalyticsEntity();

        brandAnalyticsRepository
                .findByBrand(brand)
                .ifPresentOrElse(
                        brandRegistered -> {
                            brandRegistered.setQtddPosts(brandRegistered.getQtddPosts() + 1);
                            brandAnalyticsRepository.save(brandRegistered);
                        },
                        () -> {
                            newBrand.setBrand(brand);
                            newBrand.setQtddPosts(1L);
                            brandAnalyticsRepository.save(newBrand);
                        }
                );
    }


}
