package com.count.cakep.model;

import java.util.Date;

/**
 * Created by jonat on 09/10/2017.
 */

public class Direktif {

    //variables all here
    private String direktifTitle;
    private Date direktifDate;
    private String direktifDesc;
    private String direktifStatus;
    private String direktifID;

    public String getDirektifTitle() {
        return direktifTitle;
    }

    public void setDirektifTitle(String direktifTitle) {
        this.direktifTitle = direktifTitle;
    }

    public Date getDirektifDate() {
        return direktifDate;
    }

    public void setDirektifDate(Date direktifDate) {
        this.direktifDate = direktifDate;
    }

    public String getDirektifDesc() {
        return direktifDesc;
    }

    public void setDirektifDesc(String direktifDesc) {
        this.direktifDesc = direktifDesc;
    }

    public String getDirektifID() {
        return direktifID;
    }

    public void setDirektifID(String direktifID) {
        this.direktifID = direktifID;
    }

    public String getDirektifStatus() {
        return direktifStatus;
    }

    public void setDirektifStatus(String direktifStatus) {
        this.direktifStatus = direktifStatus;
    }
}
