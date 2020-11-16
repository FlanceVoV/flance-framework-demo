package com.flance.auth.domain.auth.entity;

import com.flance.web.auth.model.BaseAuthority;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "FLANCE_AUTH")
public class Auth extends BaseAuthority {

    @Id
    private String id;

    private String type;

    private Boolean open;

    private String method;

    private String url;

    private String authority;

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Boolean isOpen() {
        return this.open;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
