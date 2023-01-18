Feature: Calculatrice addition
  L'utilisateur veut interagir avec la calculatrice

  Scenario: addition success
    Given addition de 5 et 4
    When Je demande si la reponse entière vaut 9
    Then On devrait me dire oui

  Scenario: addition failure
    Given addition de 5 et 9
    When Je demande si la reponse entière vaut 11
    Then On devrait me dire non