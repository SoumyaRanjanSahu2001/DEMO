package com.example.myapp.responsePojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Payer {
    @XmlElement(name = "Amount")
    public Amount Amount;
    @XmlAttribute
    private String addr;
    @XmlAttribute
    private int code;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int seqNum;
    @XmlAttribute
    private String type;
}
