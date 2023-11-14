package com.example.erp.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PaginaPrincipalBean implements Serializable {

    public String redirectToContratos() {
        return "contratos?faces-redirect=true";
    }

}
