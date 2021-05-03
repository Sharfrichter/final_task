package model;

import annotations.Column;

import java.util.Date;

public class Recipe {
    @Column(name = "id")
    private Integer id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "drug_id")
    private Integer drugId;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "begin_date")
    private Date begin;
    @Column(name = "end_date")
    private Date end;

    public Recipe() {
    }

    public Recipe(Integer clientId, Integer doctorId, Integer drugId, Boolean isActive, Date begin, Date end) {
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.drugId = drugId;
        this.isActive = isActive;
        this.begin = begin;
        this.end = end;
    }

    public Recipe(Integer id, Integer clientId, Integer doctorId, Integer drugId, Boolean isActive, Date begin, Date end) {
        this.id = id;
        this.clientId = clientId;
        this.doctorId = doctorId;
        this.drugId = drugId;
        this.isActive = isActive;
        this.begin = begin;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", doctorId=" + doctorId +
                ", drugId=" + drugId +
                ", isActive=" + isActive +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}
