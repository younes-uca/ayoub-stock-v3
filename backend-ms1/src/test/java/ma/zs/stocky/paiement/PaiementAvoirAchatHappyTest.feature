Feature: PaiementAvoirAchat

  Background:
    * url 'http://localhost:8036/api/admin/paiementAvoirAchat/'


  Scenario: POST Paiement avoir achat and GET it by ID
    * def postBody =
    """
    {
    "reference": "reference-1",
    "montant": "1",
    "description": "description-1",

    "achat": {"id":"1"},
    "modePaiement": {"id":"1"},
    "avoirAchat": {"id":"1"},



    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Paiement avoir achat and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




