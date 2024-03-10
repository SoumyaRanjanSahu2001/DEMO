package com.example.myapp.responsePojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Txn {
    @XmlAttribute
    private long custRef;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private int initiationMode;
    @XmlAttribute
    private String note;
    @XmlAttribute
    private  int purpose;
    @XmlAttribute
    private int refCategory;
    @XmlAttribute
    private String refId;
    @XmlAttribute
    private String refUrl;
    @XmlAttribute
    private String ts;
    @XmlAttribute
    private String type;
}
