Feature: ChequeEffet

  Background:
    * url 'http://localhost:8036/api/admin/chequeEffet/'


  Scenario: POST Cheque effet and GET it by ID
    * def postBody =
    """
    {
    "numeroChequeEffet": "numeroChequeEffet-1",
    "montant": "1",

    "beneficiaire": {"id":"1"},



    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Cheque effet and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




