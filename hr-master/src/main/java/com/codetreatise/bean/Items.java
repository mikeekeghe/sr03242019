package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "karigarid")
    private Karigarmst karigarmst;

    @ManyToOne
    @JoinColumn(name = "partyid")
    private Acntmst acntmst;

    @ManyToOne
    @JoinColumn(name = "jadtarid")
    private Jadtarmst jadtarmst;

    private Date itemdate;

    private String itemcode;

    private String itemname;

    @Column(name = "scanimage")
    private Blob scanImage;

    @Column(name = "readyimage")
    private Blob readyImage;

    private boolean isDele = false;

    private boolean isCncl = false;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    private Integer userid = 0;

    private Integer editid = 0;

    private Double fine;

    private Double discount;

    private Double discountamt;

    private Double billamount;

    @OneToOne(mappedBy = "items")
    private Itemkarigar itemKarigar;

    @OneToOne(mappedBy = "items")
    private Itemjadtar itemJadtar;

    @OneToOne(mappedBy = "items")
    private Itemready itemReady;

    public Items() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Karigarmst getKarigarmst() {
        return karigarmst;
    }

    public void setKarigarmst(Karigarmst karigarmst) {
        this.karigarmst = karigarmst;
    }

    public Acntmst getAcntmst() {
        return acntmst;
    }

    public void setAcntmst(Acntmst acntmst) {
        this.acntmst = acntmst;
    }

    public Jadtarmst getJadtarmst() {
        return jadtarmst;
    }

    public void setJadtarmst(Jadtarmst jadtarmst) {
        this.jadtarmst = jadtarmst;
    }

    public Date getItemdate() {
        return itemdate;
    }

    public void setItemdate(Date itemdate) {
        this.itemdate = itemdate;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Blob getScanImage() {
        return scanImage;
    }

    public void setScanImage(Blob scanImage) {
        this.scanImage = scanImage;
    }

    public Blob getReadyImage() {
        return readyImage;
    }

    public void setReadyImage(Blob readyImage) {
        this.readyImage = readyImage;
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

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountamt() {
        return discountamt;
    }

    public void setDiscountamt(Double discountamt) {
        this.discountamt = discountamt;
    }

    public Double getBillamount() {
        return billamount;
    }

    public void setBillamount(Double billamount) {
        this.billamount = billamount;
    }

    public Itemkarigar getItemKarigar() {
        return itemKarigar;
    }

    public void setItemKarigar(Itemkarigar itemKarigar) {
        this.itemKarigar = itemKarigar;
    }

    public Itemjadtar getItemJadtar() {
        return itemJadtar;
    }

    public void setItemJadtar(Itemjadtar itemJadtar) {
        this.itemJadtar = itemJadtar;
    }

    public Itemready getItemReady() {
        return itemReady;
    }

    public void setItemReady(Itemready itemReady) {
        this.itemReady = itemReady;
    }

    @Override
    public String toString() {
        return itemname;
    }
}


