package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "acntmst")
public class Acntmst {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String alias;
    private String phone;
    private String addr;
    private Boolean isDele = false;
    private Boolean isCncl = false;
    private Timestamp datestamp = new Timestamp(new Date().getTime());
    private Integer userid = 0;
    private Integer editid = 0;
    private String email;
    private Double discountPerc;

    @OneToMany(mappedBy = "acntmst",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Items> items;


    public Acntmst() {
    }

    public Acntmst(String name, Timestamp datestamp) {
        this.name = name;
        this.datestamp = datestamp;
    }

    public Acntmst(String name, String alias, String phone, String addr, Boolean isDele, Boolean isCncl, Timestamp datestamp, String email, Double discountPerc, Integer userid, Integer editid) {

        this.name = name;
        this.alias = alias;
        this.phone = phone;
        this.addr = addr;
        this.isDele = isDele;
        this.isCncl = isCncl;
        this.datestamp = datestamp;
        this.email = email;
        this.discountPerc = discountPerc;
        this.userid = userid;
        this.editid = editid;
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

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Boolean getIsDele() {
        return this.isDele;
    }

    public void setIsDele(Boolean isDele) {
        this.isDele = isDele;
    }

    public Boolean getIsCncl() {
        return this.isCncl;
    }

    public void setIsCncl(Boolean isCncl) {
        this.isCncl = isCncl;
    }

    public Timestamp getDatestamp() {
        return this.datestamp;
    }

    public void setDatestamp(Timestamp datestamp) {
        this.datestamp = datestamp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getDiscountPerc() {
        return this.discountPerc;
    }

    public void setDiscountPerc(Double discountPerc) {
        this.discountPerc = discountPerc;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getEditid() {
        return this.editid;
    }

    public void setEditid(Integer editid) {
        this.editid = editid;
    }

    @Override
    public String toString() {
        return String.format("%s %s", alias,name);
    }

}
