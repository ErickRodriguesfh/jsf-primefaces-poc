package com.example.erp.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEmpresaPrestadora;

    private BigDecimal valorContrato;

    private String descricaoContrato;

    private Date duracaoContrato;

    private Date inicioContrato;

    private Date fimContrato;

    private String clausula;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Contrato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresaPrestadora() {
        return nomeEmpresaPrestadora;
    }

    public void setNomeEmpresaPrestadora(String nomeEmpresaPrestadora) {
        this.nomeEmpresaPrestadora = nomeEmpresaPrestadora;
    }

    public BigDecimal getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(BigDecimal valorContrato) {
        this.valorContrato = valorContrato;
    }

    public String getDescricaoContrato() {
        return descricaoContrato;
    }

    public void setDescricaoContrato(String descricaoContrato) {
        this.descricaoContrato = descricaoContrato;
    }

    public Date getDuracaoContrato() {
        return duracaoContrato;
    }

    public void setDuracaoContrato(Date duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
    }

    public Date getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Date inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Date getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Date fimContrato) {
        this.fimContrato = fimContrato;
    }

    public String getClausula() {
        return clausula;
    }

    public void setClausula(String clausula) {
        this.clausula = clausula;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}