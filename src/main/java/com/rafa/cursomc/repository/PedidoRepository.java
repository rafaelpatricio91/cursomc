package com.rafa.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafa.cursomc.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>
{}
