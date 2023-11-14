package com.example.erp.controller;

import com.example.erp.model.Contrato;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@ViewScoped
public class ContratoController implements Serializable {

    private Boolean abrirModalContrato;


    public Boolean getAbrirModalContrato() {
        if (Objects.isNull(abrirModalContrato)) {
            this.abrirModalContrato = false;
        }
        return abrirModalContrato;
    }

    public void setAbrirModalContrato(boolean abrirModalContrato) {
        this.abrirModalContrato = abrirModalContrato;
    }

    public List<Contrato> getListaContratos() {
        List<Contrato> contratos = new ArrayList<>();
        Contrato contrato = new Contrato();
        contrato.setId(1L);
        contrato.setNomeEmpresaPrestadora("Global Tech");
        contratos.add(contrato);
        return contratos;
    }

    public void trocarBotoes() {
        this.abrirModalContrato = true;
    }



}
