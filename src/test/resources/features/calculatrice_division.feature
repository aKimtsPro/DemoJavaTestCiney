Feature: Calcatrice division
  L'utilisateur veut réaliser une division

  Scenario: division success
    Given division de 4 par 2
    When Je demande si la reponse réelle vaut 2.0
    Then On devrait me dire oui