package com.stopec.gy.pojo.res.order;

import java.util.Date;

public class outputxml001 {

    private String returnid;//返回编号	not null	varchar(6)	正确返回0，错误返回-1
    private String returnmsg;//错误信息文本		varchar(1000)	正确为空，错误填写错误原因。
    private String aac001;//个人编号	not null	varchar(20)
    private String aac002	;//身份证号	not null	varchar(18)
    private String Aac003;//姓名	not null	varchar(50)
    private String hisOrderId;//His订单号	not null	varchar(30)
    private String aka130;//医疗类别代码	not null	varchar(6)
    private String akc193;//门诊诊断编码（主诊断）	见备注	varchar(20)	门诊诊断的病种代码，见病种代码icd-10，医院门诊特殊疾病主诊断不能为空，药店购药和普通门诊可为空。
    private String bkc020;//门诊诊断中文名称	见备注 	varchar(200)	门特门诊必需上传(药店购药无需上传)
    private String bkc014;//特慢病病种编码	见备注	varchar(20)
    private String bkc117;//	特慢病病种名称	见备注	varchar(100)	指病种的中文名称(门特必传、普通门诊、药店购药无需上传)
    private String bkc131;//	经办人姓名	not null	varchar(100)
    private Date aae030;//	费用发生时间	not null	date
    private int nums;//	明细记录数量	not null	number(14)	一次交易不能超过50条。
    private String bke019;//	费用明细序号	not null	varchar(30)	医疗机构费用明细序号（同一次就诊不能重复）
    private String bke030;//	商品码	null	varchar(100)	药店购药有商品码的必传。无商品码的可不传。
    private String ake001;//	社保三大目录统一编码	not null	varchar(20)	中心目录编码
    private String ake002;//	社保三大目录名称	not null	varchar(200)	中心目录名称
    private String bke026;//	院内收费项目编码	not null	varchar(20)	医院(药店)内部收费项目编码
    private String bke027;//	院内收费项目名称	not null	varchar(100)	医药机构自主登记的具体药品、诊疗项目、服务设施名称，可能与收费项目名称有差异，便于对照和审批
    private String aka074_yn;//	院内收费项目规格	见备注	varchar(50)
    private String aka070_yn;//院内收费项目剂型	见备注	varchar(300)
    private String aka067;//	最小收费单位	见备注	varchar(20)
    private String aka067_yn;//	本单收费单位	见备注	varchar(20)
    private int akc226;//数量	见备注	number(14,4)
    private int akc225;//	单价	见备注	number(14,4)
    private int akc264;//	单条费用总额	见备注	number(14,4)
    private String bkc045;//	用法	见备注	varchar(6)
    private int bkc044;//	每次用量	见备注	number(14,2)
    private int aka074;//	与单次用量同单位规格	见备注	number(14,2)
    private String bkc048;//	处方医生编码	见备注	varchar(20)	药店购药时，可不传。其它结算类别必传。
    private String bkc049;//	处方医生姓名	见备注	varchar(50)	药店购药时，可不传。其它结算类别必传。
    private String aaz307;//	科室编码	见备注	varchar(30)	药店购药时，可不传。其它结算类别必传。
    private String  aae386;//	科室名称	见备注	varchar(150)	药店购药时，可不传。其它结算类别必传。
    private int ake003;//医保项目分类	not null	number(6)
    private String bke022;//	门诊诊断编码	见备注	varchar(20)	药店购药时，可不传。其它结算类别必传。
    private String akc076;//	门诊诊断名称	见备注	varchar(20)	药店购药时，可不传。其它结算类别必传。
    private String yke112;//	医嘱记录序号	null	varchar(20)	非药品医嘱可不填
    private String aae072;//	单据号	null	varchar(20)
    private String aka017;//	单据类型	null	varchar(3)
    private String yke330;//	院外检查标志	null	varchar(1)	‘0’否，‘1’是
    private String xzyyspbz;//	限制用药审批标志	null	varchar(1)	如为限制性用药，医院需先审批该病人的病情是否符合限制用药的条件，1为符合按规定报销，0为自费。非限制性用药可以为空""

    public String getReturnid() {
        return returnid;
    }

    public void setReturnid(String returnid) {
        this.returnid = returnid;
    }

    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }

    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public String getAac003() {
        return Aac003;
    }

    public void setAac003(String aac003) {
        Aac003 = aac003;
    }

    public String getHisOrderId() {
        return hisOrderId;
    }

    public void setHisOrderId(String hisOrderId) {
        this.hisOrderId = hisOrderId;
    }

    public String getAka130() {
        return aka130;
    }

    public void setAka130(String aka130) {
        this.aka130 = aka130;
    }

    public String getAkc193() {
        return akc193;
    }

    public void setAkc193(String akc193) {
        this.akc193 = akc193;
    }

    public String getBkc020() {
        return bkc020;
    }

    public void setBkc020(String bkc020) {
        this.bkc020 = bkc020;
    }

    public String getBkc014() {
        return bkc014;
    }

    public void setBkc014(String bkc014) {
        this.bkc014 = bkc014;
    }

    public String getBkc117() {
        return bkc117;
    }

    public void setBkc117(String bkc117) {
        this.bkc117 = bkc117;
    }

    public String getBkc131() {
        return bkc131;
    }

    public void setBkc131(String bkc131) {
        this.bkc131 = bkc131;
    }

    public Date getAae030() {
        return aae030;
    }

    public void setAae030(Date aae030) {
        this.aae030 = aae030;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getBke019() {
        return bke019;
    }

    public void setBke019(String bke019) {
        this.bke019 = bke019;
    }

    public String getBke030() {
        return bke030;
    }

    public void setBke030(String bke030) {
        this.bke030 = bke030;
    }

    public String getAke001() {
        return ake001;
    }

    public void setAke001(String ake001) {
        this.ake001 = ake001;
    }

    public String getAke002() {
        return ake002;
    }

    public void setAke002(String ake002) {
        this.ake002 = ake002;
    }

    public String getBke026() {
        return bke026;
    }

    public void setBke026(String bke026) {
        this.bke026 = bke026;
    }

    public String getBke027() {
        return bke027;
    }

    public void setBke027(String bke027) {
        this.bke027 = bke027;
    }

    public String getAka074_yn() {
        return aka074_yn;
    }

    public void setAka074_yn(String aka074_yn) {
        this.aka074_yn = aka074_yn;
    }

    public String getAka070_yn() {
        return aka070_yn;
    }

    public void setAka070_yn(String aka070_yn) {
        this.aka070_yn = aka070_yn;
    }

    public String getAka067() {
        return aka067;
    }

    public void setAka067(String aka067) {
        this.aka067 = aka067;
    }

    public String getAka067_yn() {
        return aka067_yn;
    }

    public void setAka067_yn(String aka067_yn) {
        this.aka067_yn = aka067_yn;
    }

    public int getAkc226() {
        return akc226;
    }

    public void setAkc226(int akc226) {
        this.akc226 = akc226;
    }

    public int getAkc225() {
        return akc225;
    }

    public void setAkc225(int akc225) {
        this.akc225 = akc225;
    }

    public int getAkc264() {
        return akc264;
    }

    public void setAkc264(int akc264) {
        this.akc264 = akc264;
    }

    public String getBkc045() {
        return bkc045;
    }

    public void setBkc045(String bkc045) {
        this.bkc045 = bkc045;
    }

    public int getBkc044() {
        return bkc044;
    }

    public void setBkc044(int bkc044) {
        this.bkc044 = bkc044;
    }

    public int getAka074() {
        return aka074;
    }

    public void setAka074(int aka074) {
        this.aka074 = aka074;
    }

    public String getBkc048() {
        return bkc048;
    }

    public void setBkc048(String bkc048) {
        this.bkc048 = bkc048;
    }

    public String getBkc049() {
        return bkc049;
    }

    public void setBkc049(String bkc049) {
        this.bkc049 = bkc049;
    }

    public String getAaz307() {
        return aaz307;
    }

    public void setAaz307(String aaz307) {
        this.aaz307 = aaz307;
    }

    public String getAae386() {
        return aae386;
    }

    public void setAae386(String aae386) {
        this.aae386 = aae386;
    }

    public int getAke003() {
        return ake003;
    }

    public void setAke003(int ake003) {
        this.ake003 = ake003;
    }

    public String getBke022() {
        return bke022;
    }

    public void setBke022(String bke022) {
        this.bke022 = bke022;
    }

    public String getAkc076() {
        return akc076;
    }

    public void setAkc076(String akc076) {
        this.akc076 = akc076;
    }

    public String getYke112() {
        return yke112;
    }

    public void setYke112(String yke112) {
        this.yke112 = yke112;
    }

    public String getAae072() {
        return aae072;
    }

    public void setAae072(String aae072) {
        this.aae072 = aae072;
    }

    public String getAka017() {
        return aka017;
    }

    public void setAka017(String aka017) {
        this.aka017 = aka017;
    }

    public String getYke330() {
        return yke330;
    }

    public void setYke330(String yke330) {
        this.yke330 = yke330;
    }

    public String getXzyyspbz() {
        return xzyyspbz;
    }

    public void setXzyyspbz(String xzyyspbz) {
        this.xzyyspbz = xzyyspbz;
    }
}
