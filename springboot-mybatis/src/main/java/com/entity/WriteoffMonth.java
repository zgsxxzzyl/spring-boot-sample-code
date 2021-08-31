package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WriteoffMonth implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String pdCode;
    private BigDecimal wrtOffAmt;
    private String wrtOffAcctSn;
    private Date wrtOffAcctStart;
    private Date wrtOffAcctEnd;
    private String bookEntrTp;
    private String bookEntrUser;
    private String bookEntrBrBnk;
    private String bookEntrStat;
    private String bookEntrRsltDesc;
    private Date bookEntrTm;
    private Date pyDt;
    private Date dataMon;
    private String chckUser;
    private Date chckTm;
    private String crtUser;
    private Date crtTm;
    private String updtUser;
    private Date updtTm;
    private String delUser;
    private Date delTm;
    private String deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode == null ? null : pdCode.trim();
    }

    public BigDecimal getWrtOffAmt() {
        return wrtOffAmt;
    }

    public void setWrtOffAmt(BigDecimal wrtOffAmt) {
        this.wrtOffAmt = wrtOffAmt;
    }

    public String getWrtOffAcctSn() {
        return wrtOffAcctSn;
    }

    public void setWrtOffAcctSn(String wrtOffAcctSn) {
        this.wrtOffAcctSn = wrtOffAcctSn == null ? null : wrtOffAcctSn.trim();
    }

    public Date getWrtOffAcctStart() {
        return wrtOffAcctStart;
    }

    public void setWrtOffAcctStart(Date wrtOffAcctStart) {
        this.wrtOffAcctStart = wrtOffAcctStart;
    }

    public Date getWrtOffAcctEnd() {
        return wrtOffAcctEnd;
    }

    public void setWrtOffAcctEnd(Date wrtOffAcctEnd) {
        this.wrtOffAcctEnd = wrtOffAcctEnd;
    }

    public String getBookEntrTp() {
        return bookEntrTp;
    }

    public void setBookEntrTp(String bookEntrTp) {
        this.bookEntrTp = bookEntrTp == null ? null : bookEntrTp.trim();
    }

    public String getBookEntrUser() {
        return bookEntrUser;
    }

    public void setBookEntrUser(String bookEntrUser) {
        this.bookEntrUser = bookEntrUser == null ? null : bookEntrUser.trim();
    }

    public String getBookEntrBrBnk() {
        return bookEntrBrBnk;
    }

    public void setBookEntrBrBnk(String bookEntrBrBnk) {
        this.bookEntrBrBnk = bookEntrBrBnk == null ? null : bookEntrBrBnk.trim();
    }

    public String getBookEntrStat() {
        return bookEntrStat;
    }

    public void setBookEntrStat(String bookEntrStat) {
        this.bookEntrStat = bookEntrStat == null ? null : bookEntrStat.trim();
    }

    public String getBookEntrRsltDesc() {
        return bookEntrRsltDesc;
    }

    public void setBookEntrRsltDesc(String bookEntrRsltDesc) {
        this.bookEntrRsltDesc = bookEntrRsltDesc == null ? null : bookEntrRsltDesc.trim();
    }

    public Date getBookEntrTm() {
        return bookEntrTm;
    }

    public void setBookEntrTm(Date bookEntrTm) {
        this.bookEntrTm = bookEntrTm;
    }

    public Date getPyDt() {
        return pyDt;
    }

    public void setPyDt(Date pyDt) {
        this.pyDt = pyDt;
    }

    public Date getDataMon() {
        return dataMon;
    }

    public void setDataMon(Date dataMon) {
        this.dataMon = dataMon;
    }

    public String getChckUser() {
        return chckUser;
    }

    public void setChckUser(String chckUser) {
        this.chckUser = chckUser == null ? null : chckUser.trim();
    }

    public Date getChckTm() {
        return chckTm;
    }

    public void setChckTm(Date chckTm) {
        this.chckTm = chckTm;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser == null ? null : crtUser.trim();
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public String getUpdtUser() {
        return updtUser;
    }

    public void setUpdtUser(String updtUser) {
        this.updtUser = updtUser == null ? null : updtUser.trim();
    }

    public Date getUpdtTm() {
        return updtTm;
    }

    public void setUpdtTm(Date updtTm) {
        this.updtTm = updtTm;
    }

    public String getDelUser() {
        return delUser;
    }

    public void setDelUser(String delUser) {
        this.delUser = delUser == null ? null : delUser.trim();
    }

    public Date getDelTm() {
        return delTm;
    }

    public void setDelTm(Date delTm) {
        this.delTm = delTm;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }
}