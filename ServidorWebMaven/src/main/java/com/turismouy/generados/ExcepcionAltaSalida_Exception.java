
package com.turismouy.generados;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "ExcepcionAltaSalida", targetNamespace = "http://presentacion.src/")
public class ExcepcionAltaSalida_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ExcepcionAltaSalida faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExcepcionAltaSalida_Exception(String message, ExcepcionAltaSalida faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public ExcepcionAltaSalida_Exception(String message, ExcepcionAltaSalida faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: src.presentacion.ExcepcionAltaSalida
     */
    public ExcepcionAltaSalida getFaultInfo() {
        return faultInfo;
    }

}