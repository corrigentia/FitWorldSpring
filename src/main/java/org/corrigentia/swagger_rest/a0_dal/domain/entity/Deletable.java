/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.corrigentia.swagger_rest.a0_dal.domain.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
/**
 *
 * @author gr.costache
 */
public abstract class Deletable {

    private boolean enabled = true;

}
