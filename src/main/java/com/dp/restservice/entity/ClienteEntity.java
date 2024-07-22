package com.dp.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Table;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clientes") 
public class ClienteEntity {
    
	@Id
    @Column(name = "id_documento")
    private String idDocumento; // ID del cliente, que se usa como clave primaria
    
    @Column(name = "tipo_documento")
    private String tipoDocumento; // Tipo de documento (Cédula, Pasaporte)
    
    @Column(name = "primer_nombre")
    private String primerNombre;
    
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    
    @Column(name = "primer_apellido")
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

}