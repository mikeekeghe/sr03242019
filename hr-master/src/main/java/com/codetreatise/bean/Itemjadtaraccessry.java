package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "itemjadtaraccessry")
public class Itemjadtaraccessry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accessoryid")
    private Customaccess customaccess;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "itemjadtarid")
    private Itemjadtar itemjadtar;

    private String accessory;

    private Double qty;

    private Double carat;

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


    public Itemjadtaraccessry() {
    }


    public Itemjadtaraccessry(String accessory, Double carat, Double weight, Double qty,Double rate, Double amount) {
        this.accessory = accessory;
        this.carat = carat;
        this.weight = weight;
        this.qty = qty;
        this.rate = rate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customaccess getCustomaccess() {
        return customaccess;
    }

    public void setCustomaccess(Customaccess customaccess) {
        this.customaccess = customaccess;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public Itemjadtar getItemjadtar() {
        return itemjadtar;
    }

    public void setItemjadtar(Itemjadtar itemjadtar) {
        this.itemjadtar = itemjadtar;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getCarat() {
        return carat;
    }

    public void setCarat(Double carat) {
        this.carat = carat;
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

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}


