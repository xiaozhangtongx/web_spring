package com.demon.spring.pojo;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author zhang
 * @since 2021-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String content;

    private String username;

    private Date uploaded;


}
