Feature: TauxTva

  Background:
    * url 'http://localhost:8036/api/admin/tauxTva/'


  Scenario: POST Taux tva and GET it by ID
    * def postBody =
    """
    {
    "libelle": "libelle-1",
    "montant": "1",
    "code": "code-1",




    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Taux tva and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




