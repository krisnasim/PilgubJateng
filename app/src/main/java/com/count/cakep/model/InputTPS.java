package com.count.cakep.model;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.List;

/**
 * Created by jonat on 09/10/2017.
 */

public class InputTPS {

    //variables all here
    private String fullName;
    private String nrpNumber;
    private String voteLocation;
    private int amountDPT;
    private List<Integer> amountVoteNumber;
    private int amountVote;
    private int amountIllegalVote;
    private Bitmap imageVote;
    private Date voteDateCreated;
    private Date voteDateUpdated;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNrpNumber() {
        return nrpNumber;
    }

    public void setNrpNumber(String nrpNumber) {
        this.nrpNumber = nrpNumber;
    }

    public String getVoteLocation() {
        return voteLocation;
    }

    public void setVoteLocation(String inputLocation) {
        this.voteLocation = inputLocation;
    }

    public int getAmountDPT() {
        return amountDPT;
    }

    public void setAmountDPT(int amountDPT) {
        this.amountDPT = amountDPT;
    }

    public List<Integer> getAmountVoteNumber() {
        return amountVoteNumber;
    }

    public void setAmountVoteNumber(List<Integer> amountVoteNumber) {
        this.amountVoteNumber = amountVoteNumber;
    }

    public int getAmountVote() {
        return amountVote;
    }

    public void setAmountVote(int amountVote) {
        this.amountVote = amountVote;
    }

    public int getAmountIllegalVote() {
        return amountIllegalVote;
    }

    public void setAmountIllegalVote(int amountIllegalVote) {
        this.amountIllegalVote = amountIllegalVote;
    }

    public Bitmap getImageVote() {
        return imageVote;
    }

    public void setImageVote(Bitmap imageVote) {
        this.imageVote = imageVote;
    }

    public Date getVoteDateCreated() {
        return voteDateCreated;
    }

    public void setVoteDateCreated(Date voteDateCreated) {
        this.voteDateCreated = voteDateCreated;
    }

    public Date getVoteDateUpdated() {
        return voteDateUpdated;
    }

    public void setVoteDateUpdated(Date voteDateUpdated) {
        this.voteDateUpdated = voteDateUpdated;
    }
}
