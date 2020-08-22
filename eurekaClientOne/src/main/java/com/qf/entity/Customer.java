/**
 * Author:ysx
 * Date:2020/8/22/02211:09
 * FileName:Customer
 */


package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String naem;
    private Integer age;

}
