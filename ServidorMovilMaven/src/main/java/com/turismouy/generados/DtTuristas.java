
package com.turismouy.generados;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtTuristas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtTuristas">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="turistas" type="{http://presentacion.src/}dtTurista" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtTuristas", propOrder = {
    "turistas"
})
public class DtTuristas {

    @XmlElement(nillable = true)
    protected List<DtTurista> turistas;

    /**
     * Gets the value of the turistas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the turistas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTuristas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtTurista }
     * 
     * 
     * @return
     *     The value of the turistas property.
     */
    public List<DtTurista> getTuristas() {
        if (turistas == null) {
            turistas = new ArrayList<>();
        }
        return this.turistas;
    }

}
