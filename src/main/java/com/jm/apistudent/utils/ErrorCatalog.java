package com.jm.apistudent.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCatalog {

    STUDENT_NOT_FOUND("STUDENT-404", "Estudiante no encontrado"),
    INVALID_STUDENT("STUDENT-400", "Datos inválidos para el estudiante"),
    GENERIC_ERROR("GEN-500", "Error interno del servidor"),
    STUDENT_EMAIL_ALREADY_EXISTS("STUDENT-EMAIL-409", "El correo ya está registrado");

    private final String code;
    private final String message;
}
