@back-end
  Feature: API Test Cases

    @APITests1
    Scenario Outline: Update User Details
      Given User Performs Put Operation on "/users/" resource to update the user details having "{id}"
      When User updates the body with Required Updates
      | id  | name  | job    |
      | 112 | ankit | tester |
      Then Status code should be "<statusCode>"

      Examples:
        | statusCode |
        |   200      |

    @APITests1
    Scenario Outline: Delete user details
      Given User Performs Delete Operation on "/users/" resource to delete the user details with userId as "{id}"
      When user inputs the following "<id>"
      Then Status code should be "<statusCode>"

      Examples:
        | id  | statusCode |
        | 112 | 204        |

      @APITests2
      Scenario Outline: Create users
        Given User wants to add users on "/users" resources
        When users inputs the user details
        |   name    |   job   |
        |   ankit   |   tester  |
        Then Status code should be "<statusCode>"
        Examples:
        |   statusCode  |
        |   201         |

