package com.example.myapp.responsePojo;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Payee {
    @XmlElement(name = "Amount")
    public Amount Amount;
    @XmlElement(name = "Info")
    public Info Info;
    @XmlAttribute
    private String addr;
    @XmlAttribute
    private long code;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private long seqNum;
    @XmlAttribute
    private String type;

}
