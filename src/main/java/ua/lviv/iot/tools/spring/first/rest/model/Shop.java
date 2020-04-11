package ua.lviv.iot.tools.spring.first.rest.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Shop {
    private String name;
    private int numberInTown;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "gardener_shops", joinColumns = {
            @JoinColumn(name = "shop_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "tool_id", nullable = true) })
    @JsonIgnoreProperties("shops")
    private Set<Tool> tools;

    public Shop(String name, int numberInTown) {
        this.name = name;
        this.numberInTown = numberInTown;
    }

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public int getNumberInTown() {
        return numberInTown;
    }

    public Integer getShopId() {
        return shopId;
    }

    public Set<Tool> getTools() {
        return tools;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberInTown(int numberInTown) {
        this.numberInTown = numberInTown;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public void setTools(Set<Tool> tools) {
        this.tools = tools;
    }

}