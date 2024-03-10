package com.example.myapp.responsePojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "ReqPay")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqPay {
    @XmlElement(name = "Head")
    public Head Head;
    @XmlElement(name = "Txn")
    public Txn Txn;
    @XmlElement(name = "Payer")
    public Payer Payer;
    @XmlElement(name = "Payees")
    public Payees Payees;
}
