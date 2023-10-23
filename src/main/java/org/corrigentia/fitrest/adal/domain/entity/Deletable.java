/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.corrigentia.fitrest.adal.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@MappedSuperclass
/**
 *
 * @author gr.costache
 */
public abstract class Deletable {
    @Setter
    private boolean enabled = true;
}
