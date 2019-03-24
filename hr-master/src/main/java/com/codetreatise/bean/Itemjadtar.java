package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "itemjadtar")
public class Itemjadtar {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "itemsid")
    private Items items;

    private Date recdate;

    private Double jadaigrswt;

    private Double kundan;

    private String racket;

    private Double totalkundan;

    private Double totalamount;

    private Double totalvax;

    private boolean isDele = false;

    private boolean isCncl = false;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    private Integer userid = 0;

    private Integer editid = 0;

    @OneToMany(mappedBy = "itemjadtar")
    private List<Itemjadtaraccessry> itemjadtaraccessryList;

    public Itemjadtar() {
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

    public Date getRecdate() {
        return recdate;
    }

    public void setRecdate(Date recdate) {
        this.recdate = recdate;
    }

    public Double getJadaigrswt() {
        return jadaigrswt;
    }

    public void setJadaigrswt(Double jadaigrswt) {
        this.jadaigrswt = jadaigrswt;
    }

    public Double getKundan() {
        return kundan;
    }

    public void setKundan(Double kundan) {
        this.kundan = kundan;
    }

    public String getRacket() {
        return racket;
    }

    public void setRacket(String racket) {
        this.racket = racket;
    }

    public Double getTotalkundan() {
        return totalkundan;
    }

    public void setTotalkundan(Double totalkundan) {
        this.totalkundan = totalkundan;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Double getTotalvax() {
        return totalvax;
    }

    public void setTotalvax(Double totalvax) {
        this.totalvax = totalvax;
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

    public List<Itemjadtaraccessry> getItemjadtaraccessryList() {
        return itemjadtaraccessryList;
    }

    public void setItemjadtaraccessryList(List<Itemjadtaraccessry> itemjadtaraccessryList) {
        this.itemjadtaraccessryList = itemjadtaraccessryList;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}


