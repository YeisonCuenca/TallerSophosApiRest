Feature: Eliminar usuario
  "Como estudiante quiero eliminar un usuario para pasar el taller de sophos"

  Background:
    Given que el usuario cuenta con la api reqres


  @EliminarUser
Scenario Outline: Eliminar usuario exitoso
When se envian los datos de usuario a crear
| name   | job   |
| <name> | <job> |
And el usuario envia la peticion para eliminar usuario
Then la respuesta de la api presenta el codigo 204
Examples:
| name   | job           |
| Roberto| desarrollador |
