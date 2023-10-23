package com.example.erp.repository;

import com.example.erp.model.Empresa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresas() {

    }

    public Empresas(EntityManager manager) {
        this.manager = manager;
    }

    public Empresa porId(Long id) {
        return manager.find(Empresa.class, id);
    }

    public List<Empresa> pesquisar(String nome) {
        String jpql2 = "select e from Empresa e where e.razaoSocial like:razaoSocial";

        TypedQuery<Empresa> query = manager
                .createQuery(jpql2, Empresa.class);

        query.setParameter("razaoSocial", nome + "%");

        return query.getResultList();
    }

    public List<Empresa> todas() {
        String jpql = "select e from Empresa e";
        TypedQuery<Empresa> typedQuery = manager.createQuery(jpql, Empresa.class);
        return typedQuery.getResultList();
    }

    public Empresa guardar(Empresa empresa) {
        return manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        empresa = porId(empresa.getId());
        manager.remove(empresa);
    }

}
