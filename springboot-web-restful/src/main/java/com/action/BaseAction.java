package com.action;

import java.io.Serializable;
import java.util.List;

public interface BaseAction<T, Id extends Serializable> {
    /**
     * GET
     *
     * @param id
     * @return
     */
    public T query(Id id);

    /**
     * GET
     *
     * @return
     */
    public List<T> queryAll();

    /**
     * POST
     *
     * @return
     */
    public Id create(T t);

    /**
     * DELETE
     *
     * @param id
     * @return
     */
    public boolean delete(Id id);

    /**
     * PUT
     *
     * @param t
     * @return
     */
    public boolean update(T t);
}
