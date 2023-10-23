package com.example.erp.controller;

import com.example.erp.model.RamoAtividade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;
import java.util.Objects;

public class RamoAtividadeConverter implements Converter {

    private List<RamoAtividade> listaRamoAtividades;

    public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
        this.listaRamoAtividades = listaRamoAtividades;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (Objects.isNull(s)) {
            return null;
        }

        Long id = Long.valueOf(s);
        for (RamoAtividade ramoAtividade : listaRamoAtividades) {
            if (id.equals(ramoAtividade.getId())) {
                return ramoAtividade;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (Objects.isNull(o)) {
            return null;
        }

        RamoAtividade ramoAtividade = (RamoAtividade) o;
        return ramoAtividade.getId().toString();
    }

}
