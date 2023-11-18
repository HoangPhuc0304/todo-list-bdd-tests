@TodoList
Feature: Todo List - Create Operation
	
	Scenario Outline: User adds tasks to the Todo list without blanks
    Given User is on the Todo list application.
    When User adds a task with the title <name1>.
    And Click add button.
    And User adds a task with the title <name2>.
    And Click add button.
    Then The new task <name1> and <name2> should be added to the Todo list.
    And The task amount displayed should be <number>.
    And With notify <message>.
    
    Examples: 
      | name1  			| name2  			| number    	 | message    	|
      | Do exercise | Check email | 2 					 | 2 tasks left |
      |	Do exercise	| Do exercise | 2						 | 2 tasks left |
		
  Scenario Outline: User adds tasks to the Todo list with blanks
    Given User is on the Todo list application.
    When User adds a task with the title <name1>.
    And Click add button.
    And User adds a task with the title <name2>.
    And Click add button.
    Then The task amount displayed should be <number>.
    And With notify <message>.
    
    Examples: 
      | name1  			| name2  			| number    	 | message    	|
      | 						| 						| 0 					 | 0 task left  |
      |	Do exercise	| 						| 1 					 | 1 task left  |