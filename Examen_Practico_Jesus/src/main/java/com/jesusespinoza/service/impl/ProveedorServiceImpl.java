package com.jesusespinoza.service.impl;

import com.jesusespinoza.model.Proveedor;
import com.jesusespinoza.repo.IGenericRepo;
import com.jesusespinoza.repo.IProveedorRepo;
import com.jesusespinoza.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl extends  CRUDImpl<Proveedor, Integer> implements IProveedorService {

    private final IProveedorRepo repo;

    @Override
    protected IGenericRepo<Proveedor, Integer> getRepo() {
        return repo;
    }
}
