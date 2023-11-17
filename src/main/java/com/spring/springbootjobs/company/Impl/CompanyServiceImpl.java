package com.spring.springbootjobs.company.Impl;

import com.spring.springbootjobs.company.Company;
import com.spring.springbootjobs.company.CompanyRepository;
import com.spring.springbootjobs.company.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return null;
    }
}
