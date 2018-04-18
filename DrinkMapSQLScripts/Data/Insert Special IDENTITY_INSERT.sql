------------------------------------------------------------------------------------------------------------------------------------------
SET IDENTITY_INSERT [dbo].BRAND ON;
INSERT INTO BRAND(ID, NAME) VALUES(0, 'N/A');
SET IDENTITY_INSERT [dbo].BRAND OFF;
------------------------------------------------------------------------------------------------------------------------------------------
SET IDENTITY_INSERT [dbo].GARNISH ON;
INSERT INTO GARNISH(ID, TYPE) VALUES(0, 'N/A');
SET IDENTITY_INSERT [dbo].GARNISH OFF;
------------------------------------------------------------------------------------------------------------------------------------------
SET IDENTITY_INSERT [dbo].GLASSWARE ON;
INSERT INTO GLASSWARE(ID, NAME, DESCRIPTION) VALUES(0, 'N/A', NULL);
SET IDENTITY_INSERT [dbo].GLASSWARE OFF;
------------------------------------------------------------------------------------------------------------------------------------------
SET IDENTITY_INSERT [dbo].INGREDIENT_TYPE ON;
INSERT INTO INGREDIENT_TYPE(ID, CATEGORY) VALUES(0, 'N\A');
SET IDENTITY_INSERT [dbo].INGREDIENT_TYPE OFF;
------------------------------------------------------------------------------------------------------------------------------------------