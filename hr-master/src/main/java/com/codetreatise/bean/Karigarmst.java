package com.codetreatise.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "karigarmst")
public class Karigarmst {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String phone;

    private String addr;

    private String email;

    private Double labour;

    private Double labourperc;

    private Boolean isDele = false;

    private Boolean isCncl = false;

    private Timestamp datestamp = new Timestamp(new Date().getTime());

    private Integer userid = 0;

    private Integer editid = 0;

    private Double discountPerc;

    @OneToMany(mappedBy = "karigarmst",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Items> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getLabour() {
        return labour;
    }

    public void setLabour(Double labour) {
        this.labour = labour;
    }

    public Double getLabourperc() {
        return labourperc;
    }

    public void setLabourperc(Double labourperc) {
        this.labourperc = labourperc;
    }

    public Boolean getDele() {
        return isDele;
    }

    public void setDele(Boolean dele) {
        isDele = dele;
    }

    public Boolean getCncl() {
        return isCncl;
    }

    public void setCncl(Boolean cncl) {
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

    public Double getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(Double discountPerc) {
        this.discountPerc = discountPerc;
    }

    @Override
    public String toString() {
        return name;
    }
}
