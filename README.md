<!-- profe, si ve esto me debe un 10 -->
# TP2-GestorEmails
Alumno: Stefano Merino De Rui

Materia: Paradigmas y Lenguajes de Programación II

Proyecto presentado como Trabajo Práctico 2 en el Ciclo Lectivo 2023 para la materia Paradigmas y Lenguajes de Programación de la carrera Ingeniería en Sistemas de Información, Universidad de la Cuenca del Plata.

## Test
[![Tests](https://github.com/Billones142/TP2-GestorEmails/actions/workflows/Test.yml/badge.svg)](https://github.com/Billones142/TP2-GestorEmails/actions/workflows/Test.yml)
![Badge](https://raw.githubusercontent.com/Billones142/TP2-GestorEmails/reports/badge.svg)

**[Resutados de los test](https://billones142.github.io/TP2-GestorEmails/target/my-reports/index.html)**

**[Code covered(codecov)](https://app.codecov.io/gh/Billones142/TP2-GestorEmails/tree/main/src%2Fmain%2Fjava%2Femail%2Fucp)**

[![Graph](https://codecov.io/gh/Billones142/TP2-GestorEmails/graphs/sunburst.svg?token=1134BUN664)](https://app.codecov.io/gh/Billones142/TP2-GestorEmails/tree/main/src%2Fmain%2Fjava%2Femail%2Fucp)
## Entregables

1. Coloquio personal para presentar/defender el trabajo.
2. Presentación del documento descriptivo con diagrama de completo de clases utilizadas.
3. Enlace a repositorio.
4. Ejecución automática de tests mediante CI (integración continua) mediante Github Actions.

## Consigna
**[Documento sobre el trabajo](https://docs.google.com/document/d/1IlVuJXbe-L9Nft5AmJ_FEfidUGkMvDkb8_xRpqAWgwg/edit#heading=h.la8oy7pbxqvv)**

Desarrollar un sistema de gestión de correo electrónico en Java con TDD:

1. [x] El usuario podrá crear un correo electrónico con:
    - Asunto.
    - Contenido.
    - Remitente.
    - Para (se debe poder enviar a múltiples contactos).
3. [x] Un Contacto es un objeto con:

    - Nombre.
    - Email.
4. [x] Al enviar un correo escrito, este se deberá mover a la Bandeja de Enviados.
5. [x] Se deben poder crear filtros:
    1. [x] Los filtros son carpetas que filtran en base a elementos de los emails (parte del asunto o contenido, remitente o remitentes).
    2. [x] El usuario debe poder buscar correos en la bandeja entrada de manera análoga al funcionamiento de las carpetas.
    3. [x] Los filtros deben tener un nombre.
    4. [x] Se debe poder tene 5 filtros generados (3 de ellos complejos, que puedan buscar 2 o más campos simultáneamente).
  
Otros:

- [x] Aplicación de elementos, artefactos y principios del paradigma orientado a objetos
- [x] Aplicación de elementos,  artefactos y principios del paradigma funcional (en la parte de filtros)
- [x] Realización de flujo de trabajo en GitHub . Repositorio personal
- [ ] Implementación o refactoring de aplicación de principios SOLID
- [x] Implementación de CI en repositorio personal (ejecución de los test)
- [x] Programación basada en test (TDD)
- [x] Cobertura de código más del 90%

  
### escenario completo
Escenario: Gestor de Emails
Se desea que el alumno pueda desarrollar un sistema de gestión de correo electrónico con el lenguaje de programación seleccionado previamente utilizando la técnica de TDD
El sistema de gestión de correo electrónico debe implementar los siguientes historias de usuario
Un usuario podrá crear un correo electrónico, el cual contendrá los siguiente propiedades: Asunto, Contenido, Remitente (un solo contacto), Para (Múltiples contactos)
Un usuario puede enviar un correo a múltiples contactos (puede agregar varios contactos en el Para)
Un Contacto es un objeto que contiene información de Nombre de la persona y Email de dicha persona. Será utilizado para remitente o para enviar a un destinatario o varios destinatarios en el campo Para
Cuando un usuario escribe un correo y lo envía, deberá ir a la Bandeja de Enviados
Se deben poder crear filtros 
Los filtros son carpetas que no contienen correos sino que filtran en base a elementos del email (parte del asunto, parte del contenido, remitente o alguien en para)
Un usuario puede buscar correos en la bandeja de entrada. Lo puede hacer por un texto en cualquiera de los campos textos que tiene (asunto, contenido, remitente o para)
Los filtros deben tener un nombre: 
    * ejemplo “Correos de la UCP”, que deben buscar correos que los haya enviando un email con @ucp.edu.ar
Se requiere poder tener 5 filtros generados (2 o 3 de ellos complejos, es decir que puedan buscar por 2 o más campos simultáneamente)
