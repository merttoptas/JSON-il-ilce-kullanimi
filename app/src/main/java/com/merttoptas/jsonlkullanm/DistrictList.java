package com.merttoptas.jsonlkullanm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.merttoptas.jsonlkullanm.Model.DistrictDetail;

import java.util.List;

public class DistrictList {

    @SerializedName("districtDetail")
    @Expose
    private List<DistrictDetail> districtDetail = null;

    public List<DistrictDetail> getDistrictDetail() {
        return districtDetail;
    }

    public void setDistrictDetail(List<DistrictDetail> districtDetail) {
        this.districtDetail = districtDetail;
    }
}
