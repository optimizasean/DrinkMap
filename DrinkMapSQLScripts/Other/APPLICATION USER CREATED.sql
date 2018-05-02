--RAN IN MASTER
CREATE LOGIN [DrinkMap_Application_User] WITH PASSWORD = 'psw321$@pp';
--RAN IN DrinkMap
CREATE USER DrinkMap_Application_User for LOGIN [DrinkMap_Application_User];