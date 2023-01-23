
package com.turismouy.generados;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtDepartamento complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtDepartamento">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nombreDepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="urlDepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="descripcionDepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtDepartamento", propOrder = {
    "nombreDepto",
    "urlDepto",
    "descripcionDepto"
})
public class DtDepartamento {

    protected String nombreDepto;
    protected String urlDepto;
    protected String descripcionDepto;

    /**
     * Obtiene el valor de la propiedad nombreDepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDepto() {
        return nombreDepto;
    }

    /**
     * Define el valor de la propiedad nombreDepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDepto(String value) {
        this.nombreDepto = value;
    }

    /**
     * Obtiene el valor de la propiedad urlDepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlDepto() {
        return urlDepto;
    }

    /**
     * Define el valor de la propiedad urlDepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlDepto(String value) {
        this.urlDepto = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionDepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionDepto() {
        return descripcionDepto;
    }

    /**
     * Define el valor de la propiedad descripcionDepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionDepto(String value) {
        this.descripcionDepto = value;
    }

}
