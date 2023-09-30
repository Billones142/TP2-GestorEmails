# TP2-GestorEmails
alumno: Stefano Merino De Rui

https://billones142.github.io/TP2-GestorEmails/

[![Java test with Maven](https://github.com/Billones142/TP2-GestorEmails/actions/workflows/maven.yml/badge.svg)](https://github.com/Billones142/TP2-GestorEmails/actions/workflows/maven.yml)

# Gestor de Email

Proyecto presentado como Trabajo Práctico 2 en el Ciclo Lectivo 2023 para la materia Paradigmas y Lenguajes de Programación de la carrera Ingeniería en Sistemas de Información, Universidad de la Cuenca del Plata.

## Entregables

1. Coloquio personal para presentar/defender el trabajo.
2. Presentación del documento descriptivo con diagrama de completo de clases utilizadas.
3. Enlace a repositorio.
4. Ejecución automática de tests mediante CI (integración continua) mediante Github Actions.

## Consigna

Desarrollar un sistema de gestión de correo electrónico en Java con TDD:

1. El usuario podrá crear un correo electrónico con:
    - Asunto.
    - Contenido.
    - Remitente.
    - Para (se debe poder enviar a múltiples contactos).
3. Un Contacto es un objeto con:

    - Nombre.
    - Email.
4. Al enviar un correo escrito, este se deberá mover a la Bandeja de Enviados.
5. Se deben poder crear filtros:
    1. Los filtros son carpetas que filtran en base a elementos de los emails (parte del asunto o contenido, remitente o remitentes).
    2. El usuario debe poder buscar correos en la bandeja entrada de manera análoga al funcionamiento de las carpetas.
    3. Los filtros deben tener un nombre.
    4. Se debe poder tene 5 filtros generados (3 de ellos complejos, que puedan buscar 2 o más campos simultáneamente).
