package com.example.entity;

import java.io.Serializable;

/**
 * t_permission_resource
 *
 * @author
 */
public class TPermissionResource implements Serializable {
    private Integer permissionid;

    private Integer resourceid;

    private static final long serialVersionUID = 1L;

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }
}