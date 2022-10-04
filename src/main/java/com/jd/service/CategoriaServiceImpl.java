package com.jd.service;

import com.jd.dao.CategoriaDao;
import com.jd.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public void guardar(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listar() {
        return categoriaDao.findAll();
    }

    @Override
    public void eliminar(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria encontrar(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
}
