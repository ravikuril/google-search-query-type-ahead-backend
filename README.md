# google-search-query-type-ahead

Its a simple springboot microservice which uses trie data structure to store the searched queries and when user does a query it shows all the completions starting from lattest typed character.
Currently It is working fine with given all the dictonary words. which are stored in main/resource/ as text file.


It does not store all the queries on Database so which makes it usable only for small scale systems.
For all the queries it does process the trie and returns a set of completions.

For scaling purpose trie approach is not much practical. Prefix hash is used in that scenario.


# Frontent Module is developed in React.js
https://github.com/ravikuril/Type-Ahead-frontent-Module 

This module is link to the current microservice and user can type the query and this frontent will communicate with the backened microservice and will show the top K auto complete queries.




