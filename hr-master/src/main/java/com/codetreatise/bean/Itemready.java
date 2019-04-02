package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "itemready")
public class Itemready {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "itemsid")
    private Items items;

    private Double fittingwt;

    private Double readygrswt;

    private Double netwt;

    private Double netkundan;

    private Double totalamount;

    private Date readydate;

    private boolean isDele = false;

    private boolean isCncl = false;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    private Integer userid = 0;

    private Integer editid = 0;



    @OneToMany(mappedBy = "itemready")
    private List<Itemreadyaccessry> itemreadyaccessries;

    public Itemready() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Double getFittingwt() {
        return fittingwt;
    }

    public void setFittingwt(Double fittingwt) {
        this.fittingwt = fittingwt;
    }

    public Double getReadygrswt() {
        return readygrswt;
    }

    public void setReadygrswt(Double readygrswt) {
        this.readygrswt = readygrswt;
    }

    public Double getNetwt() {
        return netwt;
    }

    public void setNetwt(Double netwt) {
        this.netwt = netwt;
    }

    public Double getNetkundan() {
        return netkundan;
    }

    public void setNetkundan(Double netkundan) {
        this.netkundan = netkundan;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getReadydate() {
        return readydate;
    }

    public void setReadydate(Date readydate) {
        this.readydate = readydate;
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

    public List<Itemreadyaccessry> getItemreadyaccessries() {
        return itemreadyaccessries;
    }

    public void setItemreadyaccessries(List<Itemreadyaccessry> itemreadyaccessries) {
        this.itemreadyaccessries = itemreadyaccessries;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}


