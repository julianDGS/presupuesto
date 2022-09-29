package com.jd.service;

import com.jd.dao.MovimientoDao;
import com.jd.domain.Movimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

    @Autowired
    private MovimientoDao movimientoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listarMovimientos() {
        return (List<Movimiento>) movimientoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Movimiento movimiento) {
        movimientoDao.save(movimiento);
    }

    @Override
    @Transactional
    public void eliminar(Movimiento movimiento) {
        movimientoDao.delete(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento encontrarMovimiento(Movimiento movimiento) {
        return movimientoDao.findById(movimiento.getIdMovimiento()).orElse(null);
    }


    @Override
    public List<Movimiento> ingresos() {
        return movimientoDao.listarIngresos();
    }

    @Override
    public List<Movimiento> egresos() {
        return movimientoDao.listarEgresos();
    }
    
}
