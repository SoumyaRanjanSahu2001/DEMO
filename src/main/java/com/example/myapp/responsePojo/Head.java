package com.example.myapp.responsePojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Head {
    @XmlAttribute
    private String msgId;
    @XmlAttribute
    private long orgId;
    @XmlAttribute
    private String ts;
    @XmlAttribute
    private double ver;
}
