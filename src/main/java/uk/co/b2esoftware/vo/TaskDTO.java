package uk.co.b2esoftware.vo;

import java.io.Serializable;

/**
 * Created by TheEwook on 06/02/2014.
 */
public class TaskDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
