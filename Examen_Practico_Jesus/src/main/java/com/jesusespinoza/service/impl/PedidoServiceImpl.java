package com.jesusespinoza.service.impl;

import com.jesusespinoza.model.Pedido;
import com.jesusespinoza.repo.IGenericRepo;
import com.jesusespinoza.repo.IPedidoRepo;
import com.jesusespinoza.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PedidoServiceImpl extends CRUDImpl<Pedido, Integer> implements IPedidoService {
    private final IPedidoRepo repo;

    @Override
    protected IGenericRepo<Pedido, Integer> getRepo() {
        return repo;
    }
}
