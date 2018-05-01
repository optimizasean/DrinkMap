------------------------------------------------------------------------------------------------------------------------------------------
CREATE FULLTEXT CATALOG FULLTEXT_CATALOG_MIXED_DRINK;  
GO  
CREATE FULLTEXT INDEX ON MIXED_DRINK (   
  NAME 
     Language 1033
)   
	KEY INDEX PK_MIXED_DRINK_ID
		ON FULLTEXT_CATALOG_MIXED_DRINK;   
GO
------------------------------------------------------------------------------------------------------------------------------------------
CREATE FULLTEXT CATALOG FULLTEXT_CATALOG_INGREDIENT;  
GO  
CREATE FULLTEXT INDEX ON INGREDIENT (   
  NAME 
     Language 1033
)   
	KEY INDEX PK_INGREDIENT_ID
		ON FULLTEXT_CATALOG_INGREDIENT;   
GO
------------------------------------------------------------------------------------------------------------------------------------------
CREATE FULLTEXT CATALOG FULLTEXT_CATALOG_BRAND;  
GO  
CREATE FULLTEXT INDEX ON BRAND (   
  NAME 
     Language 1033
)   
	KEY INDEX PK_BRAND_ID
		ON FULLTEXT_CATALOG_BRAND;   
GO
------------------------------------------------------------------------------------------------------------------------------------------