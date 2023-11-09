Feature: PaiementVente

  Background:
    * url 'http://localhost:8036/api/admin/paiementVente/'


  Scenario: POST Paiement vente and GET it by ID
    * def postBody =
    """
    {
    "reference": "reference-1",
    "montant": "1",
    "description": "description-1",

    "vente": {"id":"1"},
    "modePaiement": {"id":"1"},



    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Paiement vente and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




