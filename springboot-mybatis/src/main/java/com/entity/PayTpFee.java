package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayTpFee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String pdCode;
    private Date pyDt;
    private BigDecimal amt;
    private String wrtOffAcctRgon;
    private Date wrtOffAcctStart;
    private Date wrtOffAcctEnd;
    private String wrtOffAcctMon;
    private String lastWrtOffAcct;
    private String partWrtOffAcct;
    private String wrtOffAcctUser;
    private Date wrtOffAcctTm;
    private String dataSrc;
    private String checked;
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

    public Date getPyDt() {
        return pyDt;
    }

    public void setPyDt(Date pyDt) {
        this.pyDt = pyDt;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getWrtOffAcctRgon() {
        return wrtOffAcctRgon;
    }

    public void setWrtOffAcctRgon(String wrtOffAcctRgon) {
        this.wrtOffAcctRgon = wrtOffAcctRgon == null ? null : wrtOffAcctRgon.trim();
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

    public String getWrtOffAcctMon() {
        return wrtOffAcctMon;
    }

    public void setWrtOffAcctMon(String wrtOffAcctMon) {
        this.wrtOffAcctMon = wrtOffAcctMon == null ? null : wrtOffAcctMon.trim();
    }

    public String getLastWrtOffAcct() {
        return lastWrtOffAcct;
    }

    public void setLastWrtOffAcct(String lastWrtOffAcct) {
        this.lastWrtOffAcct = lastWrtOffAcct == null ? null : lastWrtOffAcct.trim();
    }

    public String getPartWrtOffAcct() {
        return partWrtOffAcct;
    }

    public void setPartWrtOffAcct(String partWrtOffAcct) {
        this.partWrtOffAcct = partWrtOffAcct == null ? null : partWrtOffAcct.trim();
    }

    public String getWrtOffAcctUser() {
        return wrtOffAcctUser;
    }

    public void setWrtOffAcctUser(String wrtOffAcctUser) {
        this.wrtOffAcctUser = wrtOffAcctUser == null ? null : wrtOffAcctUser.trim();
    }

    public Date getWrtOffAcctTm() {
        return wrtOffAcctTm;
    }

    public void setWrtOffAcctTm(Date wrtOffAcctTm) {
        this.wrtOffAcctTm = wrtOffAcctTm;
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
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