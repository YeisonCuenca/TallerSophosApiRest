@ObtenerUser
Feature: Obtener usuario
  "Como estudiante quiero obtener uno o varios usuarios para pasar el taller de sophos"


  Background:
    Given que el usuario cuenta con la api reqres

  @ListadoUser
  Scenario: Obtener listado de usuarios
    When se realiza la peticion para listar usuarios
    Then la respuesta de la api presenta el codigo 200
    And en la respuesta debe presentar el campo llamado total con valor 12

  @ObtenerUserId
  Scenario Outline: Obtener usuario por id exitoso
    When se realiza la consulta por id
      | id   |
      | <id> |
    Then la respuesta de la api presenta el codigo 200
    And la respuesta de la api presenta la informacion del usuario
      | id   | email   | first_name   | last_name   |
      | <id> | <email> | <first_name> | <last_name> |
    Examples:
      | id | email                    | first_name | last_name |
      | 11 | george.edwards@reqres.in | George     | Edwards   |


  @ObtenerUserIdFail @BadPath
  Scenario: Obtener usuario por id fallido
    When se realiza la consulta por id 0
    Then la respuesta de la api presenta el codigo 404