
package com.turismouy.generados;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtInscripcion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="costoInscripcion" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="fecha" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="fechaString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="imagenSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombreSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInscripcion", propOrder = {
    "cantTuristas",
    "costoInscripcion",
    "fecha",
    "fechaString",
    "imagenSalida",
    "nombreSalida"
})
public class DtInscripcion {

    protected int cantTuristas;
    protected float costoInscripcion;
    protected Object fecha;
    protected String fechaString;
    protected String imagenSalida;
    protected String nombreSalida;

    /**
     * Obtiene el valor de la propiedad cantTuristas.
     * 
     */
    public int getCantTuristas() {
        return cantTuristas;
    }

    /**
     * Define el valor de la propiedad cantTuristas.
     * 
     */
    public void setCantTuristas(int value) {
        this.cantTuristas = value;
    }

    /**
     * Obtiene el valor de la propiedad costoInscripcion.
     * 
     */
    public float getCostoInscripcion() {
        return costoInscripcion;
    }

    /**
     * Define el valor de la propiedad costoInscripcion.
     * 
     */
    public void setCostoInscripcion(float value) {
        this.costoInscripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFecha(Object value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaString() {
        return fechaString;
    }

    /**
     * Define el valor de la propiedad fechaString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaString(String value) {
        this.fechaString = value;
    }

    /**
     * Obtiene el valor de la propiedad imagenSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagenSalida() {
        return imagenSalida;
    }

    /**
     * Define el valor de la propiedad imagenSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagenSalida(String value) {
        this.imagenSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSalida() {
        return nombreSalida;
    }

    /**
     * Define el valor de la propiedad nombreSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSalida(String value) {
        this.nombreSalida = value;
    }

}
