package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customaccess")
public class Customaccess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    private int type;

    private double carat;

    private double weight;

    private double rate;

    private String note;

    private boolean isDele = false;

    private boolean isCncl = false;

    private int userid = 0;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    @OneToMany(mappedBy = "customaccess")
    private List<Itemkarigaraccessry> itemkarigaraccessryList;

    @OneToMany(mappedBy = "customaccess")
    private List<Itemjadtaraccessry> itemjadtaraccessryList;

    @OneToMany(mappedBy = "customaccess")
    private List<Itemreadyaccessry> itemreadyaccessryList;


    public Customaccess() {
    }

    public Customaccess(String name, int type, double carat, double weight, double rate, String note, boolean isDele, boolean isCncl, int userid, Timestamp datestamp) {
        this.name = name;
        this.type = type;
        this.carat = carat;
        this.weight = weight;
        this.rate = rate;
        this.note = note;
        this.isDele = isDele;
        this.isCncl = isCncl;
        this.userid = userid;
        this.datestamp = datestamp;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getCarat() {
        return this.carat;
    }

    public void setCarat(double carat) {
        this.carat = carat;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIsDele() {
        return this.isDele;
    }

    public void setIsDele(boolean isDele) {
        this.isDele = isDele;
    }

    public boolean isIsCncl() {
        return this.isCncl;
    }

    public void setIsCncl(boolean isCncl) {
        this.isCncl = isCncl;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getDatestamp() {
        return this.datestamp;
    }

    public void setDatestamp(Timestamp datestamp) {
        this.datestamp = datestamp;
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


    public List<Itemkarigaraccessry> getItemkarigaraccessryList() {
        return itemkarigaraccessryList;
    }

    public void setItemkarigaraccessryList(List<Itemkarigaraccessry> itemkarigaraccessryList) {
        this.itemkarigaraccessryList = itemkarigaraccessryList;
    }

    public List<Itemjadtaraccessry> getItemjadtaraccessryList() {
        return itemjadtaraccessryList;
    }

    public void setItemjadtaraccessryList(List<Itemjadtaraccessry> itemjadtaraccessryList) {
        this.itemjadtaraccessryList = itemjadtaraccessryList;
    }

    public List<Itemreadyaccessry> getItemreadyaccessryList() {
        return itemreadyaccessryList;
    }

    public void setItemreadyaccessryList(List<Itemreadyaccessry> itemreadyaccessryList) {
        this.itemreadyaccessryList = itemreadyaccessryList;
    }

    @Override
    public String toString() {
        return name;
    }
}


