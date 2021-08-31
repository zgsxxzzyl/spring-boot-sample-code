package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CalculateWriteoffSplitMonth implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String pdCode;
    private BigDecimal amt;
    private String sn;
    private Date wrtOffAcctStart;
    private Date wrtOffAcctEnd;
    private String bookEntrTp;
    private String bookEntrUser;
    private String bookEntrBrBnk;
    private String bookEntrStat;
    private String bookEntrRsltDesc;
    private Date bookEntrTm;
    private String pyDt;
    private Date dataMon;
    private String brBnk;
    private String dataTp;
    private String splitRslt;

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

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
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

    public String getPyDt() {
        return pyDt;
    }

    public void setPyDt(String pyDt) {
        this.pyDt = pyDt == null ? null : pyDt.trim();
    }

    public Date getDataMon() {
        return dataMon;
    }

    public void setDataMon(Date dataMon) {
        this.dataMon = dataMon;
    }

    public String getBrBnk() {
        return brBnk;
    }

    public void setBrBnk(String brBnk) {
        this.brBnk = brBnk == null ? null : brBnk.trim();
    }

    public String getDataTp() {
        return dataTp;
    }

    public void setDataTp(String dataTp) {
        this.dataTp = dataTp == null ? null : dataTp.trim();
    }

    public String getSplitRslt() {
        return splitRslt;
    }

    public void setSplitRslt(String splitRslt) {
        this.splitRslt = splitRslt == null ? null : splitRslt.trim();
    }
}