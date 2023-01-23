package com.turismouy.model;

public enum EstadoSesion {
    VISITANTE,           // nunca intentó iniciar sesión es visitante
    LOGIN_TURISTA,     // es la sesión iniciada de un Turista
    LOGIN_PROVEEDOR,	// es la sesión iniciada de un Proveedor
    LOGIN_INCORRECTO    // le erro a la sesión al menos una vez
}
