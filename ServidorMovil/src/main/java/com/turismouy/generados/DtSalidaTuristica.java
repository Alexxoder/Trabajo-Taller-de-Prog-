
package com.turismouy.generados;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtSalidaTuristica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtSalidaTuristica">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="topeTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cuposDisponibles" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaAlta" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="horaSalida" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="lugarSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaAltaString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaSalidaString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="horaSalidaString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtSalidaTuristica", propOrder = {
    "nombre",
    "topeTuristas",
    "cuposDisponibles",
    "fechaAlta",
    "fechaSalida",
    "horaSalida",
    "lugarSalida",
    "imagen",
    "fechaAltaString",
    "fechaSalidaString",
    "horaSalidaString"
})
public class DtSalidaTuristica {

    protected String nombre;
    protected int topeTuristas;
    protected int cuposDisponibles;
    protected Object fechaAlta;
    protected Object fechaSalida;
    protected Object horaSalida;
    protected String lugarSalida;
    protected String imagen;
    protected String fechaAltaString;
    protected String fechaSalidaString;
    protected String horaSalidaString;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad topeTuristas.
     * 
     */
    public int getTopeTuristas() {
        return topeTuristas;
    }

    /**
     * Define el valor de la propiedad topeTuristas.
     * 
     */
    public void setTopeTuristas(int value) {
        this.topeTuristas = value;
    }

    /**
     * Obtiene el valor de la propiedad cuposDisponibles.
     * 
     */
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    /**
     * Define el valor de la propiedad cuposDisponibles.
     * 
     */
    public void setCuposDisponibles(int value) {
        this.cuposDisponibles = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaAlta(Object value) {
        this.fechaAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSalida.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Define el valor de la propiedad fechaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaSalida(Object value) {
        this.fechaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad horaSalida.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getHoraSalida() {
        return horaSalida;
    }

    /**
     * Define el valor de la propiedad horaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setHoraSalida(Object value) {
        this.horaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad lugarSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugarSalida() {
        return lugarSalida;
    }

    /**
     * Define el valor de la propiedad lugarSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugarSalida(String value) {
        this.lugarSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAltaString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAltaString() {
        return fechaAltaString;
    }

    /**
     * Define el valor de la propiedad fechaAltaString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAltaString(String value) {
        this.fechaAltaString = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSalidaString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSalidaString() {
        return fechaSalidaString;
    }

    /**
     * Define el valor de la propiedad fechaSalidaString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSalidaString(String value) {
        this.fechaSalidaString = value;
    }

    /**
     * Obtiene el valor de la propiedad horaSalidaString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraSalidaString() {
        return horaSalidaString;
    }

    /**
     * Define el valor de la propiedad horaSalidaString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraSalidaString(String value) {
        this.horaSalidaString = value;
    }

}
