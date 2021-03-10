package com.vo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * T_DA_HYFL
 *
 * @author
 */
public class TDaHyfl implements Serializable {
    private Long id;

    private LocalDate fdate;

    private String hyfl;

    private String hysx;

    private String hybk;

    private String bz;

    public TDaHyfl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFdate() {
        return fdate;
    }

    public void setFdate(LocalDate fdate) {
        this.fdate = fdate;
    }

    public String getHyfl() {
        return hyfl;
    }

    public void setHyfl(String hyfl) {
        this.hyfl = hyfl;
    }

    public String getHysx() {
        return hysx;
    }

    public void setHysx(String hysx) {
        this.hysx = hysx;
    }

    public String getHybk() {
        return hybk;
    }

    public void setHybk(String hybk) {
        this.hybk = hybk;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}