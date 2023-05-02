/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avanzada;



/**
 *
 * @author sadri
 */
public class OrdenCompra extends OrdenVenta {
    ;
    @Override
    public void setTipoOrden(){
        tipoOrden="Orden de Compra";
    }
        
    @Override
    public String getTipoOrden(){
        return tipoOrden;
    }
}
