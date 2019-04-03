package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "itemkarigaraccessry")
public class Itemkarigaraccessry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accessoryid")
    private Customaccess customaccess;

    private String details;

    private Double gross;

    private Double weight;

    private Double rate;

    private Double amount;

    private Date accessdate;

    private Double netFine;

    private boolean isDele = false;

    private boolean isCncl = false;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    private Integer userid = 0;

    private Integer editid = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemkarigarid")
    private Itemkarigar itemkarigar;

    public Itemkarigaraccessry() {
    }

    public Itemkarigaraccessry(String details, Double gross, Double weight, Double rate, Double amount) {
        this.details = details;
        this.gross = gross;
        this.weight = weight;
        this.rate = rate;
        this.amount = amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Customaccess getAccessryid() {
        return customaccess;
    }

    public void setAccessryid(Customaccess accessryid) {
        this.customaccess = accessryid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getGross() {
        return gross;
    }

    public void setGross(Double gross) {
        this.gross = gross;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getAccessdate() {
        return accessdate;
    }

    public void setAccessdate(Date accessdate) {
        this.accessdate = accessdate;
    }

    public Double getNetFine() {
        return netFine;
    }

    public void setNetFine(Double netFine) {
        this.netFine = netFine;
    }

    public boolean isDele() {
        return isDele;
    }

    public void setDele(boolean dele) {
        isDele = dele;
    }

    public boolean isCncl() {
        return isCncl;
    }

    public void setCncl(boolean cncl) {
        isCncl = cncl;
    }

    public Timestamp getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Timestamp datestamp) {
        this.datestamp = datestamp;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getEditid() {
        return editid;
    }

    public void setEditid(Integer editid) {
        this.editid = editid;
    }

    public Itemkarigar getItemkarigar() {
        return itemkarigar;
    }

    public void setItemkarigar(Itemkarigar itemkarigar) {
        this.itemkarigar = itemkarigar;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}


