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

    private String type;

    private String img;

    private String manufacturer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Tool() {
    }

    public Tool(String header, String description, Long price, String type, String img,
            String manufacturer, Integer id) {
        this.header = header;
        this.description = description;
        this.price = price;
        this.type = type;
        this.img = img;
        this.manufacturer = manufacturer;
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getImg() {
        return img;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((header == null) ? 0 : header.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((img == null) ? 0 : img.hashCode());
        result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tool other = (Tool) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (header == null) {
            if (other.header != null)
                return false;
        } else if (!header.equals(other.header))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (img == null) {
            if (other.img != null)
                return false;
        } else if (!img.equals(other.img))
            return false;
        if (manufacturer == null) {
            if (other.manufacturer != null)
                return false;
        } else if (!manufacturer.equals(other.manufacturer))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tool [header=" + header + ", description=" + description + ", price=" + price
                + ", type=" + type + ", img=" + img + ", manufacturer=" + manufacturer + ", id="
                + id + "]";
    }

}