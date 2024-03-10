package com.example.myapp.responsePojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Identity {
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "type")
    private String type;
    @XmlAttribute(name = "verifiedName")
    private String verifiedName;
}
