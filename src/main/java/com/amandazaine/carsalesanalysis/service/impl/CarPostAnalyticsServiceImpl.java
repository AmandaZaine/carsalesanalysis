package com.amandazaine.carsalesanalysis.service.impl;

import com.amandazaine.carsalesanalysis.dto.CarPostDTO;
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

    }
}
