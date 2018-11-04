package hiberExample.services;

import hiberExample.models.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAll();

    Phone get(Long id);

    Phone getByNumber(String number);


    void create(Phone phone);

    Phone update(Phone phone);

    void delete(Long id);
}
