package com.example.erp.controller;

import com.example.erp.model.Empresa;
import com.example.erp.model.RamoAtividade;
import com.example.erp.model.TipoEmpresa;
import com.example.erp.repository.Empresas;
import com.example.erp.repository.RamoAtividades;
import com.example.erp.service.CadastroEmpresaService;
import com.example.erp.util.FacesMessages;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;


import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    @Inject
    private FacesMessages messages;

    @Inject
    private RamoAtividades ramoAtividades;

    @Inject
    private CadastroEmpresaService cadastroEmpresaService;

    private List<Empresa> listaEmpresas;

    private String termoPesquisa;

    private Converter ramoAtividadeConverter;

    private Empresa empresa;

    public void prepararNovaEmpresa() {
        empresa = new Empresa();
    }

    public void prepararEdicao() {
        ramoAtividadeConverter = new RamoAtividadeConverter(Collections.singletonList(empresa.getRamoAtividade()));
    }

    public void salvar() {
        cadastroEmpresaService.salvar(empresa);
        messages.info("Empresa salva com sucesso!");
        atualizarRegistros();
        PrimeFaces.current().ajax().update(Arrays.asList("frm:empresasDataTable", "frm:messages"));
    }

    public void excluir() {
        cadastroEmpresaService.excluir(empresa);
        empresa = null;
        atualizarRegistros();
        messages.info("Empresa excluida com sucesso!");
    }

    public void pesquisar() {
        listaEmpresas = empresas.pesquisar(termoPesquisa);

        if (listaEmpresas.isEmpty()) {
            messages.info("Nenhuma empresa encontrada");
        }
    }

    public void todasEmpresas() {
        listaEmpresas = empresas.todas();
    }

    public List<RamoAtividade> completarRamoAtividade(String termo) {
        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
        return listaRamoAtividades;
    }

    private boolean jaHouvePesquisa() {
        return termoPesquisa != null &&!"".equals(termoPesquisa);
    }

    public void atualizarRegistros() {
        if (jaHouvePesquisa()) {
            pesquisar();
        } else {
            todasEmpresas();
        }
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }

    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean isEmpresaSelecionada() {
        return empresa != null && empresa.getId() != null;
    }

}