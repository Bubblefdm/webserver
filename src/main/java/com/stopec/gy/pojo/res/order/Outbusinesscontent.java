package com.stopec.gy.pojo.res.order;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Outbusinesscontent {
    @XmlElement(name = "aac002")
    private String aac002;//身份证号	not null	varchar(18)
    @XmlElement(name = "aac003")
    private String aac003;//姓名	not null	varchar(50)
    @XmlElement(name = "hisOrderId")
    private String hisOrderId;//His订单号	not null	varchar(30)
    @XmlElement(name = "aka130")
    private String aka130;//医疗类别代码	not null	varchar(6)
    @XmlElement(name = "akc193")
    private String akc193;//门诊诊断编码（主诊断）	见备注	varchar(20)	门诊诊断的病种代码，见病种代码icd-10，医院门诊特殊疾病主诊断不能为空，药店购药和普通门诊可为空。
    @XmlElement(name = "bkc020")
    private String bkc020;//门诊诊断中文名称	见备注 	varchar(200)	门特门诊必需上传(药店购药无需上传)
    @XmlElement(name = "disease")
    private Disease disease;


    private String bkc014;//特慢病病种编码	见备注	varchar(20)
    private String bkc117;//	特慢病病种名称	见备注	varchar(100)	指病种的中文名称(门特必传、普通门诊、药店购药无需上传)
    @XmlElement(name = "bkc131")
    private String bkc131;//	经办人姓名	not null	varchar(100)
    @XmlElement(name = "aae030")
    private Date aae030;//	费用发生时间	not null	date
    @XmlElement(name = "nums")//暂时写到这

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
    private String aae386;//	科室名称	见备注	varchar(150)	药店购药时，可不传。其它结算类别必传。
    private int ake003;//医保项目分类	not null	number(6)
    private String bke022;//	门诊诊断编码	见备注	varchar(20)	药店购药时，可不传。其它结算类别必传。
    private String akc076;//	门诊诊断名称	见备注	varchar(20)	药店购药时，可不传。其它结算类别必传。
    private String yke112;//	医嘱记录序号	null	varchar(20)	非药品医嘱可不填
    private String aae072;//	单据号	null	varchar(20)
    private String aka017;//	单据类型	null	varchar(3)
    private String yke330;//	院外检查标志	null	varchar(1)	‘0’否，‘1’是
    private String xzyyspbz;//	限制用药审批标志	null	varchar(1)	如为限制性用药，医院需先审批该病人的病情是否符合限制用药的条件，1为符合按规定报销，0为自费。非限制性用药可以为空""
}
