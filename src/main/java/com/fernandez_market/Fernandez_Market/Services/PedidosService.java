package com.fernandez_market.Fernandez_Market.Services;

import com.fernandez_market.Fernandez_Market.Models.Pedidos;
import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    private final PedidosRepository pedidoRepository;

    @Autowired
    public PedidosService(PedidosRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedidos> getUltimoPedido(){
        return this.pedidoRepository.findAll();
    }

    public void savePedido(Pedidos pedidoNuevo){
        this.pedidoRepository.save(pedidoNuevo);
    }
}
