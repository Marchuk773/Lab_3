package ua.lviv.iot.tools.spring.first.rest.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"manufacturer\"")
public class Manufacturer {
    private String name;
    private String owner;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("manufacturer")
    private Set<Tool> tools;

    public Manufacturer(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public Manufacturer() {
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public Integer getId() {
        return id;
    }

    public Set<Tool> getTools() {
        return tools;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTools(Set<Tool> tools) {
        this.tools = tools;
    }

}