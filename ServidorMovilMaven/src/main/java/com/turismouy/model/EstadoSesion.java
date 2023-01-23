package com.turismouy.model;

public enum EstadoSesion {
	NO_LOGIN, 
    LOGIN_CORRECTO,     // es la sesión iniciada de un Turista
    LOGIN_INCORRECTO,
    LOGIN_PROVEEDOR// le erro a la sesión al menos una vez
}
