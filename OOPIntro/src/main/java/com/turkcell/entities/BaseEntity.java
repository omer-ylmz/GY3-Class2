package com.turkcell.entities;

import java.util.Date;

public class BaseEntity<T> {  //generic class //bir id var ancak sana kullancağım zaman vereceğim

    private T id;
    private Date createdDate;
    private Date deletedDate;
    private Date uptadedDate;

    public Date getUptadedDate() {
        return uptadedDate;
    }

    public void setUptadedDate(Date uptadedDate) {
        this.uptadedDate = uptadedDate;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    private Date updatedDate;
}
