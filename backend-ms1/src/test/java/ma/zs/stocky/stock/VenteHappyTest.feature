Feature: Vente

  Background:
    * url 'http://localhost:8036/api/admin/vente/'


  Scenario: POST Vente and GET it by ID
    * def postBody =
    """
    {
    "codeVente": "codeVente-1",
    "montantHt": "1",
    "montantTva": "1",
    "montantTtc": "1",
    "description": "description-1",

    "entrepriseSociete": {"id":"1"},
    "client": {"id":"1"},
    "etatVente": {"id":"1"},


        "venteItems": [
            {
                    "barCode": "barCode-1",
                    "produit": {"id":"1"},
                    "quantite": "1",
                    "quantiteAvoir": "1",
                    "quantiteVendue": "1",
                    "remise": "1",
                    "prixUnitaireTtc": "1",
                    "tauxTva": {"id":"1"},
                    "prixUnitaireHt": "1",
                    "montantHt": "1",
                    "montantTtc": "1",
                    "vente": {"id":"1"},
                    "depot": {"id":"1"},
            },
            {
                    "barCode": "barCode-1",
                    "produit": {"id":"1"},
                    "quantite": "1",
                    "quantiteAvoir": "1",
                    "quantiteVendue": "1",
                    "remise": "1",
                    "prixUnitaireTtc": "1",
                    "tauxTva": {"id":"1"},
                    "prixUnitaireHt": "1",
                    "montantHt": "1",
                    "montantTtc": "1",
                    "vente": {"id":"1"},
                    "depot": {"id":"1"},
            }
        ]
        "avoirs": [
            {
                    "entrepriseSociete": {"id":"1"},
                    "montant": "1",
                    "vente": {"id":"1"},
            },
            {
                    "entrepriseSociete": {"id":"1"},
                    "montant": "1",
                    "vente": {"id":"1"},
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


  Scenario: DELETE Vente and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




