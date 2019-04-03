package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "itemkarigar")
public class Itemkarigar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemsid")
    private Items items;

    private Date issuedate;

    private Double ghatgrswt;

    private Double mtwt;

    private String mtname;

    private Double ghatwt;

    private Double purity;

    private Double karigarlabour;

    private Double ghatwt2;

    private Double purity2;

    private Double karigarlabour2;

    private Double netFine;

    private boolean isDele = false;

    private boolean isCncl = false;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    private Integer userid = 0;

    private Integer editid = 0;

    @OneToMany(mappedBy = "itemkarigar")
    private List<Itemkarigaraccessry> itemkarigaraccessries;

    public Itemkarigar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Double getGhatgrswt() {
        return ghatgrswt;
    }

    public void setGhatgrswt(Double ghatgrswt) {
        this.ghatgrswt = ghatgrswt;
    }

    public Double getMtwt() {
        return mtwt;
    }

    public void setMtwt(Double mtwt) {
        this.mtwt = mtwt;
    }

    public String getMtname() {
        return mtname;
    }

    public void setMtname(String mtname) {
        this.mtname = mtname;
    }

    public Double getGhatwt() {
        return ghatwt;
    }

    public void setGhatwt(Double ghatwt) {
        this.ghatwt = ghatwt;
    }

    public Double getPurity() {
        return purity;
    }

    public void setPurity(Double purity) {
        this.purity = purity;
    }

    public Double getKarigarlabour() {
        return karigarlabour;
    }

    public void setKarigarlabour(Double karigarlabour) {
        this.karigarlabour = karigarlabour;
    }

    public Double getGhatwt2() {
        return ghatwt2;
    }

    public void setGhatwt2(Double ghatwt2) {
        this.ghatwt2 = ghatwt2;
    }

    public Double getPurity2() {
        return purity2;
    }

    public void setPurity2(Double purity2) {
        this.purity2 = purity2;
    }

    public Double getKarigarlabour2() {
        return karigarlabour2;
    }

    public void setKarigarlabour2(Double karigarlabour2) {
        this.karigarlabour2 = karigarlabour2;
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

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<Itemkarigaraccessry> getItemkarigaraccessries() {
        return itemkarigaraccessries;
    }

    public void setItemkarigaraccessries(List<Itemkarigaraccessry> itemkarigaraccessries) {
        this.itemkarigaraccessries = itemkarigaraccessries;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}


