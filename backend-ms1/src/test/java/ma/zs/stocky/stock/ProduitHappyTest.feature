Feature: Produit

  Background:
    * url 'http://localhost:8036/api/admin/produit/'


  Scenario: POST Produit and GET it by ID
    * def postBody =
    """
    {
    "reference": "reference-1",
    "barCode": "barCode-1",
    "designation": "designation-1",
    "quantite": "1",
    "prixAchatMoyen": "1",
    "prixVente": "1",
    "pathPhoto": "pathPhoto-1",
    "seuilAlerte": "1",
    "description": "description-1",

    "entrepriseSociete": {"id":"1"},
    "categorie": {"id":"1"},
    "marque": {"id":"1"},
    "uniteMesure": {"id":"1"},


        "stocks": [
            {
                    "produit": {"id":"1"},
                    "depot": {"id":"1"},
                    "quantite": "1",
            },
            {
                    "produit": {"id":"1"},
                    "depot": {"id":"1"},
                    "quantite": "1",
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


  Scenario: DELETE Produit and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




