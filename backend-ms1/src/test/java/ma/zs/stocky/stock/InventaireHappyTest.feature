Feature: Inventaire

  Background:
    * url 'http://localhost:8036/api/admin/inventaire/'


  Scenario: POST Inventaire and GET it by ID
    * def postBody =
    """
    {
    "reference": "reference-1",
    "description": "description-1",

    "entrepriseSociete": {"id":"1"},


        "inventaireItems": [
            {
                    "produit": {"id":"1"},
                    "quantiteEstime": "1",
                    "quantiteReelle": "1",
                    "inventaire": {"id":"1"},
            },
            {
                    "produit": {"id":"1"},
                    "quantiteEstime": "1",
                    "quantiteReelle": "1",
                    "inventaire": {"id":"1"},
            }
        ]

    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Inventaire and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




