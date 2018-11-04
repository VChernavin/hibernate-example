package hiberExample.services;

import hiberExample.models.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Company get(Long id);

    Company get(String name);

    void create(Company company);

    void update(Company company);

    void delete(Long id);
}
