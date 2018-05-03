------------------------------------------------------------------------------------------------------------------------------------------
CREATE VIEW SEARCH_ALL AS
	SELECT
		MIXED_DRINK.NAME AS MIXED_DRINK_NAME,
		GLASSWARE.NAME AS GLASSWARE_NAME
	FROM MIXED_DRINK
		JOIN GLASSWARE ON MIXED_DRINK.GLASS_ID = GLASSWARE.ID;
GO
------------------------------------------------------------------------------------------------------------------------------------------
CREATE VIEW SEARCH_LOCATION AS
	SELECT
		LOCATION.NAME
	FROM LOCATION;
GO
------------------------------------------------------------------------------------------------------------------------------------------