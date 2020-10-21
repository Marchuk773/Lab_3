package ua.lviv.iot.tools.spring.first.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tool {

    private String header;

    private String description;

    private Long price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Tool(String header, String description, Long price, Integer id) {
        this.header = header;
        this.description = description;
        this.price = price;
        this.id = id;
    }
    
    public Tool() {};

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String descripton) {
        this.description = descripton;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}