package com.example.jsonandxmlprocessing.entities.categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLCategoryStatsList {

    @XmlElementWrapper(name = "categories")
    List<XMLCategoryStatsDTO> stats;

    public XMLCategoryStatsList() {
    }

    public XMLCategoryStatsList(List<XMLCategoryStatsDTO> stats) {
        this.stats = stats;
    }
}
