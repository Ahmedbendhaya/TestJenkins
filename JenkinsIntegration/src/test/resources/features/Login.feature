Feature: Vérifier la fonctionnalité de connexion TALAN ACADEMY

  @tag1
  Scenario Outline: Login to TA
    Given We have access to TA
    When i click on the login button
    And tap my <mail> and <password>
    And click on SE CONNECTER
    Then my account must be displayed

    Examples: 
      | mail                                  | password      |
      | ahmed-baha-eddine.ben-dhaya@talan.com | 22080023Ahm@d |
    
