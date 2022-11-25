package io.jotech.classicmodels.service.impl;

import java.util.List;

import jakarta.inject.Inject;

import io.jotech.classicmodels.entity.Office;
import io.jotech.classicmodels.repository.OfficeRepository;
import io.jotech.classicmodels.service.OfficeService;

public class OfficeServiceImpl implements OfficeService {
    @Inject
    private OfficeRepository officeRepository;

    @Override
    public List<Office> getAllOffices() {
        return officeRepository.listAll();
    }

    @Override
    public Office getOffice(String officeCode) {
        return officeRepository.read(officeCode);
    }

    @Override
    public Office createOffice(Office office) {
        return officeRepository.insert(office);
    }

    @Override
    public Office updateOffice(Office office) {
        return officeRepository.update(office);
    }

    @Override
    public boolean deleteOffice(String officeCode) {
        return officeRepository.deleteById(officeCode);
    }
}
