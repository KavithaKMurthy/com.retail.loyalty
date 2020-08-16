package com.retail.loyalty.models;

import io.swagger.annotations.ApiModelProperty;

public class CustomerClubcard {
    @ApiModelProperty(hidden=true)
    private long clubcardId;
    @ApiModelProperty(hidden=true)
    private long primaryClubcardId;
    @ApiModelProperty(hidden=true)
    private int clubcardType;
    @ApiModelProperty(hidden=true)
    private int clubcardStatus;

    public long getClubcardId() {
        return clubcardId;
    }

    public void setClubcardId(long clubcardId) {
        this.clubcardId = clubcardId;
    }

    public long getPrimaryClubcardId() {
        return primaryClubcardId;
    }

    public void setPrimaryClubcardId(long primaryClubcardId) {
        this.primaryClubcardId = primaryClubcardId;
    }

    public int getClubcardType() {
        return clubcardType;
    }

    public void setClubcardType(int clubcardType) {
        this.clubcardType = clubcardType;
    }

    public int getClubcardStatus() {
        return clubcardStatus;
    }

    public void setClubcardStatus(int clubcardStatus) {
        this.clubcardStatus = clubcardStatus;
    }
}
