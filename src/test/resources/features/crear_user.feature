Feature: Crear usuario
  "Como estudiante quiero crear un usuario para pasar el taller de sophos"

  Background:
    Given que el usuario cuenta con la api reqres

@CrearUsuario
Scenario Outline: Crear usuario exitoso
When se envian los datos de usuario a crear
| name   | job   |
| <name> | <job> |
Then la respuesta de la api presenta el codigo 201
And en la respuesta la fecha de creacion debe ser la fecha actual
Examples:
| name     | job        |
| santiago | futbolista |
#      | natalia  | analista   |