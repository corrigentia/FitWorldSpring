/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
/**
 *
 * @author gr.costache
 */
public abstract class Deletable {

    @Getter
    @Setter
    private boolean enabled = true;

}
