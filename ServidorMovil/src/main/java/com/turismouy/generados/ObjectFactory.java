
package com.turismouy.generados;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the src.presentacion package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ActividadRepetidaException_QNAME = new QName("http://presentacion.src/", "ActividadRepetidaException");
    private final static QName _DepartamentoRepetidoException_QNAME = new QName("http://presentacion.src/", "DepartamentoRepetidoException");
    private final static QName _ExcepcionAltaCategoria_QNAME = new QName("http://presentacion.src/", "ExcepcionAltaCategoria");
    private final static QName _ExcepcionAltaSalida_QNAME = new QName("http://presentacion.src/", "ExcepcionAltaSalida");
    private final static QName _ExcepcionModificarSalida_QNAME = new QName("http://presentacion.src/", "ExcepcionModificarSalida");
    private final static QName _InscripcionCapacidadExcedidaException_QNAME = new QName("http://presentacion.src/", "InscripcionCapacidadExcedidaException");
    private final static QName _InscripcionYaExisteException_QNAME = new QName("http://presentacion.src/", "InscripcionYaExisteException");
    private final static QName _PaqueteRepetidoException_QNAME = new QName("http://presentacion.src/", "PaqueteRepetidoException");
    private final static QName _SalidasVigentesException_QNAME = new QName("http://presentacion.src/", "SalidasVigentesException");
    private final static QName _UsuarioNoExisteException_QNAME = new QName("http://presentacion.src/", "UsuarioNoExisteException");
    private final static QName _UsuarioRepetidoException_QNAME = new QName("http://presentacion.src/", "UsuarioRepetidoException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: src.presentacion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DtUsuarioExtendido }
     * 
     * @return
     *     the new instance of {@link DtUsuarioExtendido }
     */
    public DtUsuarioExtendido createDtUsuarioExtendido() {
        return new DtUsuarioExtendido();
    }

    /**
     * Create an instance of {@link DtUsuarioExtendido.Seguidos }
     * 
     * @return
     *     the new instance of {@link DtUsuarioExtendido.Seguidos }
     */
    public DtUsuarioExtendido.Seguidos createDtUsuarioExtendidoSeguidos() {
        return new DtUsuarioExtendido.Seguidos();
    }

    /**
     * Create an instance of {@link DtUsuarioExtendido.Seguidores }
     * 
     * @return
     *     the new instance of {@link DtUsuarioExtendido.Seguidores }
     */
    public DtUsuarioExtendido.Seguidores createDtUsuarioExtendidoSeguidores() {
        return new DtUsuarioExtendido.Seguidores();
    }

    /**
     * Create an instance of {@link DtTuristaExtendido }
     * 
     * @return
     *     the new instance of {@link DtTuristaExtendido }
     */
    public DtTuristaExtendido createDtTuristaExtendido() {
        return new DtTuristaExtendido();
    }

    /**
     * Create an instance of {@link DtTuristaExtendido.Inscripciones }
     * 
     * @return
     *     the new instance of {@link DtTuristaExtendido.Inscripciones }
     */
    public DtTuristaExtendido.Inscripciones createDtTuristaExtendidoInscripciones() {
        return new DtTuristaExtendido.Inscripciones();
    }

    /**
     * Create an instance of {@link DtTuristaExtendido.Salidas }
     * 
     * @return
     *     the new instance of {@link DtTuristaExtendido.Salidas }
     */
    public DtTuristaExtendido.Salidas createDtTuristaExtendidoSalidas() {
        return new DtTuristaExtendido.Salidas();
    }

    /**
     * Create an instance of {@link DtProveedorExtendido }
     * 
     * @return
     *     the new instance of {@link DtProveedorExtendido }
     */
    public DtProveedorExtendido createDtProveedorExtendido() {
        return new DtProveedorExtendido();
    }

    /**
     * Create an instance of {@link DtProveedorExtendido.Actividades }
     * 
     * @return
     *     the new instance of {@link DtProveedorExtendido.Actividades }
     */
    public DtProveedorExtendido.Actividades createDtProveedorExtendidoActividades() {
        return new DtProveedorExtendido.Actividades();
    }

    /**
     * Create an instance of {@link DtPaqueteActividadExtendido }
     * 
     * @return
     *     the new instance of {@link DtPaqueteActividadExtendido }
     */
    public DtPaqueteActividadExtendido createDtPaqueteActividadExtendido() {
        return new DtPaqueteActividadExtendido();
    }

    /**
     * Create an instance of {@link DtPaqueteActividadExtendido.Actividades }
     * 
     * @return
     *     the new instance of {@link DtPaqueteActividadExtendido.Actividades }
     */
    public DtPaqueteActividadExtendido.Actividades createDtPaqueteActividadExtendidoActividades() {
        return new DtPaqueteActividadExtendido.Actividades();
    }

    /**
     * Create an instance of {@link DtActividadTuristica }
     * 
     * @return
     *     the new instance of {@link DtActividadTuristica }
     */
    public DtActividadTuristica createDtActividadTuristica() {
        return new DtActividadTuristica();
    }

    /**
     * Create an instance of {@link DtActividadTuristica.Salidas }
     * 
     * @return
     *     the new instance of {@link DtActividadTuristica.Salidas }
     */
    public DtActividadTuristica.Salidas createDtActividadTuristicaSalidas() {
        return new DtActividadTuristica.Salidas();
    }

    /**
     * Create an instance of {@link DtActividadExtendida }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida }
     */
    public DtActividadExtendida createDtActividadExtendida() {
        return new DtActividadExtendida();
    }

    /**
     * Create an instance of {@link DtActividadExtendida.Categorias }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida.Categorias }
     */
    public DtActividadExtendida.Categorias createDtActividadExtendidaCategorias() {
        return new DtActividadExtendida.Categorias();
    }

    /**
     * Create an instance of {@link DtActividadExtendida.Paquetes }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida.Paquetes }
     */
    public DtActividadExtendida.Paquetes createDtActividadExtendidaPaquetes() {
        return new DtActividadExtendida.Paquetes();
    }

    /**
     * Create an instance of {@link DtActividadExtendida.Salidas }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida.Salidas }
     */
    public DtActividadExtendida.Salidas createDtActividadExtendidaSalidas() {
        return new DtActividadExtendida.Salidas();
    }

    /**
     * Create an instance of {@link ActividadRepetidaException }
     * 
     * @return
     *     the new instance of {@link ActividadRepetidaException }
     */
    public ActividadRepetidaException createActividadRepetidaException() {
        return new ActividadRepetidaException();
    }

    /**
     * Create an instance of {@link DepartamentoRepetidoException }
     * 
     * @return
     *     the new instance of {@link DepartamentoRepetidoException }
     */
    public DepartamentoRepetidoException createDepartamentoRepetidoException() {
        return new DepartamentoRepetidoException();
    }

    /**
     * Create an instance of {@link ExcepcionAltaCategoria }
     * 
     * @return
     *     the new instance of {@link ExcepcionAltaCategoria }
     */
    public ExcepcionAltaCategoria createExcepcionAltaCategoria() {
        return new ExcepcionAltaCategoria();
    }

    /**
     * Create an instance of {@link ExcepcionAltaSalida }
     * 
     * @return
     *     the new instance of {@link ExcepcionAltaSalida }
     */
    public ExcepcionAltaSalida createExcepcionAltaSalida() {
        return new ExcepcionAltaSalida();
    }

    /**
     * Create an instance of {@link ExcepcionModificarSalida }
     * 
     * @return
     *     the new instance of {@link ExcepcionModificarSalida }
     */
    public ExcepcionModificarSalida createExcepcionModificarSalida() {
        return new ExcepcionModificarSalida();
    }

    /**
     * Create an instance of {@link InscripcionCapacidadExcedidaException }
     * 
     * @return
     *     the new instance of {@link InscripcionCapacidadExcedidaException }
     */
    public InscripcionCapacidadExcedidaException createInscripcionCapacidadExcedidaException() {
        return new InscripcionCapacidadExcedidaException();
    }

    /**
     * Create an instance of {@link InscripcionYaExisteException }
     * 
     * @return
     *     the new instance of {@link InscripcionYaExisteException }
     */
    public InscripcionYaExisteException createInscripcionYaExisteException() {
        return new InscripcionYaExisteException();
    }

    /**
     * Create an instance of {@link PaqueteRepetidoException }
     * 
     * @return
     *     the new instance of {@link PaqueteRepetidoException }
     */
    public PaqueteRepetidoException createPaqueteRepetidoException() {
        return new PaqueteRepetidoException();
    }

    /**
     * Create an instance of {@link SalidasVigentesException }
     * 
     * @return
     *     the new instance of {@link SalidasVigentesException }
     */
    public SalidasVigentesException createSalidasVigentesException() {
        return new SalidasVigentesException();
    }

    /**
     * Create an instance of {@link UsuarioNoExisteException }
     * 
     * @return
     *     the new instance of {@link UsuarioNoExisteException }
     */
    public UsuarioNoExisteException createUsuarioNoExisteException() {
        return new UsuarioNoExisteException();
    }

    /**
     * Create an instance of {@link UsuarioRepetidoException }
     * 
     * @return
     *     the new instance of {@link UsuarioRepetidoException }
     */
    public UsuarioRepetidoException createUsuarioRepetidoException() {
        return new UsuarioRepetidoException();
    }

    /**
     * Create an instance of {@link DtActividades }
     * 
     * @return
     *     the new instance of {@link DtActividades }
     */
    public DtActividades createDtActividades() {
        return new DtActividades();
    }

    /**
     * Create an instance of {@link DtActividadesExtendidas }
     * 
     * @return
     *     the new instance of {@link DtActividadesExtendidas }
     */
    public DtActividadesExtendidas createDtActividadesExtendidas() {
        return new DtActividadesExtendidas();
    }

    /**
     * Create an instance of {@link DtCategoria }
     * 
     * @return
     *     the new instance of {@link DtCategoria }
     */
    public DtCategoria createDtCategoria() {
        return new DtCategoria();
    }

    /**
     * Create an instance of {@link DtCategorias }
     * 
     * @return
     *     the new instance of {@link DtCategorias }
     */
    public DtCategorias createDtCategorias() {
        return new DtCategorias();
    }

    /**
     * Create an instance of {@link DtDepartamento }
     * 
     * @return
     *     the new instance of {@link DtDepartamento }
     */
    public DtDepartamento createDtDepartamento() {
        return new DtDepartamento();
    }

    /**
     * Create an instance of {@link DtDepartamentos }
     * 
     * @return
     *     the new instance of {@link DtDepartamentos }
     */
    public DtDepartamentos createDtDepartamentos() {
        return new DtDepartamentos();
    }

    /**
     * Create an instance of {@link DtInscripcion }
     * 
     * @return
     *     the new instance of {@link DtInscripcion }
     */
    public DtInscripcion createDtInscripcion() {
        return new DtInscripcion();
    }

    /**
     * Create an instance of {@link DtInscripciones }
     * 
     * @return
     *     the new instance of {@link DtInscripciones }
     */
    public DtInscripciones createDtInscripciones() {
        return new DtInscripciones();
    }

    /**
     * Create an instance of {@link DtPaqueteActividad }
     * 
     * @return
     *     the new instance of {@link DtPaqueteActividad }
     */
    public DtPaqueteActividad createDtPaqueteActividad() {
        return new DtPaqueteActividad();
    }

    /**
     * Create an instance of {@link DtProveedor }
     * 
     * @return
     *     the new instance of {@link DtProveedor }
     */
    public DtProveedor createDtProveedor() {
        return new DtProveedor();
    }

    /**
     * Create an instance of {@link DtProveedores }
     * 
     * @return
     *     the new instance of {@link DtProveedores }
     */
    public DtProveedores createDtProveedores() {
        return new DtProveedores();
    }

    /**
     * Create an instance of {@link DtSalidaTuristica }
     * 
     * @return
     *     the new instance of {@link DtSalidaTuristica }
     */
    public DtSalidaTuristica createDtSalidaTuristica() {
        return new DtSalidaTuristica();
    }

    /**
     * Create an instance of {@link DtSalidas }
     * 
     * @return
     *     the new instance of {@link DtSalidas }
     */
    public DtSalidas createDtSalidas() {
        return new DtSalidas();
    }

    /**
     * Create an instance of {@link DtTurista }
     * 
     * @return
     *     the new instance of {@link DtTurista }
     */
    public DtTurista createDtTurista() {
        return new DtTurista();
    }

    /**
     * Create an instance of {@link DtTuristas }
     * 
     * @return
     *     the new instance of {@link DtTuristas }
     */
    public DtTuristas createDtTuristas() {
        return new DtTuristas();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     * @return
     *     the new instance of {@link DtUsuario }
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link DtUsuarios }
     * 
     * @return
     *     the new instance of {@link DtUsuarios }
     */
    public DtUsuarios createDtUsuarios() {
        return new DtUsuarios();
    }

    /**
     * Create an instance of {@link DtUsuarioExtendido.Seguidos.Entry }
     * 
     * @return
     *     the new instance of {@link DtUsuarioExtendido.Seguidos.Entry }
     */
    public DtUsuarioExtendido.Seguidos.Entry createDtUsuarioExtendidoSeguidosEntry() {
        return new DtUsuarioExtendido.Seguidos.Entry();
    }

    /**
     * Create an instance of {@link DtUsuarioExtendido.Seguidores.Entry }
     * 
     * @return
     *     the new instance of {@link DtUsuarioExtendido.Seguidores.Entry }
     */
    public DtUsuarioExtendido.Seguidores.Entry createDtUsuarioExtendidoSeguidoresEntry() {
        return new DtUsuarioExtendido.Seguidores.Entry();
    }

    /**
     * Create an instance of {@link DtTuristaExtendido.Inscripciones.Entry }
     * 
     * @return
     *     the new instance of {@link DtTuristaExtendido.Inscripciones.Entry }
     */
    public DtTuristaExtendido.Inscripciones.Entry createDtTuristaExtendidoInscripcionesEntry() {
        return new DtTuristaExtendido.Inscripciones.Entry();
    }

    /**
     * Create an instance of {@link DtTuristaExtendido.Salidas.Entry }
     * 
     * @return
     *     the new instance of {@link DtTuristaExtendido.Salidas.Entry }
     */
    public DtTuristaExtendido.Salidas.Entry createDtTuristaExtendidoSalidasEntry() {
        return new DtTuristaExtendido.Salidas.Entry();
    }

    /**
     * Create an instance of {@link DtProveedorExtendido.Actividades.Entry }
     * 
     * @return
     *     the new instance of {@link DtProveedorExtendido.Actividades.Entry }
     */
    public DtProveedorExtendido.Actividades.Entry createDtProveedorExtendidoActividadesEntry() {
        return new DtProveedorExtendido.Actividades.Entry();
    }

    /**
     * Create an instance of {@link DtPaqueteActividadExtendido.Actividades.Entry }
     * 
     * @return
     *     the new instance of {@link DtPaqueteActividadExtendido.Actividades.Entry }
     */
    public DtPaqueteActividadExtendido.Actividades.Entry createDtPaqueteActividadExtendidoActividadesEntry() {
        return new DtPaqueteActividadExtendido.Actividades.Entry();
    }

    /**
     * Create an instance of {@link DtActividadTuristica.Salidas.Entry }
     * 
     * @return
     *     the new instance of {@link DtActividadTuristica.Salidas.Entry }
     */
    public DtActividadTuristica.Salidas.Entry createDtActividadTuristicaSalidasEntry() {
        return new DtActividadTuristica.Salidas.Entry();
    }

    /**
     * Create an instance of {@link DtActividadExtendida.Categorias.Entry }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida.Categorias.Entry }
     */
    public DtActividadExtendida.Categorias.Entry createDtActividadExtendidaCategoriasEntry() {
        return new DtActividadExtendida.Categorias.Entry();
    }

    /**
     * Create an instance of {@link DtActividadExtendida.Paquetes.Entry }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida.Paquetes.Entry }
     */
    public DtActividadExtendida.Paquetes.Entry createDtActividadExtendidaPaquetesEntry() {
        return new DtActividadExtendida.Paquetes.Entry();
    }

    /**
     * Create an instance of {@link DtActividadExtendida.Salidas.Entry }
     * 
     * @return
     *     the new instance of {@link DtActividadExtendida.Salidas.Entry }
     */
    public DtActividadExtendida.Salidas.Entry createDtActividadExtendidaSalidasEntry() {
        return new DtActividadExtendida.Salidas.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActividadRepetidaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActividadRepetidaException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "ActividadRepetidaException")
    public JAXBElement<ActividadRepetidaException> createActividadRepetidaException(ActividadRepetidaException value) {
        return new JAXBElement<>(_ActividadRepetidaException_QNAME, ActividadRepetidaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepartamentoRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DepartamentoRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "DepartamentoRepetidoException")
    public JAXBElement<DepartamentoRepetidoException> createDepartamentoRepetidoException(DepartamentoRepetidoException value) {
        return new JAXBElement<>(_DepartamentoRepetidoException_QNAME, DepartamentoRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionAltaCategoria }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExcepcionAltaCategoria }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "ExcepcionAltaCategoria")
    public JAXBElement<ExcepcionAltaCategoria> createExcepcionAltaCategoria(ExcepcionAltaCategoria value) {
        return new JAXBElement<>(_ExcepcionAltaCategoria_QNAME, ExcepcionAltaCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionAltaSalida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExcepcionAltaSalida }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "ExcepcionAltaSalida")
    public JAXBElement<ExcepcionAltaSalida> createExcepcionAltaSalida(ExcepcionAltaSalida value) {
        return new JAXBElement<>(_ExcepcionAltaSalida_QNAME, ExcepcionAltaSalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionModificarSalida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExcepcionModificarSalida }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "ExcepcionModificarSalida")
    public JAXBElement<ExcepcionModificarSalida> createExcepcionModificarSalida(ExcepcionModificarSalida value) {
        return new JAXBElement<>(_ExcepcionModificarSalida_QNAME, ExcepcionModificarSalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscripcionCapacidadExcedidaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InscripcionCapacidadExcedidaException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "InscripcionCapacidadExcedidaException")
    public JAXBElement<InscripcionCapacidadExcedidaException> createInscripcionCapacidadExcedidaException(InscripcionCapacidadExcedidaException value) {
        return new JAXBElement<>(_InscripcionCapacidadExcedidaException_QNAME, InscripcionCapacidadExcedidaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscripcionYaExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InscripcionYaExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "InscripcionYaExisteException")
    public JAXBElement<InscripcionYaExisteException> createInscripcionYaExisteException(InscripcionYaExisteException value) {
        return new JAXBElement<>(_InscripcionYaExisteException_QNAME, InscripcionYaExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaqueteRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaqueteRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "PaqueteRepetidoException")
    public JAXBElement<PaqueteRepetidoException> createPaqueteRepetidoException(PaqueteRepetidoException value) {
        return new JAXBElement<>(_PaqueteRepetidoException_QNAME, PaqueteRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalidasVigentesException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SalidasVigentesException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "SalidasVigentesException")
    public JAXBElement<SalidasVigentesException> createSalidasVigentesException(SalidasVigentesException value) {
        return new JAXBElement<>(_SalidasVigentesException_QNAME, SalidasVigentesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "UsuarioNoExisteException")
    public JAXBElement<UsuarioNoExisteException> createUsuarioNoExisteException(UsuarioNoExisteException value) {
        return new JAXBElement<>(_UsuarioNoExisteException_QNAME, UsuarioNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://presentacion.src/", name = "UsuarioRepetidoException")
    public JAXBElement<UsuarioRepetidoException> createUsuarioRepetidoException(UsuarioRepetidoException value) {
        return new JAXBElement<>(_UsuarioRepetidoException_QNAME, UsuarioRepetidoException.class, null, value);
    }

}
